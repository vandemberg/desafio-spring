package contazul.com.desafio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class BankslipNoContentException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	BankslipNoContentException() {
		super();
	}
	
	BankslipNoContentException(String message,Throwable cause) {
		super(message, cause);
	}
	
	BankslipNoContentException(String message) {
		super(message);
	}
	
	BankslipNoContentException(Throwable cause) {
		super(cause);
	}
}
