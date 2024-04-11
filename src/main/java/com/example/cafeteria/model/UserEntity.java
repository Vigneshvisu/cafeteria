package com.example.cafeteria.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UserEntity {
@Id
@Column
@GeneratedValue(strategy=GenerationType.TABLE)
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
@JoinColumn(name="address_id")
private String food;
@ManyToOne(cascade=CascadeType.ALL)


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
