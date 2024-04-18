package com.example.cafeteria.model;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class OrderStatus {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
	generator="orderstatus_generator")
	@SequenceGenerator(name="orderstatus_generator",
	sequenceName="orderstatus_seq",allocationSize=1)	private int id;
	@Column
	private Timestamp orderingDate;
	
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "payment")
//	private List<Payment> payment;
	@Column
	 private boolean OrderAssigned;
//	public List<Payment> getPayment() {
//		return payment;
//	}
//	public void setPayment(List<Payment> payment) {
//		this.payment = payment;
//	}
	public UserEntity getUserentity() {
		return userentity;
	}
	public void setUserentity(UserEntity userentity) {
		this.userentity = userentity;
	}
	
	public DeliveryMan getDeliveryman_id() {
		return deliveryman_id;
	}
	public void setDeliveryman_id(DeliveryMan deliveryman_id) {
		this.deliveryman_id = deliveryman_id;
	}

	@Column
	 private boolean OrderDispatched;
	@Column
	 private boolean OrderDelivered;
	
	public OrderStatus(int id, Timestamp orderingDate, boolean orderAssigned,
			boolean orderDispatched, boolean orderDelivered, UserEntity userentity, DeliveryMan deliveryman_id) {
		super();
		this.id = id;
		this.orderingDate = orderingDate;
//		this.payment = payment;
		OrderAssigned = orderAssigned;
		OrderDispatched = orderDispatched;
		OrderDelivered = orderDelivered;
		this.userentity = userentity;
		this.deliveryman_id = deliveryman_id;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id",unique=false)
	private UserEntity userentity;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="deliveryman_id",unique=false)
	private DeliveryMan deliveryman_id;


	
	

	public OrderStatus() {
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
