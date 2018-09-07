package contazul.com.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import contazul.com.desafio.models.Bankslip;
import contazul.com.desafio.repositories.BankslipRepository;

import java.util.List;
import java.util.UUID;

@RestController
public class BankslipController {
	
	@Autowired
	private BankslipRepository repository;
	
	@GetMapping("/")
	public String root() {
		return "Olá, como vai você?";
	}
	
	@GetMapping("/rest/bankslip")
	public List<Bankslip> all() {
		return repository.findAll();
	}
	
	@PostMapping("/rest/bankslip")
	public Bankslip create(@RequestBody Bankslip newBankslip) {
		return repository.save(newBankslip);
	}
		
	@GetMapping("/rest/bankslip/{id}")
	public Bankslip find(@PathVariable UUID id) {
		return repository.findById(id).get();
	}
	
	@DeleteMapping("/rest/bankslip/{id}")
	public void delete(@PathVariable UUID id) {
		repository.deleteById(id);
	}
}
