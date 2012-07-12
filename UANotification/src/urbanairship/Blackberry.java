
package urbanairship;

import com.google.gson.annotations.SerializedName;

public class Blackberry implements java.io.Serializable
{
	@SerializedName("content-type")
	private String contentType;
	
	private String body;
	
	
	public String getContentType()
	{
		return contentType;
	}


	public void setContentType(String ct)
	{
		this.contentType = ct;
	}


	public String getBody()
	{
		return body;
	}


	public void setBody(String b)
	{
		this.body = b;
	}


	public String toString()
	{
		return this.getBody();
	}
	
	
}
