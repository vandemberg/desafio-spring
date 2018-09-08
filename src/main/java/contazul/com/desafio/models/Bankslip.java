package contazul.com.desafio.models;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Bankslip {
	
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	@Column(name = "key", unique = true, nullable = false)
	private UUID id;
	
	@NotNull
	@DateTimeFormat
	private Date due_date;
	private Date payment_date;
	
	@NotNull
	@Positive
	private double total_in_cents;
	private double fine;
	
	@NotNull
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

	public double getTotal_in_cents() {
		return total_in_cents;
	}

	public void setTotal_in_cents(double total_in_cents) {
		this.total_in_cents = total_in_cents;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getStatus(String status) {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Bankslip [id=" + id + ", due_date=" + due_date + ", total_in_cents=" + total_in_cents + ", customer="
				+ customer + ", status=" + status + "]";
	}

	public Date getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}

	public double getFine() {
		return fine;
	}

	public void setFine(double fine) {
		this.fine = fine;
	}
		
}
