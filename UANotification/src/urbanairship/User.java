
package urbanairship;

import java.util.*;

public class User implements java.io.Serializable
{
	private boolean airmail = false;
	private String alias;
	private List<String> tags = new ArrayList<String>();
	private List<String> deviceTokens = new ArrayList<String>();
	private String udid;  // Universal Device Id
	
	public boolean isAirmail()
	{
		return airmail;
	}
	
	public void setAirmail(boolean airmail)
	{
		this.airmail = airmail;
	}
	
	public String getAlias()
	{
		return alias;
	}
	
	public void setAlias(String alias)
	{
		this.alias = alias;
	}
	
	public List<String> getTags()
	{
		return tags;
	}
	
	public void setTags(List<String> tags)
	{
		this.tags = tags;
	}
	
	public List<String> getDeviceTokens()
	{
		return deviceTokens;
	}
	
	public void setDeviceTokens(List<String> deviceTokens)
	{
		this.deviceTokens = deviceTokens;
	}
	
	public String getUdid()
	{
		return udid;
	}
	
	public void setUdid(String udid)
	{
		this.udid = udid;
	}

	
}
