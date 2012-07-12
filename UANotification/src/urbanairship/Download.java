
package urbanairship;

/**
 * 
 * App Purchase API: download
 * 
 */
public class Download implements java.io.Serializable
{
	private String transactionReceipt;
	private String udid;
	private Integer version;

	public String getTransactionReceipt()
	{
		return transactionReceipt;
	}

	public void setTransactionReceipt(String transactionReceipt)
	{
		this.transactionReceipt = transactionReceipt;
	}

	public String getUdid()
	{
		return udid;
	}

	public void setUdid(String udid)
	{
		this.udid = udid;
	}

	public Integer getVersion()
	{
		return version;
	}

	public void setVersion(Integer version)
	{
		this.version = version;
	}

}
