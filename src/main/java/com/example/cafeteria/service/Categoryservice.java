package com.example.cafeteria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.cafeteria.Exception.CategoryNotFoundException;
import com.example.cafeteria.model.Category;
import com.example.cafeteria.repository.CategoryRepository;
@Service
public class Categoryservice {
	@Autowired
	CategoryRepository categoryrepository;

	public Category createcategory(Category category) {
		Category category1=categoryrepository.save(category);
		
		return category;
	}

	public Category getCategorybyid(int id) throws CategoryNotFoundException {
		Optional<Category> food=categoryrepository.findById(id);
		if(food.isPresent()) {
			Category ads=food.get();
			return ads;
		}else {
			throw new CategoryNotFoundException("Given data is not found");
		}
	}

	public Category updateCategory(Category category, int id) throws CategoryNotFoundException {
		Optional<Category> food=categoryrepository.findById(category.getFoodid());
		if(food.isPresent()) {
			Category food1=food.get();
			if(category.getFoodname()!=null) {
				food1.setFoodname(category.getFoodname());
			}
			if(category.getFoodtitle()!=null) {
				food1.setFoodtitle(category.getFoodtitle());
			}
			if(category.isFoodready()!=false)
			{
				food1.setFoodready(category.isFoodready());
			}
	
			return categoryrepository.save(food1);
		}
		else {
			throw new CategoryNotFoundException("Given data is not found");

		}
	}

	public void deleteCategory(int id) throws CategoryNotFoundException {
		Optional<Category> food=categoryrepository.findById(id);
		if(food.isPresent()) {
			categoryrepository.deleteById(id);
		}else {
			throw new CategoryNotFoundException("Given data is not found");

		}
	}

	public List<Category> getcategory() throws CategoryNotFoundException {
		List<Category> add=categoryrepository.findAll();
		if(add.size()>0) {
			return add;
		}else {
			throw new CategoryNotFoundException("no data found ");
		}
		
	}


}
