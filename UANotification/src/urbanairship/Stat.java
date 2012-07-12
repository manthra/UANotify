
package urbanairship;

import java.util.*;

public class Stat implements java.io.Serializable
{
	private Calendar time;
	private Integer count;
	
	public Calendar getTime()
	{
		return time;
	}
	
	public void setTime(Calendar time)
	{
		this.time = time;
	}
	
	public Integer getCount()
	{
		return count;
	}
	
	public void setCount(Integer count)
	{
		this.count = count;
	}
	
	
}
