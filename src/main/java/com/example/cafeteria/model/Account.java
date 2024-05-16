package com.example.cafeteria.model;

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

    @Column
    private String accounttype;

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(Payment payment, int id, String accountnumber, String uPI, String accounttype) {
		super();
		this.payment = payment;
		this.id = id;
		Accountnumber = accountnumber;
		UPI = uPI;
		accounttype = accounttype;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}	
}