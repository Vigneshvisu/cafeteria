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
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class DeliveryMan {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
	generator="deliveryman_generator")
	@SequenceGenerator(name="deliveryman_generator",
	sequenceName="deliveryman_seq",allocationSize=1)
	private int id;
	@Column
	private String Name;
	@Column
	private String mobile;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private List<Address> address;
	@Column
	private int DeliveryFee;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getDeliveryFee() {
		return DeliveryFee;
	}

	public void setDeliveryFee(int deliveryFee) {
		DeliveryFee = deliveryFee;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public DeliveryMan(int id, String name, String mobile, List<Address> address, int deliveryFee) {
		super();
		this.id = id;
		Name = name;
		this.mobile = mobile;
		this.address = address;
		DeliveryFee = deliveryFee;
	}

	public DeliveryMan() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
}
