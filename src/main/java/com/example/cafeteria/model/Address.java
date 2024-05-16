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
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
	generator="address_generator")
	@SequenceGenerator(name="address_generator",
	sequenceName="address_seq",allocationSize=1)
		private int addressid;
	@Column
	private String StreetName;
	@Column
	private String City;
	@Column
	private String pincode;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderstatus")
	private OrderStatus orderstatus;

	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "deliveryman")
	private DeliveryMan deliveryman;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userentity")
	private UserEntity userentity;

	
	
	public Address(int addressid, String streetName, String city, String pincode, OrderStatus orderstatus,
			DeliveryMan deliveryman, UserEntity userentity) {
		super();
		this.addressid = addressid;
		StreetName = streetName;
		City = city;
		this.pincode = pincode;
		this.orderstatus = orderstatus;
		this.deliveryman = deliveryman;
		this.userentity = userentity;
	}

	public UserEntity getUserentity() {
		return userentity;
	}

	public void setUserentity(UserEntity userentity) {
		this.userentity = userentity;
	}

	

	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
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
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}


	public OrderStatus getOrderstatus() {
		return orderstatus;
	}


	public void setOrderstatus(OrderStatus orderstatus) {
		this.orderstatus = orderstatus;
	}


	public DeliveryMan getDeliveryman() {
		return deliveryman;
	}


	public void setDeliveryman(DeliveryMan deliveryman) {
		this.deliveryman = deliveryman;
	}


	

}
