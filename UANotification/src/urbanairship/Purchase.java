
package urbanairship;

public class Purchase implements java.io.Serializable
{
	private String transactionReceipt;
	private String productId;

	public String getTransactionReceipt()
	{
		return transactionReceipt;
	}

	public void setTransactionReceipt(String transactionReceipt)
	{
		this.transactionReceipt = transactionReceipt;
	}

	public String getProductId()
	{
		return productId;
	}

	public void setProductId(String productId)
	{
		this.productId = productId;
	}

}
