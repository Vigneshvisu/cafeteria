package com.example.cafeteria.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cafeteria.Exception.ProductsNotFoundException;
import com.example.cafeteria.model.Products;
import com.example.cafeteria.repository.AddressRepository;
import com.example.cafeteria.repository.ProductsRepository;

@Service
public class ProductsService {
	@Autowired
	ProductsRepository productsrepository;

	public Products createproducts(Products products) {
		Products pro=productsrepository.save(products);
		
		return pro;
	}

	public Products getProductsbyid(int id) throws ProductsNotFoundException {
		Optional<Products> produ=productsrepository.findById(id);
		if(produ.isPresent()) {
			Products pro=produ.get();
			return pro;
		}else {
			throw new ProductsNotFoundException("Given data is not found");
		}
	}

	public Products updateProducts(Products products, int id) throws ProductsNotFoundException {
		Optional<Products> produ=productsrepository.findById(products.getId());
		if(produ.isPresent()) {
			Products pro=produ.get();
			if(products.getName()!=null) {
				pro.setName(products.getName());
			}
			return productsrepository.save(pro);
		}
		else {
			throw new ProductsNotFoundException("Given data is not found");

		}
	}

	public void deleteproducts(int id) throws ProductsNotFoundException {
		Optional<Products> pro=productsrepository.findById(id);
		if(pro.isPresent()) {
			productsrepository.deleteById(id);
		}else {
			throw new ProductsNotFoundException("Given data is not found");

		}
	}

	public List<Products> getproducts() throws ProductsNotFoundException {
		List<Products> pro=productsrepository.findAll();
		if(pro.size()>0) {
			return pro;
		}else {
			throw new ProductsNotFoundException("no data found ");
		}
		
	}
}