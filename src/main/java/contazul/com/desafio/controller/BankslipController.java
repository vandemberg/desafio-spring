package contazul.com.desafio.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import contazul.com.desafio.busniss.BankslipBusniss;
import contazul.com.desafio.models.Bankslip;

import java.util.List;
import java.util.UUID;

@RestController
public class BankslipController {
	
	private BankslipBusniss busniss;
	
	public BankslipController() {
		this.busniss = new BankslipBusniss();
	}
	
	@GetMapping("/rest/bankslip")
	public List<Bankslip> all() {
		return busniss.listAll();
	}
	
	@PostMapping("/rest/bankslip")
	public Bankslip create(@RequestBody Bankslip newBankslip) {
		return busniss.create(newBankslip);
	}
		
	@GetMapping("/rest/bankslip/{id}")
	public Bankslip find(@PathVariable UUID id) {
		return busniss.details(id);
	}
	
	@DeleteMapping("/rest/bankslip/{id}")
	public Object delete(@PathVariable UUID id) {
		return busniss.delete(id);
	}
}
