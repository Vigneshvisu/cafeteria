package com.example.cafeteria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cafeteria.Exception.AddressNotFoundException;
import com.example.cafeteria.Exception.CategoryNotFoundException;
import com.example.cafeteria.model.Category;
import com.example.cafeteria.service.Categoryservice;
@RestController
@RequestMapping("/category")

public class CategoryController {
	@Autowired
	Categoryservice categoryservice;

	@PostMapping
	public ResponseEntity<Category> createCategory(@RequestBody Category category) {
		Category categorys = categoryservice.createcategory(category);
		return new ResponseEntity<Category>(categorys, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Category>> getCategory() throws CategoryNotFoundException {
		List<Category> category1 = categoryservice.getcategory();
		return new ResponseEntity<List<Category>>(category1, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategorybyid(@PathVariable("id") int id) throws CategoryNotFoundException {
		Category category1 = categoryservice.getCategorybyid(id);
		return new ResponseEntity<Category>(category1, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Category> updateCategory(@RequestBody Category category, @PathVariable("id") int id) throws CategoryNotFoundException {
		Category category2 = categoryservice.updateCategory(category, id);
		return new ResponseEntity<Category>(category2, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteCategory(@PathVariable("id") int id) throws AddressNotFoundException, CategoryNotFoundException {
		categoryservice.deleteCategory(id);
		return HttpStatus.OK;
	}



}
