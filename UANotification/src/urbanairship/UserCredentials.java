
package urbanairship;

public class UserCredentials implements java.io.Serializable
{
	private String userUrl;
	private String userId;
	private String password;
	
	public String getUserUrl()
	{
		return userUrl;
	}
	
	public void setUserUrl(String userUrl)
	{
		this.userUrl = userUrl;
	}
	
	public String getUserId()
	{
		return userId;
	}
	
	public void setUserId(String userId)
	{
		this.userId = userId;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String toString()
	{
		return this.getUserId();
	}
	
}
