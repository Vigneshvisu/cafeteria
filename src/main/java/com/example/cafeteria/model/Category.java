package com.example.cafeteria.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
@Id
@Column
@GeneratedValue(strategy=GenerationType.TABLE)
private int foodid;
private String foodname;
private String foodtitle;
private boolean foodready;

@OneToMany(cascade=CascadeType.ALL)
@JoinColumn(name="userentity")
private List<UserEntity> userentity ;


@OneToMany(cascade=CascadeType.ALL)
@JoinColumn(name="deliveryman")
private List<DeliveryMan> deliveryman;



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