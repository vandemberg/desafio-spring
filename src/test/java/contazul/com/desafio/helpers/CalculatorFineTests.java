package contazul.com.desafio.helpers;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CalculatorFineTests {
	
	@Test
	public void tryCalculateFineOk() {
		
		long total = 1000;
		long current_time = new Date().getTime();
		long due_time = new Date().getTime();
		long fine = 0;
		
		CalculatorFine calc = new CalculatorFine();
		long fine_result = calc.calcule(current_time, due_time, total);
		
		assertEquals(fine_result, fine);
		
	}
	
	@Test
	public void tryCalculateFineLess10Days() {
		long total = 1000;
		long fine = 1 * 5;
		
		// Setting today
		Date date = new Date();
		long due_time = date.getTime();
		
		// Setting today add one day
		Date tomorrow = new Date(date.getTime() + (1000 * 60 * 60 * 24));
		long current_time = tomorrow.getTime();
		
		CalculatorFine calc = new CalculatorFine();
		long fine_result = calc.calcule(current_time, due_time, total);
		
		assertEquals(fine_result, fine);
	}
	
	@Test
	public void tryCalculateFine10DaysOrHigher() {
		long total = 1000;
		long fine = 10 * 10;
		
		// Setting today
		Date date = new Date();
		long due_time = date.getTime();
		
		// Setting today add one day
		Date tomorrow = new Date(date.getTime() + (1000 * 60 * 60 * 24 * 10));
		long current_time = tomorrow.getTime();
		
		CalculatorFine calc = new CalculatorFine();
		long fine_result = calc.calcule(current_time, due_time, total);
		
		assertEquals(fine_result, fine);
	}
	
}
