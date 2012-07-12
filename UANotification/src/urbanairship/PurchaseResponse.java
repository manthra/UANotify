
package urbanairship;

public class PurchaseResponse implements java.io.Serializable
{
	private String receiptStatus;
	private String serverResponse;

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
