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
		Bankslip bankslip = repository.findById(id).get();
		return bankslip;
	}

	public Object delete(UUID id) {
		return changeStatus(id, statusCANCELED);
	}

	public Bankslip payment(UUID id) {
		return changeStatus(id, statusPAID);
	}

	private Bankslip changeStatus(UUID id, String status ) {
		Bankslip bankslip = repository.findById(id).get();
		bankslip.setStatus(status);
		repository.save(bankslip);
		return bankslip;
	}
	
}
