package com.example.cafeteria.model;

import java.util.List;

import org.springframework.stereotype.Service;

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
public class History {
	@Column
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
	generator="history_generator")
	@SequenceGenerator(name="history_generator",
	sequenceName="history_seq",allocationSize=1)
	private int id;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "deliveryman")
	private DeliveryMan deliveryman;
	
	@ManyToMany (mappedBy= "history")//bi-directional, here wont give a mappedby that are denoted to u
	private List<UserEntity> userentity;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinTable(name="address_id")
	private Address address;


	public History(int id, DeliveryMan deliveryman, UserEntity userentity, Address address, Payment payment) {
		super();
		this.id = id;
		this.deliveryman = deliveryman;
		
		this.address = address;
		
	}

	public History() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DeliveryMan getDeliveryman() {
		return deliveryman;
	}

	public void setDeliveryman(DeliveryMan deliveryman) {
		this.deliveryman = deliveryman;
	}

	public List<UserEntity> getUserentity() {
		return userentity;
	}

	public void setUserentity(List<UserEntity> userentity) {
		this.userentity = userentity;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	

}
