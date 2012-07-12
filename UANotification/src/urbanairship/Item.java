
package urbanairship;

/**
 * 
 * In App Purchase API:  Item
 *
 */
public class Item implements java.io.Serializable
{
	private String productId;
	private Integer currentRevision;
	private String downloadUrl;

	public String getProductId()
	{
		return productId;
	}

	public void setProductId(String productId)
	{
		this.productId = productId;
	}

	public Integer getCurrentRevision()
	{
		return currentRevision;
	}

	public void setCurrentRevision(Integer currentRevision)
	{
		this.currentRevision = currentRevision;
	}

	public String getDownloadUrl()
	{
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl)
	{
		this.downloadUrl = downloadUrl;
	}

}
