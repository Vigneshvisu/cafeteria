package com.example.cafeteria.model;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class UserEntity {
@Id
@Column
@GeneratedValue(strategy=GenerationType.SEQUENCE,
generator="userentity_generator")
@SequenceGenerator(name="userentity_generator",
sequenceName="userentity_seq",allocationSize=1)
private int id;
@Column
private String Username;
@Column
private String Password;
@Column
private String MobileNumber;
@Column
private String MailId;
@Column
private String Address;
private String food;


@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="address_id")
private Address address;

@OneToMany(cascade = CascadeType.ALL)
@JoinColumn(name = "deliveryman")
private List<DeliveryMan> deliveryman;

@OneToOne(cascade=CascadeType.ALL)
private Payment payment;


@ManyToMany(cascade=CascadeType.ALL)
@JoinTable(name=" userentity_skill_relation",
joinColumns= @JoinColumn(name="user_id"),
inverseJoinColumns= @JoinColumn(name="history_id"))
private List<History> history;


@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="orderstatus_id")
private OrderStatus orderstatus;



public UserEntity(int id, String username, String password, String mobileNumber, String mailId, String address,
		String food) {
	super();
	this.id = id;
	Username = username;
	Password = password;
	MobileNumber = mobileNumber;
	MailId = mailId;
	Address = address;
	this.food = food;
}
public UserEntity() {
	super();
	// TODO Auto-generated constructor stub
}
public String getFood() {
	return food;
}
public void setFood(String food) {
	this.food = food;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}


}
