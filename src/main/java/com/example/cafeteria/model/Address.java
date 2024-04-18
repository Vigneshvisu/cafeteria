package com.example.cafeteria.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Address {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
	generator="address_generator")
	@SequenceGenerator(name="address_generator",
	sequenceName="address_seq",allocationSize=1)
		private int id;
	@Column
	private String StreetName;
	@Column
	private String City;
	@Column
	private String pincode;
//	@(cascade = CascadeType.ALL)
//	@JoinColumn(name = "deliveryman")
//	private List<DeliveryMan> deliveryman;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int id, String streetName, String city, String pincode) {
		super();
		this.id = id;
		StreetName = streetName;
		City = city;
		this.pincode = pincode;
//		this.deliveryman = deliveryman;
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

	

}
