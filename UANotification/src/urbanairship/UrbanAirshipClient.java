
package urbanairship;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

import org.apache.http.*;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.client.params.AllClientPNames;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

/**
 * 
 * 
 *  Urban Airship REST API client
 *
 *  @see http://www.urbanairship.com/docs
 *  
 */
public class UrbanAirshipClient
{
	private static final String CHARSET = "UTF-8";
	private static final int DEFAULT_CONNECTION_TIMEOUT = (10 * 1000); // milliseconds
	private static final int DEFAULT_SOCKET_TIMEOUT = (30 * 1000); // milliseconds

	private String username;
	private String password;
	private HttpClient httpClient;
	
	public UrbanAirshipClient(String username, String password)
	{
		this(username, password, null);
		
		setSocketTimeout(DEFAULT_SOCKET_TIMEOUT);
		
		setConnectionTimeout(DEFAULT_CONNECTION_TIMEOUT);
		
	}
	
	public UrbanAirshipClient(String username, String password, HttpClient hc)
	{
		this.username = username;
		this.password = password;
		this.httpClient = hc;
	}

	public void register(Device dev)
	{
		
		String identifier = dev.getIdentifier();
		String path = dev.getPath();
		
		if ( (identifier == null) || (identifier.trim().length() == 0) )
		{
			throw new IllegalStateException("missing device identifier");
		}
		
		put("/api/" 
				+ path 
				+ "/" 
				+ encode(identifier), 
				dev);
	}
	
	
	public void addTagToDevice(Device device, String tag)
	{
		if (tag.length() > 255)
		{
			throw new IllegalArgumentException("maximum tag length is 255. Tag: " + tag);
		}
		
		put("/api/device_tokens/" + encode(device.getIdentifier()) + "/tags/" + encode(tag));
	}
	
	
	public void removeTagFromDevice(String deviceToken, String tag)
	{
		delete("/api/device_tokens/" + encode(deviceToken) + "/tags/" + encode(tag));
	}

	/**
	 * 
	 * 
	 * @return may return null
	 * 
	 */
	public PushResponse sendPushNotifications(Push... p)
	{
		Class<PushResponse> responseClazz = PushResponse.class;
		
		PushResponse result = null;
		
		if (p.length == 0)
		{
			throw new IllegalArgumentException("parameter p");
		}
		else if (p.length == 1)
		{
			// single push notification
			result = post("/api/push/", p[0], responseClazz);
		}
		else
		{
			// batch of push notifications
			result = post("/api/push/batch/", p, responseClazz);
		}
		
		return result;
	}
	

	public List<String> getTags()
	{
		TagsResponse resp = get(TagsResponse.class, "/api/tags");

		if (resp == null)
		{
			return new ArrayList<String>();
		}
		else
		{
			return resp.tags;
		}
	}
	
	
	public List<String> getTagsForDevice(String deviceToken)
	{
		TagsResponse resp = get(TagsResponse.class, "/api/device_tokens/" + encode(deviceToken) + "/tags");
		
		if (resp == null)
		{
			return new ArrayList<String>();
		}
		else
		{
			return resp.tags;
		}
	}
	
	public UserCredentials create(User u)
	{
		return post("/api/user/", u, UserCredentials.class);
	}
	
	public void updateUserByUserId(User u, String userid)
	{
		if (userid == null)
		{
			throw new IllegalArgumentException("userid parameter is null");
		}
		
		put("/api/user/" + userid + "/", u);
	}
	
	public void updateUserByAlias(User u, String alias)
	{
		if (alias == null)
		{
			throw new IllegalArgumentException("alias parameter is null");
		}
		put("/api/user/alias/" + alias + "/", u);
	}
	
	public UserCredentials reset(UserCredentials creds)
	{
		return post("/api/user/" + creds.getUserId() + "/creds/reset/", creds, UserCredentials.class);
	}
	
	public void deleteUser(String userId)
	{
		delete("/api/user/" + userId + "/");
	}
	
	public void deleteMessage(Message m)
	{
		delete(m.getMessageUrl());
	}
	
	public void deleteMessages(final Message...msgs)
	{
		String[] urls = new String[msgs.length];
		
		for (int i = 0; i < msgs.length; i++)
		{
			urls[i] = msgs[i].getMessageUrl();
		}
		
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("delete", urls);
		
		post("/api/user/" + this.username + "/messages/delete/", map);
	}
	
	public void send(Airmail airmail)
	{
		post("/api/airmail/send/", airmail);
	}
	
	public void send(List<Airmail> airmailList)
	{
		post("/api/airmail/send/batch/", airmailList);
	}
	
	public Messages getMessagesByUserId(String userId, boolean fullList)
	{
		String uri = "/api/user/" + userId + "/messages/";
		
		if (fullList)
		{
			uri += "?full_list=true";
		}
		
		return get(Messages.class, uri);
	}
	
	public Messages getMessages()
	{
		return getMessages(true);
	}
	
	public Messages getMessages(boolean fullList)
	{
		return getMessagesByUserId(this.username, fullList);
	}
	
	public String getMessageBody(String messageBodyUrl)
	{
		return getString(messageBodyUrl);
	}
	
	public Message getMessage(String messageUrl)
	{
		return get(Message.class, messageUrl);
	}
	
	public void markAsRead(String userId, final Message... msgs)
	{
		if (msgs.length == 0)
		{
			throw new IllegalArgumentException("msgs.length is zero");
		}
		else if (msgs.length == 1)
		{
			post(msgs[0].getMessageReadUrl(), null);
		}
		else
		{
			String[] urls = new String[msgs.length];
			for (int i = 0; i < msgs.length; i++)
			{
				urls[i] = msgs[i].getMessageReadUrl();
			}
			Map<String, String[]> map = new HashMap<String, String[]>();
			map.put("mark_as_read", urls);
			
			post("/api/user/" + this.username + "/messages/unread/", map);
		}
	}
	
	public void sendToAllUsers(Airmail airmail)
	{
		post("/api/airmail/send/broadcast/", airmail);
	}
	
	protected void put(String path)
	{
		put(path, null);
	}
	
	protected void put(String path, Object requestBodyObject)
	{
		HttpPut put = createHttpPut(path);
		
		if (requestBodyObject != null)
		{
			put.setEntity(toJsonEntity(requestBodyObject));
		}
		
		execute(put);
	}
	
	
	protected void post(String path, Object requestBodyObject)
	{
		post(path, requestBodyObject, null);
	}
	
	protected HttpPut createHttpPut(String path)
	{
		HttpPut put = new HttpPut(getUrlForPath(path));
		return put;
	}

	public Device getDevice(String deviceToken)
	{
		return get(Device.class, "/api/device_tokens/" + encode(deviceToken)); 
	}
	
	public DeviceTokensResponse getDeviceTokens()
	{
		return get(DeviceTokensResponse.class, "/api/device_tokens/"); 
	}
	
	protected HttpGet createHttpGet(String path)
	{
		HttpGet get = new HttpGet(this.getUrlForPath(path));
		return get;
	}

	public void cancelScheduledNotifications(String... scheduledNotificationUrls)
	{
		Map<String, String[]> cancelMap = new HashMap<String, String[]>();
		cancelMap.put("cancel", scheduledNotificationUrls);
		
		post("https://" + getHostname() + "/api/push/scheduled/", cancelMap);
		
	}
	
	public void broadcast(Broadcast b)
	{
		post("/api/push/broadcast/", b);
	}
	
	protected <T> T post(final String path, final Object obj, final Class<T> responseType)
	{
		
		HttpPost post = createHttpPost(path);
		
		if (obj != null)
		{
			post.setEntity(toJsonEntity(obj));
		}
		
		HttpResponse response = execute(post);

		if (responseType == null)
		{
			return null;
		}
		else
		{
			return fromJson(response, responseType);
		}
	}

	protected HttpEntity toJsonEntity(final Object obj)
	{
		
		String json = toJson(obj);
		
		try
		{
			return new JsonEntity(json);
		}
		catch (Exception ex)
		{
			Class clazz = null;
			if (obj != null)
			{
				clazz = obj.getClass();
			}
			throw new RuntimeException("failure, obj class=" + clazz, ex);
		}
		
	}

	protected void checkResponse(HttpRequest request, HttpResponse response)
	{
		boolean hasError = false;
		
		try
		{
			StatusLine status = response.getStatusLine();
			
			int statusCode = status.getStatusCode();
			
		
			if (statusCode == 404)
			{
				hasError = true;
				throw new NotFoundException(status.getReasonPhrase());
			}
			else if ( (statusCode < 200) || (statusCode > 299) )
			{
				hasError = true;
				
				StringBuilder msg = new StringBuilder();
				
				msg.append("statusCode=" + statusCode);
				
				msg.append("\n");
				
				msg.append("method=" + request.getRequestLine().getMethod());
				
				msg.append("\n");
				
				msg.append(request.getRequestLine().getUri());
				
				
				HttpEntity responseEntity = response.getEntity();
				
				try
				{
					String responseBody = EntityUtils.toString(responseEntity);
					msg.append("\n");
					msg.append("responseBody=" + responseBody);
				}
				catch (Exception ignored)
				{
					// ignored
				}

				throw new RuntimeException("unexpected response\n" + msg);
			}
		}
		finally
		{
			if (hasError)
			{
				close(response);
			}
		}
	}

	private void close(final HttpResponse resp)
	{
		if (resp != null)
		{
			try
			{
				close(resp.getEntity());
			}
			catch (Exception ignored)
			{
				// ignored
			}
		}
	}
	
	private void close(final HttpEntity responseEntity)
	{
		if (responseEntity != null)
		{
			try
			{
				responseEntity.consumeContent();
			}
			catch (Exception ignored)
			{
				// ignored
			}
		}
	}

	protected <T> T fromJson(HttpResponse rsp, Class<T> clazz)
	{
		if (clazz == null)
		{
			return null;
		}
		
		if (rsp.getEntity() == null)
		{
			return null;
		}
		
		try
		{
			String responseBody = EntityUtils.toString(rsp.getEntity());
			return fromJson(responseBody, clazz);
		}
		catch (RuntimeException rtex)
		{
			throw rtex;
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
		finally
		{
			close(rsp);
		}
	}
	
	public List<Stat> getPushStats(Calendar start, Calendar end)
	{
		// TODO 
		return null;
	}
	
	protected HttpResponse execute(HttpRequestBase method)
	{
		try
		{
			method.setHeader(new BasicHeader("Accept", "application/json"));
			HttpResponse rsp = getHttpClient().execute(method);
			checkResponse(method, rsp);
			return rsp;
		}
		catch (RuntimeException rtex)
		{
			throw rtex;
		}
		catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}
	}

	protected HttpClient getHttpClient()
	{
		if (this.httpClient == null)
		{
			this.httpClient = createHttpClient();
		}
		return this.httpClient;
	}
	
	protected HttpClient createHttpClient()
	{
		DefaultHttpClient client = new DefaultHttpClient();
		
		client.getParams().setParameter(AllClientPNames.USER_AGENT, "urbanairship-java library");

		CredentialsProvider credProvider = new BasicCredentialsProvider();
		
		credProvider.setCredentials(
		    new AuthScope(getHostname(), AuthScope.ANY_PORT), 
		    new UsernamePasswordCredentials(getUsername(), getPassword()));
		
		client.setCredentialsProvider(credProvider);
		
		return client;
	}

	protected String getUsername()
	{
		return this.username;
	}

	protected String getPassword()
	{
		return this.password;
	}

	private HttpPost createHttpPost(final String path)
	{
		String url = getUrlForPath(path);
		
		HttpPost post = new HttpPost(url);
		
		return post;
	}

	protected String getUrlForPath(final String path)
	{
		if (path.startsWith("http://") || (path.startsWith("https://")))
		{
			return path;
		}
		else
		{
			return "https://" 
				+ getHostname()
				+ path;
		}
	}

	protected String getHostname()
	{
		return "go.urbanairship.com";
	}
	
	public FeedbackList getFeedback(final long since)
	{
		if (since < 0)
		{
			throw new IllegalArgumentException("since parameter: " + since);
		}
		
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(since);
		return getFeedback(c);
	}
	
	public FeedbackList getFeedback(final Calendar since)
	{
		FeedbackList feedbackList = get(
						FeedbackList.class,
						"/api/device_tokens/feedback/",
						"since", 
						ISO8601.toString(since));
		
		return feedbackList;
	}

	protected String getString(final String path, final String... parameters)
	{
		HttpGet get = createHttpGet(path);
		
		HttpResponse rsp = this.execute(get);
		
		return toString(rsp);
	}
	
	protected String toString(HttpResponse rsp)
	{
		try
		{
			return EntityUtils.toString(rsp.getEntity());
		}
		catch (java.io.IOException ex)
		{
			throw new RuntimeException(ex);
		}
		finally
		{
			close(rsp);
		}
	}
	
	protected <T> T get(final Class<T> clazz, final String path, final String... parameters)
	{
		HttpGet get = createHttpGet(path);
		
		HttpResponse rsp = this.execute(get);
		
		return fromJson(rsp, clazz);
	}
	
	protected <T> String toJson(final T object)
	{
		if (object == null)
		{
			throw new IllegalArgumentException("object parameter is null");
		}
		
		Gson gson = GsonFactory.create();
		return gson.toJson(object);
	}
	
	protected <T> T fromJson(final String json, final Class<T> clazz)
	{
		Gson gson = GsonFactory.create();
		return gson.fromJson(json, clazz);
	}

	protected void delete(final String path)
	{
		HttpDelete delete = createHttpDelete(path);
		execute(delete);
	}

	private HttpDelete createHttpDelete(final String path)
	{
		HttpDelete delete = new HttpDelete(getUrlForPath(path));
		return delete;
	}

	protected String encode(String s)
	{
		try
		{
			return URLEncoder.encode(s, "UTF-8");
		}
		catch (UnsupportedEncodingException e)
		{
			throw new RuntimeException(e);
		}
	}

	static private class JsonEntity extends StringEntity
	{
		
		public JsonEntity(String jsonString) throws UnsupportedEncodingException
		{
			super(jsonString, CHARSET);
		}
		
		
		@Override
		public Header getContentType()
		{
			Header h = new BasicHeader("Content-Type", "application/json");
			return h;
		}
		
	}

	public void setUserAgent(String agentString)
	{
		if (agentString == null)
		{
			this.getHttpClient().getParams().removeParameter(AllClientPNames.USER_AGENT);
		}
		else
		{
			this.getHttpClient().getParams().setParameter(AllClientPNames.USER_AGENT, agentString);
		}
	}
	
	public void shutdown()
	{
		if (this.getHttpClient() != null)
		{
			try
			{
				this.getHttpClient().getConnectionManager().shutdown();
			}
			catch (Exception ignored)
			{
				// ignored
			}
		}
	}
	
	public void setConnectionTimeout(int milliseconds)
	{
		getHttpClient().getParams().setIntParameter(AllClientPNames.CONNECTION_TIMEOUT, milliseconds);
	}
	
	public void setSocketTimeout(int milliseconds)
	{
		getHttpClient().getParams().setIntParameter(AllClientPNames.SO_TIMEOUT, milliseconds);
	}
	
}
