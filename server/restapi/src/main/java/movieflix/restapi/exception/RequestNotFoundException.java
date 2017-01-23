package movieflix.restapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Muthiah
 * This is an exception class used when the required value is not found
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class RequestNotFoundException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public RequestNotFoundException(String message)
	{
		super(message);
	}

	public RequestNotFoundException(String message, Throwable clause)
	{
		super(message, clause);
	}

}
