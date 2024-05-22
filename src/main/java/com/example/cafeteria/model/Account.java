package com.example.cafeteria.model;

import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
@Entity 
public class Account {
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="account_generator")
    @SequenceGenerator(name="account_generator", sequenceName="account_seq", allocationSize=1)
    private int id;

    @OneToOne
    @JoinColumn(name="payment_id") 
    private Payment payment;

    @Column
    private String Accountnumber;

    @Column
    private String UPI;
    @Column(name = "account_type")
    private String accountType;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public String getAccountnumber() {
		return Accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		Accountnumber = accountnumber;
	}

	public String getUPI() {
		return UPI;
	}

	public void setUPI(String uPI) {
		UPI = uPI;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Account(int id, Payment payment, String accountnumber, String uPI, String accountType) {
		super();
		this.id = id;
		this.payment = payment;
		Accountnumber = accountnumber;
		UPI = uPI;
		this.accountType = accountType;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}