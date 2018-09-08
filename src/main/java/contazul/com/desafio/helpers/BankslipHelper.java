package contazul.com.desafio.helpers;

import contazul.com.desafio.models.Bankslip;

public class BankslipHelper {
	
	public static long fine(Bankslip bankslip) {
		
		long total = bankslip.getTotal_in_cents();
		long due_time = bankslip.getDue_date().getTime();
		long current_time = new java.util.Date().getTime();
		
		CalculatorFine calculator = new CalculatorFine();
		return calculator.calcule(current_time, due_time, total);
	}
	
}
