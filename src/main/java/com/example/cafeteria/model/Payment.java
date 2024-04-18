package com.example.cafeteria.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
@Entity
public class Payment {
//	@Column
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
	generator="payment_generator")
	@SequenceGenerator(name="payment_generator",
	sequenceName="payment_seq",allocationSize=1)	
	private int id;
	@Column
	private String BankAccount;
	@Column
	private String UPI;
	@Column
	private String COD;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column
	private String Deliveryfee;
	@Column
	 private boolean Amountcredited;
	
	@ManyToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="user_id")
	private UserEntity userentity;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="deliveryman_id")
	private DeliveryMan deliveryman_id;
	
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payment(int id, String bankAccount, String uPI, String cOD, String deliveryfee, boolean amountcredited,
			UserEntity userentity, DeliveryMan deliveryman_id) {
		super();
		this.id = id;
		BankAccount = bankAccount;
		UPI = uPI;
		COD = cOD;
		Deliveryfee = deliveryfee;
		Amountcredited = amountcredited;
		
	}
	

	public String getBankAccount() {
		return BankAccount;
	}
	public void setBankAccount(String bankAccount) {
		BankAccount = bankAccount;
	}
	public String getUPI() {
		return UPI;
	}
	public void setUPI(String uPI) {
		UPI = uPI;
	}
	public String getCOD() {
		return COD;
	}
	public void setCOD(String cOD) {
		COD = cOD;
	}
	public String getDeliveryfee() {
		return Deliveryfee;
	}
	public void setDeliveryfee(String deliveryfee) {
		Deliveryfee = deliveryfee;
	}
	
	public boolean isAmountcredited() {
		return Amountcredited;
	}
	public void setAmountcredited(boolean amountcredited) {
		Amountcredited = amountcredited;
	}

}
