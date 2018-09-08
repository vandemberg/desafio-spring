package contazul.com.desafio.helpers;

public class FineEmpty implements FineCalculator {

	private double custe = 0;
	
	@Override
	public long calcule(long total_days, long total) {
		return (long) ((long) total_days * custe * total);
	}

}
