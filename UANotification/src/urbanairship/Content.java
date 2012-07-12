
package urbanairship;

public class Content implements java.io.Serializable
{
	private String name;
	private String url;
	private String iconUrl;
	private String previewUrl;
	private String downloadUrl;
	private Integer currentRevision;
	private Integer productId;
	private boolean free = false;
	private Integer fileSize;
	private String description;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getIconUrl()
	{
		return iconUrl;
	}

	public void setIconUrl(String iconUrl)
	{
		this.iconUrl = iconUrl;
	}

	public String getPreviewUrl()
	{
		return previewUrl;
	}

	public void setPreviewUrl(String previewUrl)
	{
		this.previewUrl = previewUrl;
	}

	public String getDownloadUrl()
	{
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl)
	{
		this.downloadUrl = downloadUrl;
	}

	public Integer getCurrentRevision()
	{
		return currentRevision;
	}

	public void setCurrentRevision(Integer currentRevision)
	{
		this.currentRevision = currentRevision;
	}

	public Integer getProductId()
	{
		return productId;
	}

	public void setProductId(Integer productId)
	{
		this.productId = productId;
	}

	public boolean isFree()
	{
		return free;
	}

	public void setFree(boolean free)
	{
		this.free = free;
	}

	public Integer getFileSize()
	{
		return fileSize;
	}

	public void setFileSize(Integer fileSize)
	{
		this.fileSize = fileSize;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	@Override
	public String toString()
	{
		return this.getName();
	}

}
