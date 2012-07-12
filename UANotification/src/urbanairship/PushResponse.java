
package urbanairship;

import java.util.*;

public class PushResponse implements java.io.Serializable
{
	private List<String> scheduledNotifications = new ArrayList<String>();

	public List<String> getScheduledNotifications()
	{
		if (scheduledNotifications == null)
		{
			scheduledNotifications = new ArrayList<String>();
		}
		
		return scheduledNotifications;
	}

	public void setScheduledNotifications(
			List<String> urls)
	{
		this.scheduledNotifications = urls;
	}
	
	public boolean hasScheduledNotifications()
	{
		return (this.getScheduledNotifications() != null);
	}
}
