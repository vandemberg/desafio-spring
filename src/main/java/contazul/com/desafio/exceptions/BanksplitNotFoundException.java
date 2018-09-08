package contazul.com.desafio.exceptions;

public class BanksplitNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public BanksplitNotFoundException(String exception) {
		super(exception);
	}

}
