package contazul.com.desafio.helpers;

import java.util.concurrent.TimeUnit;

public class CalculatorFine {
	public Long calcule(long current_time, long due_time, long total) {
		
		long diference = (current_time - due_time);
		long total_days = TimeUnit.DAYS.convert(diference, TimeUnit.MILLISECONDS);
		FineCalculator fine;
		
		if(due_time >= current_time) {
			fine = new FineEmpty();
		} else if(total_days >= 10) {
			fine = new FineHigh10Days(); 
		} else {
			fine = new FineLess10Days();
		}
		
		return fine.calcule(total_days, total);
	}
}
