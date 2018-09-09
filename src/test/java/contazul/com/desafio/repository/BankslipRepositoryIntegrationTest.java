package contazul.com.desafio.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import contazul.com.desafio.models.Bankslip;
import contazul.com.desafio.repositories.BankslipRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BankslipRepositoryIntegrationTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private BankslipRepository repository;
	
	@Test
	public void whenFindById_thenReturnBankslip() {
		// Save in the database
		Bankslip bankslip = this.createBankslip();
		entityManager.persist(bankslip);
		entityManager.flush();
				
		Bankslip found = repository.findById(bankslip.getId()).get();
		
		assertEquals(found.getId(), bankslip.getId());
		
	}
	
	@Test
	public void whenSave_thenReturnABankslip() {
		Bankslip bankslip = createBankslip();
		Bankslip newBankslip = repository.save(bankslip);
		assertEquals(newBankslip.getDue_date(), bankslip.getDue_date());
		assertEquals(newBankslip.getCustomer(), bankslip.getCustomer());
		assertEquals(newBankslip.getTotal_in_cents(), bankslip.getTotal_in_cents());
	}
	
	@Test
	public void whenListAll_NeedBeListInstance() {
		repository.save(createBankslip());
		repository.save(createBankslip());
		repository.save(createBankslip());
		assertEquals(3, repository.findAll().size());
	}
	
	@Test
	public void whenChangeTheStatus_CommitTheChange() {
		
		String finalStatus = "PAID";
		
		Bankslip bankslip = createBankslip();
		bankslip.setStatus("PENDING");
		repository.save(bankslip);
		
		bankslip.setStatus(finalStatus);
		repository.save(bankslip);
		
		Bankslip found = repository.findById(bankslip.getId()).get();
		assertEquals(found.getStatus(), finalStatus);
	}
	
	private Bankslip createBankslip() {
		return new Bankslip(
				new java.sql.Date(new java.util.Date().getTime()), 
				(long) 10000, 
				"Conta Azul", 
				"PENDING"
			);
	}
	
}
