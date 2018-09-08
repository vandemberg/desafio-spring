package contazul.com.desafio.busniss;

import java.util.UUID;

import contazul.com.desafio.models.Bankslip;
import contazul.com.desafio.repositories.BankslipRepository;

public class BankslipBusniss {
		
	private String statusPending = "PENDING";
	private String statusPAID = "PAID";
	private String statusCANCELED = "CANCELED";

	public Bankslip create(Bankslip bankslip, BankslipRepository repository) {
		bankslip.setStatus(this.statusPending);
		return repository.save(bankslip);
	}

	public Bankslip details(UUID id, BankslipRepository repository) {
		Bankslip bankslip = repository.findById(id).get();
		return bankslip;
	}

	public Object delete(UUID id, BankslipRepository repository) {
		return changeStatus(id, statusCANCELED, repository);
	}

	public Bankslip payment(UUID id, BankslipRepository repository) {
		return changeStatus(id, statusPAID, repository);
	}

	private Bankslip changeStatus(UUID id, String status, BankslipRepository repository) {
		Bankslip bankslipt = repository.findById(id).get();
		bankslipt.setStatus(status);
		repository.save(bankslipt);
		return bankslipt;
	}
	
}
