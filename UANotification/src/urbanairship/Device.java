
package urbanairship;

import java.util.*;

import com.google.gson.annotations.SerializedName;

/**
 * 
 *  
 *  
 *  @see Devices
 *
 *
 */
public class Device implements java.io.Serializable
{
	private String alias;
	private List<String> tags;
	private boolean active = true;
	private Calendar lastRegistration;
	private Integer badge;
	
	@SerializedName("tz")
	private String timeZone;
	
	private QuietTime quiettime;
	
	
	@SerializedName("device_token")
	private String iOSDeviceToken; // for iPhone's, iPad's, etc
	
	@SerializedName("device_pin")
	private String blackberryDevicePin;
	
	@SerializedName("apid")
	private String androidAPID; 
	
	public boolean isActive()
	{
		return active;
	}
	
	public void setActive(boolean active)
	{
		this.active = active;
	}
	
	public String getAlias()
	{
		return alias;
	}
	
	public void setAlias(String alias)
	{
		this.alias = alias;
	}
	
	public Calendar getLastRegistration()
	{
		return lastRegistration;
	}
	
	public void setLastRegistration(Calendar lastRegistration)
	{
		this.lastRegistration = lastRegistration;
	}

	public List<String> getTags()
	{
		return tags;
	}

	public void setTags(List<String> tags)
	{
		this.tags = tags;
	}

	public Integer getBadge()
	{
		return badge;
	}

	public void setBadge(Integer badge)
	{
		this.badge = badge;
	}

	/**
	 * 
	 * @return The end user’s timezone as a timezone name like “Europe/Berlin”
	 * 
	 */
	public String getTimeZone()
	{
		return timeZone;
	}

	/**
	 * 
	 * @param tz The end user’s timezone as a timezone name like “Europe/Berlin”
	 * 
	 */
	public void setTimeZone(String tz)
	{
		this.timeZone = tz;
	}

	public QuietTime getQuietTime()
	{
		return quiettime;
	}

	public void setQuiettime(QuietTime qt)
	{
		this.quiettime = qt;
	}

	public String getiOSDeviceToken()
	{
		return iOSDeviceToken;
	}

	public void setiOSDeviceToken(String deviceToken)
	{
		this.iOSDeviceToken = deviceToken;
	}

	public String getBlackberryDevicePin()
	{
		return blackberryDevicePin;
	}

	public void setBlackberryDevicePin(String devicePin)
	{
		this.blackberryDevicePin = devicePin;
	}

	public String getAndroidAPID()
	{
		return androidAPID;
	}

	public void setAndroidAPID(String apid)
	{
		this.androidAPID = apid;
	}

	public String getPath()
	{
		String path = null;
		
		if (this.getiOSDeviceToken() != null)
		{
			path = "device_tokens";
		}
		else if (this.getAndroidAPID() != null)
		{
			path = "apids";
		}
		else if (this.getBlackberryDevicePin() != null)
		{
			path = "device_pins";
		}
		
		return path;
	}

	public String getIdentifier()
	{
		String identifier = null;
		
		if (this.getiOSDeviceToken() != null)
		{
			identifier = getiOSDeviceToken();
		}
		else if (this.getAndroidAPID() != null)
		{
			identifier = this.getAndroidAPID();
		}
		else if (this.getBlackberryDevicePin() != null)
		{
			identifier = this.getBlackberryDevicePin();
		}
		
		return identifier;
	}
	
	public void addTag(String tag)
	{
		if ( (tag == null) || (tag.length() == 0))
		{
			throw new IllegalArgumentException("tag parameter");
		}
		
		if (this.getTags() == null)
		{
			this.tags = new ArrayList<String>();
		}
		
		this.tags.add(tag);
	}
}
