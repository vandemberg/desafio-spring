package contazul.com.desafio.helpers;

public class FineHigh10Days implements FineCalculator{
	
	private double custe = 0.01;
	
	@Override
	public long calcule(long total_days, long total) {
		return (long) ((long) total_days * custe * total);
	}
}
