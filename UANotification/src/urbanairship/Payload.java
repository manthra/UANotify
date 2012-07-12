
package urbanairship;

import java.util.*;

public class Payload implements java.io.Serializable
{
	private List<String> deviceTokens = new ArrayList<String>();
	private APS aps;
	
	public List<String> getDeviceTokens()
	{
		return deviceTokens;
	}
	
	public void setDeviceTokens(List<String> deviceTokens)
	{
		this.deviceTokens = deviceTokens;
	}
	
	public APS getAps()
	{
		return aps;
	}
	
	public void setAps(APS aps)
	{
		this.aps = aps;
	}
	
	
}
