package contazul.com.desafio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class BankslipValidationException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public BankslipValidationException() {
		super();
	}
	
	public BankslipValidationException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public BankslipValidationException(String message) {
		super(message);
	}
	
	public BankslipValidationException(Throwable cause) {
		super(cause);
	}
	
}
