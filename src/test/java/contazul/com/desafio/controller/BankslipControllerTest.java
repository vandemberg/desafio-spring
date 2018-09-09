package contazul.com.desafio.controller;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import contazul.com.desafio.models.Bankslip;
import contazul.com.desafio.repositories.BankslipRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebMvcTest(BankslipController.class)
public class BankslipControllerTest {
	
	@Autowired
	private MockMvc mvc;

	@Autowired
	private BankslipRepository repository;
	
	@MockBean
	private BankslipController controller;
	
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
	public void getAll() {
		
	}
	
	@Test
	public void getDetails() throws Exception{
		
		bankslip = repository.save(bankslip);
		
		Mockito.when(
				controller.find(bankslip.getId())
				).thenReturn(bankslip);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/students/Student1/courses/Course1").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{id:Course1,name:Spring,description:10 Steps}";		

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
		
	}
	
	@Test
	public void postCreate() {
		
	}
	
	@Test
	public void deleteById() {
		
	}
}
