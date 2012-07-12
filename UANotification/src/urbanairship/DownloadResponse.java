
package urbanairship;

public class DownloadResponse implements java.io.Serializable
{
	private String contentUrl;
	private String receiptStatus;
	private String serverResponse;
	

	public String getContentUrl()
	{
		return contentUrl;
	}

	public void setContentUrl(String url)
	{
		this.contentUrl = url;
	}

	public String getReceiptStatus()
	{
		return receiptStatus;
	}

	public void setReceiptStatus(String receiptStatus)
	{
		this.receiptStatus = receiptStatus;
	}

	public String getServerResponse()
	{
		return serverResponse;
	}

	public void setServerResponse(String serverResponse)
	{
		this.serverResponse = serverResponse;
	}
	
	
}
