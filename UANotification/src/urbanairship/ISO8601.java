
package urbanairship;

import java.util.*;
import java.text.*;

public class ISO8601
{
	public static final String PATTERN = "yyyy-MM-dd'T'HH:mm:ssZ";

	static public String toString(java.util.Calendar c)
	{
		return toString(c.getTime());
	}
	
	static public String toString(java.util.Date d)
	{
		SimpleDateFormat fmt = new SimpleDateFormat(PATTERN);
		return fmt.format(d);
	}
	
	static public Calendar toCalendar(String dateTimeString) throws ParseException
	{
		SimpleDateFormat fmt = new SimpleDateFormat(PATTERN);
		
		Date d = fmt.parse(dateTimeString);
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		
		return c;
	}
}
