
package urbanairship;

import java.util.*;

public class RecoveryStatusResponse implements java.io.Serializable
{
	private String status;
	private String userUrl;
	private String userId;
	private String password;
	private List<String> deviceTokens = new ArrayList<String>();
	private List<Subscription> subscriptions = new ArrayList<Subscription>();
	
	public boolean isPending()
	{
		return "pending".equalsIgnoreCase(this.getStatus());
	}
	
	public boolean isComplete()
	{
		return "complete".equalsIgnoreCase(this.getStatus());
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}
	
	
}
