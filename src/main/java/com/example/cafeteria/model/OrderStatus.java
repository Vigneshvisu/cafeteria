package com.example.cafeteria.model;

import java.sql.Timestamp;
import java.util.Date;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class OrderStatus {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
	generator="orderstatus_generator")
	@SequenceGenerator(name="orderstatus_generator",
	sequenceName="orderstatus_seq",allocationSize=1)
	private int orderid;
	@Column
	private Date orderingDate;
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
	private DeliveryMan deliveryman;
	
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name = "payment")
//	private Payment payment;

	
	public OrderStatus(int orderid, Timestamp orderingDate, boolean orderAssigned, boolean orderDispatched,
			boolean orderDelivered, UserEntity userentity,  Payment payment) {
		super();
		this.orderid = orderid;
		this.orderingDate = orderingDate;
		OrderAssigned = orderAssigned;
	 	OrderDispatched = orderDispatched;
		OrderDelivered = orderDelivered;
		this.userentity = userentity;
		//this.payment = payment;
	}
//	public Payment getPayment() {
//		return payment;
//	}
//	public void setPayment(Payment payment) {
//		this.payment = payment;
//	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public DeliveryMan getDeliveryman() {
		return deliveryman;
	}
	public void setDeliveryman(DeliveryMan deliveryman) {
		this.deliveryman = deliveryman;
	}
	public UserEntity getUserentity() {
		return userentity;
	}
	public void setUserentity(UserEntity userentity) {
		this.userentity = userentity;
	}
	

	public OrderStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Date getOrderingDate() {
		return orderingDate;
	}
	public void setOrderingDate(Date orderingDate) {
		this.orderingDate = orderingDate;
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
