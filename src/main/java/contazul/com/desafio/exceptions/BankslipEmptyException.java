package contazul.com.desafio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BankslipEmptyException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public BankslipEmptyException() {
		super();
	}
	
	public BankslipEmptyException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public BankslipEmptyException(String message) {
		super(message);
	}
	
	public BankslipEmptyException(Throwable cause) {
		super(cause);
	}
	
}
