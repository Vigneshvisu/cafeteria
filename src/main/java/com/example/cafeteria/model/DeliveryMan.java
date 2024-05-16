package com.example.cafeteria.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class DeliveryMan {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
	generator="deliveryman_generator")
	@SequenceGenerator(name="deliveryman_generator",
	sequenceName="deliveryman_seq",allocationSize=1)
	private int dmid;
	@Column
	private String Name;
	@Column
	private String mobile;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderstatus")
	private OrderStatus orderstatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userentity")
	private UserEntity userentity;
		


	public DeliveryMan(int dmid, String name, String mobile, Address address, OrderStatus orderstatus,
			UserEntity userentity) {
		super();
		this.dmid = dmid;
		Name = name;
		this.mobile = mobile;
		this.address = address;
		this.orderstatus = orderstatus;
		this.userentity = userentity;
	}

	public OrderStatus getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(OrderStatus orderstatus) {
		this.orderstatus = orderstatus;
	}

	public UserEntity getUserentity() {
		return userentity;
	}

	public void setUserentity(UserEntity userentity) {
		this.userentity = userentity;
	}

	
	public int getDmid() {
		return dmid;
	}

	public void setDmid(int dmid) {
		this.dmid = dmid;
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
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	

	public DeliveryMan() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
}
