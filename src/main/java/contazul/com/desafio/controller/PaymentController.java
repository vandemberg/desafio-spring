package contazul.com.desafio.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import contazul.com.desafio.busniss.BankslipBusniss;
import contazul.com.desafio.models.Bankslip;

@RestController
public class PaymentController {
	
	private BankslipBusniss busniss;
	
	PaymentController() {
		this.busniss = new BankslipBusniss();
	}
	
	@PostMapping("/rest/bankslip/{id}/payment")
	public Bankslip payment(@PathVariable UUID id) {
		return busniss.payment(id);
	}
	
}
