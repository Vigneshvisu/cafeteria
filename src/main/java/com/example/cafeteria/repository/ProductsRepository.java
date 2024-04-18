package com.example.cafeteria.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cafeteria.model.OrderStatus;
import com.example.cafeteria.model.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer> {

	Products save(Products products);

	Optional<Products> findById(int id);

	void deleteById(int id);

	List<Products> findAll();

}
