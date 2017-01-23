package movieflix.restapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Muthiah
 * This is an exception class used for denoting bas requests
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequest extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public BadRequest(String message)
	{
		super(message);
	}

	public BadRequest(String message, Throwable clause)
	{
		super(message, clause);
	}

}
