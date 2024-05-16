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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_generator")
    @SequenceGenerator(name = "payment_generator", sequenceName = "payment_seq", allocationSize = 1)
    private int paymentid;
    private String COD;
    @Column
    private String Deliveryfee;

    @Column
    private boolean Amountcredited;
    @Column
    private String paymentmode;

    public Payment(int paymentid, String cOD, String deliveryfee, boolean amountcredited, String paymentmode,
			UserEntity userentity, Account account) {
		super();
		this.paymentid = paymentid;
		COD = cOD;
		Deliveryfee = deliveryfee;
		Amountcredited = amountcredited;
		this.paymentmode = paymentmode;
		this.userentity = userentity;
		this.account = account;
	}
	public String getPaymentmode() {
		return paymentmode;
	}

	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity userentity;

    @OneToOne(mappedBy = "payment", cascade = CascadeType.ALL)
    private Account account;	
    
     public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public int getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
	}

	public UserEntity getUserentity() {
		return userentity;
	}

	public void setUserentity(UserEntity userentity) {
		this.userentity = userentity;
	}

//	public OrderStatus getOrderstatus() {
//		return orderstatus;
//	}
//
//	public void setOrderstatus(OrderStatus orderstatus) {
//		this.orderstatus = orderstatus;
//	}

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
