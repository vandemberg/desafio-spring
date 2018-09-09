package contazul.com.desafio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BanksplitNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public BanksplitNotFoundException() {
		super();
	}
	
	public BanksplitNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
	
    public BanksplitNotFoundException(String message) {
        super(message);
    }
    
    public BanksplitNotFoundException(Throwable cause) {
        super(cause);
    }
	
}
