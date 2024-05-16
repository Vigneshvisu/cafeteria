package com.example.cafeteria.model;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class UserEntity {
@Id
//@Column
@GeneratedValue(strategy=GenerationType.SEQUENCE,
generator="userentity_generator")
@SequenceGenerator(name="userentity_generator",
sequenceName="userentity_seq",allocationSize=1)
private int userid;
@Column
private String Username;
@Column
private String Password;
@Column
private String MobileNumber;
@Column
private String MailId;


public List<Address> getAddress() {
	return address;
}
//@OneToOne(cascade=CascadeType.ALL)
//@JoinColumn(name="orderstatus_id")
//private OrderStatus orderstatus;

@OneToMany(cascade=CascadeType.ALL)
private List<Address> address;

@OneToMany(cascade=CascadeType.ALL)
private List<Products> products;

//@OneToOne(cascade = CascadeType.ALL) 
//@JoinColumn(name = "deliveryman")
//private DeliveryMan deliveryman;

@OneToMany(cascade=CascadeType.ALL)
@JoinColumn(name = "payment")
private List<Payment> payment;

public UserEntity(int userid, String username, String password, String mobileNumber, String mailId,
		List<Address> address, List<Products> products, List<Payment> payment) {
	super();
	this.userid = userid;
	Username = username;
	Password = password;
	MobileNumber = mobileNumber;
	MailId = mailId;
	this.address = address;
	this.products = products;
	this.payment = payment;
}

public List<Products> getProducts() {
	return products;
}

public void setProducts(List<Products> products) {
	this.products = products;
}

public UserEntity(int userid, String username, String password, String mobileNumber, String mailId, OrderStatus orderstatus,
		List<Address> address, DeliveryMan deliveryman, List<Payment> payment) {
	super();
	this.userid = userid;
	Username = username;
	Password = password;
	MobileNumber = mobileNumber;
	MailId = mailId;
//	this.orderstatus = orderstatus;
	this.address = address;
//	this.deliveryman = deliveryman;
	this.payment = payment;
}

public void setPayment(List<Payment> payment) {
	this.payment = payment;
}

public void setAddress(List<Address> address) {
	this.address = address;
}

public UserEntity() {
	super();
	// TODO Auto-generated constructor stub
}


public int getUserid() {
	return userid;
}

public void setUserid(int userid) {
	this.userid = userid;
}

public List<Payment> getPayment() {
	return payment;
}

public String getUsername() {
	return Username;
}
public void setUsername(String username) {
	Username = username;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getMobileNumber() {
	return MobileNumber;
}
public void setMobileNumber(String mobileNumber) {
	MobileNumber = mobileNumber;
}
public String getMailId() {
	return MailId;
}
public void setMailId(String mailId) {
	MailId = mailId;
}

//public DeliveryMan getDeliveryman() {
//	return deliveryman;
//}
//public void setDeliveryman(DeliveryMan deliveryman) {
//	this.deliveryman = deliveryman;
//}

//public List<History> getHistory() {
//	return history;
//}
//public void setHistory(List<History> history) {
//	this.history = history;
//}
//public OrderStatus getOrderstatus() {
//	return orderstatus;
//}
//public void setOrderstatus(OrderStatus orderstatus) {
//	this.orderstatus = orderstatus;
//}


}
