
package urbanairship;

import java.util.*;

public class ScheduleFor implements java.io.Serializable
{
	private String alias;
	private Calendar scheduledTime;
	
	public String getAlias()
	{
		return alias;
	}
	
	public void setAlias(String alias)
	{
		this.alias = alias;
	}
	
	public Calendar getScheduledTime()
	{
		return scheduledTime;
	}
	
	public void setScheduledTime(Calendar scheduledTime)
	{
		this.scheduledTime = scheduledTime;
	}
	
	
}
