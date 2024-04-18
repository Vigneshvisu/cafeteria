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
public class Category {
	@Id
	@Column

	@GeneratedValue(strategy=GenerationType.SEQUENCE,
	generator="category_generator")
	@SequenceGenerator(name="category_generator",
	sequenceName="category_seq",allocationSize=1)
	private int foodid;
	private String foodname;
	private String foodtitle;
	private boolean foodready;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "products")
	private List<Products> products;

	
	public Category(int foodid, String foodname, String foodtitle, boolean foodready, List<UserEntity> userentity,
			List<DeliveryMan> deliveryman) {
		super();
		this.foodid = foodid;
		this.foodname = foodname;
		this.foodtitle = foodtitle;
		this.foodready = foodready;
		
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getFoodid() {
		return foodid;
	}

	public void setFoodid(int foodid) {
		this.foodid = foodid;
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
}