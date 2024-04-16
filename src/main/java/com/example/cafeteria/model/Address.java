package com.example.cafeteria.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Address {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	@Column
	private String StreetName;
	@Column
	private String City;
	@Column
	private String pincode;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "deliveryman")
	private List<DeliveryMan> deliveryman;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int id, String streetName, String city, String pincode, List<DeliveryMan> deliveryman) {
		super();
		this.id = id;
		StreetName = streetName;
		City = city;
		this.pincode = pincode;
		this.deliveryman = deliveryman;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreetName() {
		return StreetName;
	}

	public void setStreetName(String streetName) {
		StreetName = streetName;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public List<DeliveryMan> getDeliveryman() {
		return deliveryman;
	}

	public void setDeliveryman(List<DeliveryMan> deliveryman) {
		this.deliveryman = deliveryman;
	}

}
