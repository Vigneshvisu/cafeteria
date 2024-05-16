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
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "category_generator")
	@SequenceGenerator(name = "category_generator", sequenceName = "category_seq", allocationSize = 1)
	private int categoryid;
	private String foodname;
	private String foodtitle;
	private boolean foodready;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address")
	private Address address;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "products")
	private Products products;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Category(int categoryid, String foodname, String foodtitle, boolean foodready, Address address, Products products) {
		super();
		this.categoryid = categoryid;
		this.foodname = foodname;
		this.foodtitle = foodtitle;
		this.foodready = foodready;
		this.address = address;
		this.products = products;
	}

	
	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public String getFoodname() {
		return foodname;
	}

	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}

	public String getFoodtitle() {
		return foodtitle;
	}

	public void setFoodtitle(String foodtitle) {
		this.foodtitle = foodtitle;
	}

	public boolean isFoodready() {

		return foodready;
	}

	public void setFoodready(boolean foodready) {
		this.foodready = foodready;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

}