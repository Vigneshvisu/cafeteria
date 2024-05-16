package com.example.cafeteria.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cafeteria.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

//	Category save(Optional<Category> food);
//
//	Optional<Category> findById(int id);
//
//	List<Category> findAll();
//
//	void deleteById(int id);

	
}
