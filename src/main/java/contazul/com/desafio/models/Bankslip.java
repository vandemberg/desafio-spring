package contazul.com.desafio.models;

import java.sql.Date;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Bankslip {
	
	public Bankslip(Date due_date, long total_in_cents, String customer, String status) {
		setDue_date(due_date);
		setTotal_in_cents(total_in_cents);
		setCustomer(customer);
		setStatus(status);
	}
	
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	@Column(name = "key", unique = true, nullable = false)
	private UUID id;
	
	@NotNull(message= "due_date field is required")
	private Date due_date;
	private Date payment_date;
	
	@NotNull(message = "total in cents is required")
	private long total_in_cents;
	private long fine;
	
	@NotNull(message = "customer is required")
	private String customer;
	
	private String status;
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
	public Date getDue_date() {
		return due_date;
	}

	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}

	public long getTotal_in_cents() {
		return total_in_cents;
	}

	public void setTotal_in_cents(long total_in_cents) {
		this.total_in_cents = total_in_cents;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public Date getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}

	public long getFine() {
		return fine;
	}

	public void setFine(long fine) {
		this.fine = fine;
	}
		
}
