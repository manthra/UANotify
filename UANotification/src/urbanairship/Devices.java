
package urbanairship;

import java.util.*;

/**
 * 
 * @see Device
 *
 */
public class Devices implements java.io.Serializable, java.lang.Iterable<Device>
{
	private Integer deviceTokensCount;
	private Integer activeDeviceTokensCount;
	private List<Device> deviceTokens = new ArrayList<Device>();
	private Integer currentPage;
	private Integer numPages;
	private String nextPage; // nextPage is a url 
	
	public Integer getDeviceTokensCount()
	{
		return deviceTokensCount;
	}
	
	public void setDeviceTokensCount(Integer deviceTokensCount)
	{
		this.deviceTokensCount = deviceTokensCount;
	}
	
	public List<Device> getDeviceTokens()
	{
		return deviceTokens;
	}
	
	public void setDeviceTokens(List<Device> deviceTokens)
	{
		this.deviceTokens = deviceTokens;
	}
	
	public Integer getCurrentPage()
	{
		return currentPage;
	}
	
	public void setCurrentPage(Integer currentPage)
	{
		this.currentPage = currentPage;
	}
	
	public Integer getNumPages()
	{
		return numPages;
	}
	
	public void setNumPages(Integer numPages)
	{
		this.numPages = numPages;
	}
	
	public Integer getActiveDeviceTokensCount()
	{
		return activeDeviceTokensCount;
	}
	
	public void setActiveDeviceTokensCount(Integer activeDeviceTokensCount)
	{
		this.activeDeviceTokensCount = activeDeviceTokensCount;
	}
	
	/**
	 * 
	 * 
	 * @return next page url
	 * 
	 */
	public String getNextPage()
	{
		return nextPage;
	}
	
	public void setNextPage(String nextPage)
	{
		this.nextPage = nextPage;
	}

	public Iterator<Device> iterator()
	{
		return this.getDeviceTokens().iterator();
	}
	
	
}
