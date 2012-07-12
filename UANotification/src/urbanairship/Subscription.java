
package urbanairship;

import java.util.*;

/**
 * 
 * Subscription API
 *
 */
public class Subscription implements java.io.Serializable
{
	private String subscriptionKey;
	private String productId;
	private Calendar start;
	private Calendar end;

	public String getSubscriptionKey()
	{
		return subscriptionKey;
	}

	public void setSubscriptionKey(String subscriptionKey)
	{
		this.subscriptionKey = subscriptionKey;
	}

	public String getProductId()
	{
		return productId;
	}

	public void setProductId(String productId)
	{
		this.productId = productId;
	}

	public Calendar getStart()
	{
		return start;
	}

	public void setStart(Calendar start)
	{
		this.start = start;
	}

	public Calendar getEnd()
	{
		return end;
	}

	public void setEnd(Calendar end)
	{
		this.end = end;
	}

}
