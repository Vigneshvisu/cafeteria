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
public class Products {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
	generator="products_generator")
	@SequenceGenerator(name="products_generator",
	sequenceName="products_seq",allocationSize=1)	
	private int productid;
	@Column
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "category")
	private List<Category> category;
	
	

	public Products(int productid, String name, List<Category> category) {
		super();
		this.productid = productid;
		this.name = name;
		this.category = category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public List<Category> getCategory() {
		return category;
	}
}
