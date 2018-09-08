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
		
		// Setting Status to APID
		Bankslip bankslip = changeStatus(id, statusPAID, repository);
		
		// Define a date to the payment
		bankslip.setPayment_date(this.getNow());
		repository.save(bankslip);
		
		return bankslip;
	}

	private java.sql.Date getNow() {
		java.util.Date utilDate = new java.util.Date();
	    return new java.sql.Date(utilDate.getTime()); 
	}
	
	private Bankslip changeStatus(UUID id, String status, BankslipRepository repository) {
		Bankslip bankslipt = repository.findById(id).get();
		bankslipt.setStatus(status);
		return repository.save(bankslipt);
	}
	
}
