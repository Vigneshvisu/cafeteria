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
@GeneratedValue(strategy=GenerationType.TABLE)
   	private int id;
	@Column
	private String StreetName;
	@Column
	private String City;
	@Column
	private String pincode;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="deliveryman")
	private List<DeliveryMan> deliveryman;


}
