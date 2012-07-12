
package urbanairship;

public class QuietTime implements java.io.Serializable
{
	private String start;
	private String end;
	
	public String getStart()
	{
		return start;
	}
	
	/**
	 * 
	 * @param start When the quiet time begins as a string containing a time in 24 hour format. eg "20:30"
	 * 
	 */
	public void setStart(String start)
	{
		this.start = start;
	}
	
	public String getEnd()
	{
		return end;
	}
	
	/**
	 * 
	 * @param end When the quiet time ends as a string containing a time in 24 hour format. eg "6:45"
	 * 
	 */
	public void setEnd(String end)
	{
		this.end = end;
	}
	
	
}
