package com.example.cafeteria.model;

import java.sql.Timestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class History {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	@Column
	private Timestamp orderingDate;
	@Column
	private String upi;
	@Column
	 private boolean Amountcredited;
	@Column
	 private boolean OrderAssigned;
	@Column
	 private boolean OrderDispatched;
	@Column
	 private boolean OrderDelivered;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id",unique=false)
	private UserEntity userentity;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="deliveryman_id",unique=false)
	private DeliveryMan deliveryman_id;


	
	

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
	public Timestamp getOrderingDate() {
		return orderingDate;
	}
	public void setOrderingDate(Timestamp orderingDate) {
		this.orderingDate = orderingDate;
	}
	public String getUpi() {
		return upi;
	}
	public void setUpi(String upi) {
		this.upi = upi;
	}
	public boolean isAmountcredited() {
		return Amountcredited;
	}
	public void setAmountcredited(boolean amountcredited) {
		Amountcredited = amountcredited;
	}
	public boolean isOrderAssigned() {
		return OrderAssigned;
	}
	public void setOrderAssigned(boolean orderAssigned) {
		OrderAssigned = orderAssigned;
	}
	public boolean isOrderDispatched() {
		return OrderDispatched;
	}
	public void setOrderDispatched(boolean orderDispatched) {
		OrderDispatched = orderDispatched;
	}
	public boolean isOrderDelivered() {
		return OrderDelivered;
	}
	public void setOrderDelivered(boolean orderDelivered) {
		OrderDelivered = orderDelivered;
	}
	
	
	
}
