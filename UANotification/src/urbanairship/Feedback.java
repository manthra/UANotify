
package urbanairship;

import java.util.*;

public class Feedback implements java.io.Serializable
{
	private String deviceToken;
	private Calendar markedInactiveOn;
	private String alias;
	
	public String getDeviceToken()
	{
		return deviceToken;
	}
	
	public void setDeviceToken(String deviceToken)
	{
		this.deviceToken = deviceToken;
	}
	
	public Calendar getMarkedInactiveOn()
	{
		return markedInactiveOn;
	}
	
	public void setMarkedInactiveOn(Calendar markedInactiveOn)
	{
		this.markedInactiveOn = markedInactiveOn;
	}
	
	public String getAlias()
	{
		return alias;
	}
	
	public void setAlias(String alias)
	{
		this.alias = alias;
	}
	
	
}
