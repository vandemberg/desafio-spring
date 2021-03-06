package contazul.com.desafio.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import contazul.com.desafio.busniss.BankslipBusniss;
import contazul.com.desafio.exceptions.BanksplitNotFoundException;
import contazul.com.desafio.models.Bankslip;
import contazul.com.desafio.repositories.BankslipRepository;

@RestController
public class PaymentController {
	
	@Autowired
	private BankslipRepository repository;
	
	private BankslipBusniss busniss;
	
	PaymentController() {
		this.busniss = new BankslipBusniss();
	}
	
	@PostMapping("/rest/bankslips/{id}/payment")
	public Bankslip payment(@PathVariable UUID id, @RequestBody Bankslip payment) {
		
		if(! repository.existsById(id)) {
			throw new BanksplitNotFoundException("Bankslip not found with the specified id");
		}
		
		return busniss.payment(id, repository, payment.getPayment_date());
	}
	
}
