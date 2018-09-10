package contazul.com.desafio.busniss;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import contazul.com.desafio.helpers.BankslipHelper;
import contazul.com.desafio.models.Bankslip;
import contazul.com.desafio.repositories.BankslipRepository;

public class BankslipBusniss {
		
	private String statusPending = "PENDING";
	private String statusPAID = "PAID";
	private String statusCANCELED = "CANCELED";
	
	public List<Bankslip> all(BankslipRepository repository) {
		return repository.findAll();
	}
	
	public Bankslip create(Bankslip bankslip, BankslipRepository repository) {
		bankslip.setStatus(this.statusPending);
		return repository.save(bankslip);
	}

	public Bankslip details(UUID id, BankslipRepository repository) {
		Bankslip bankslip = repository.findById(id).get();
		long fine = BankslipHelper.fine(bankslip);
		bankslip.setFine(fine);
		return bankslip;
	}

	public Object delete(UUID id, BankslipRepository repository) {
		return changeStatus(id, statusCANCELED, repository);
	}

	public Bankslip payment(UUID id, BankslipRepository repository, Date date_payment) {
		
		// Setting Status to APID
		Bankslip bankslip = changeStatus(id, statusPAID, repository);
		
		// Define a date to the payment
		bankslip.setPayment_date(date_payment);
		
		// Define the fine value
		long fine = BankslipHelper.fine(bankslip);
		bankslip.setFine(fine);
		
		// Save the changes
		repository.save(bankslip);
		
		return bankslip;
	}
	
	private Bankslip changeStatus(UUID id, String status, BankslipRepository repository) {
		Bankslip bankslipt = repository.findById(id).get();
		bankslipt.setStatus(status);
		return repository.save(bankslipt);
	}
	
}
