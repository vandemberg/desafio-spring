package contazul.com.desafio.busniss;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import contazul.com.desafio.models.Bankslip;
import contazul.com.desafio.repositories.BankslipRepository;

public class BankslipBusniss {
	
	@Autowired
	private BankslipRepository repository;
	
	private String statusPending = "PENDING";
	private String statusPAID = "PAID";
	private String statusCANCELED = "CANCELED";
	
	public List<Bankslip> listAll() {
		return this.repository.findAll();
	}

	public Bankslip create(Bankslip bankslip) {
		bankslip.setStatus(this.statusPending);
		return repository.save(bankslip);
	}

	public Bankslip details(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object delete(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Bankslip payment(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
