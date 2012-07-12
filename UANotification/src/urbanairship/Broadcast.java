	
package urbanairship;

import java.util.*;

public class Broadcast implements java.io.Serializable
{
	private APS aps;
	private Calendar scheduleFor; // schedule_for is optional
	private List<String> excludeTokens = new ArrayList<String>();
	
	public APS getAps()
	{
		return aps;
	}
	
	public void setAps(APS aps)
	{
		this.aps = aps;
	}
	
	public Calendar getScheduleFor()
	{
		return scheduleFor;
	}
	
	public void setScheduleFor(Calendar sfor)
	{
		this.scheduleFor = sfor;
	}
	
	public List<String> getExcludeTokens()
	{
		return excludeTokens;
	}
	
	public void setExcludeTokens(List<String> excludeTokens)
	{
		this.excludeTokens = excludeTokens;
	}
	
	
}
