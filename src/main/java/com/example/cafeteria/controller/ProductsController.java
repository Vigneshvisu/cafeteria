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

import com.example.cafeteria.Exception.ProductsNotFoundException;
import com.example.cafeteria.model.Products;
import com.example.cafeteria.service.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductsController {
	@Autowired
	ProductsService productsservice;
			@PostMapping
			public ResponseEntity<Products> createProduct(@RequestBody Products product) {
				Products pro = productsservice.createproducts(product);
				return new ResponseEntity<Products>(pro, HttpStatus.CREATED);
			}

			@GetMapping
			public ResponseEntity<List<Products>> getProduct() throws ProductsNotFoundException {
				List<Products>products = productsservice.getproducts();
				return new ResponseEntity<List<Products>>(products, HttpStatus.OK);

			}

			@GetMapping("/{id}")
			public ResponseEntity<Products> getProductbyid(@PathVariable("id") int id) throws ProductsNotFoundException {
				Products products = productsservice.getProductsbyid(id);
				return new ResponseEntity<Products>(products, HttpStatus.OK);
			}

			@PutMapping("/{id}")
			public ResponseEntity<Products> updateProduct(@RequestBody Products products, @PathVariable("id") int id) throws ProductsNotFoundException {
				Products products1 = productsservice.updateProducts(products, id);
				return new ResponseEntity<Products>(products, HttpStatus.CREATED);
			}

			@DeleteMapping("/{id}")
			public HttpStatus deleteProduct(@PathVariable("id") int id) throws ProductsNotFoundException {
				productsservice.deleteproducts(id);
				return HttpStatus.OK;
			}

}
