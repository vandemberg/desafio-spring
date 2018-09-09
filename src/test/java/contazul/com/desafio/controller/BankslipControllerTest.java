package contazul.com.desafio.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import contazul.com.desafio.models.Bankslip;
import contazul.com.desafio.repositories.BankslipRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BankslipControllerTest {

	@Autowired
	private BankslipRepository repository;
	
	@MockBean
	private BankslipController controller;

	@Autowired
	private MockMvc mvc;
	
	Bankslip bankslip = new Bankslip(
			new java.sql.Date(new java.util.Date().getTime()), 
			(long) 10000, 
			"Conta Azul", 
			"PENDING"
			);
	
	String bankslipJson = "{\r\n" + 
			" \"due_date\":\"2018-01-01\",\r\n" + 
			" \"total_in_cents\":\"100000\",\r\n" + 
			" \"customer\":\"Trillian Company\"\r\n" + 
			"}";
	
	@Test
	public void shouldReturnAllBankslip() throws Exception {
		
	}
	
	@Test
	public void getDetails() throws Exception{		
		
	}
	
	@Test
	public void postCreate() {
		
	}
	
	@Test
	public void deleteById() {
		
	}
}
