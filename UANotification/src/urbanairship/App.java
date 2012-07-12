
package urbanairship;

public class App  implements java.io.Serializable
{
	private String name;
	private String key;
	private String secret;
	private String masterSecret;
	private String pushServiceStatus;
	private String pushStatus;
	private String storekitMode;
	private String appUrl;
	private String androidPackageName;
	private String blackberryUsername;
	private String blackberryPassword;
	private String blackberryPushUrl;
	private boolean richpushEnabled = false;
	private String certificate; // base 64 encoded string of the .p12 with the private
	private String certificatePassword;
	

	public boolean isProduction()
	{
		return (pushServiceStatus != null) && ("production".equalsIgnoreCase(pushServiceStatus));
	}
	
	public boolean isDevelopment()
	{
		return (pushServiceStatus != null) && ("development".equalsIgnoreCase(pushServiceStatus));
	}
	
	public boolean isDisabled()
	{
		return (pushServiceStatus != null) && ("disabled".equalsIgnoreCase(pushServiceStatus));
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getKey()
	{
		return key;
	}

	public void setKey(String key)
	{
		this.key = key;
	}

	public String getSecret()
	{
		return secret;
	}

	public void setSecret(String secret)
	{
		this.secret = secret;
	}

	public String getMasterSecret()
	{
		return masterSecret;
	}

	public void setMasterSecret(String masterSecret)
	{
		this.masterSecret = masterSecret;
	}

	public String getPushServiceStatus()
	{
		return pushServiceStatus;
	}

	public void setPushServiceStatus(String pushServiceStatus)
	{
		this.pushServiceStatus = pushServiceStatus;
	}

	public String getPushStatus()
	{
		return pushStatus;
	}

	public void setPushStatus(String pushStatus)
	{
		this.pushStatus = pushStatus;
	}

	public String getStorekitMode()
	{
		return storekitMode;
	}

	public void setStorekitMode(String storekitMode)
	{
		this.storekitMode = storekitMode;
	}

	public String getAppUrl()
	{
		return appUrl;
	}

	public void setAppUrl(String appUrl)
	{
		this.appUrl = appUrl;
	}

	public String getAndroidPackageName()
	{
		return androidPackageName;
	}

	public void setAndroidPackageName(String androidPackageName)
	{
		this.androidPackageName = androidPackageName;
	}

	public String getBlackberryUsername()
	{
		return blackberryUsername;
	}

	public void setBlackberryUsername(String blackberryUsername)
	{
		this.blackberryUsername = blackberryUsername;
	}

	public String getBlackberryPassword()
	{
		return blackberryPassword;
	}

	public void setBlackberryPassword(String blackberryPassword)
	{
		this.blackberryPassword = blackberryPassword;
	}

	public String getBlackberryPushUrl()
	{
		return blackberryPushUrl;
	}

	public void setBlackberryPushUrl(String blackberryPushUrl)
	{
		this.blackberryPushUrl = blackberryPushUrl;
	}

	public boolean isRichpushEnabled()
	{
		return richpushEnabled;
	}

	public void setRichpushEnabled(boolean richpushEnabled)
	{
		this.richpushEnabled = richpushEnabled;
	}

	public String getCertificate()
	{
		return certificate;
	}

	public void setCertificate(String certificate)
	{
		this.certificate = certificate;
	}

	public String getCertificatePassword()
	{
		return certificatePassword;
	}

	public void setCertificatePassword(String certificatePassword)
	{
		this.certificatePassword = certificatePassword;
	}


	@Override
	public String toString()
	{
		return this.getName() + ": " + this.getPushServiceStatus();
	}
	
}
