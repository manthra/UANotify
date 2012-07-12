
package urbanairship;

/**
 * 
 * HTTP 404 status code ("not found")
 *
 * @see http://en.wikipedia.org/wiki/HTTP_404
 * 
 */
public class NotFoundException extends RuntimeException
{
	public NotFoundException(String msg)
	{
		super(msg);
	}

}
