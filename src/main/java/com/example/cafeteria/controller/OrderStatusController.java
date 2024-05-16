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

import com.example.cafeteria.Exception.OrderStatusNotFoundException;
import com.example.cafeteria.model.OrderStatus;
import com.example.cafeteria.service.OrderStatusService;

@RestController
@RequestMapping("/orderstatus")
public class OrderStatusController {
	@Autowired
	OrderStatusService orderstatusservice;

	@PostMapping
	public ResponseEntity<OrderStatus> createOrderStatus(@RequestBody OrderStatus orderstatus) {
		OrderStatus ord = orderstatusservice.createorderstatus(orderstatus);
		return new ResponseEntity<OrderStatus>(ord, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<OrderStatus>> getOrderStatus() throws OrderStatusNotFoundException {
		List<OrderStatus>orderstatus = orderstatusservice.getorderstatus();
		return new ResponseEntity<List<OrderStatus>>(orderstatus, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<OrderStatus> getOrderStatusbyid(@PathVariable("id") int id) throws OrderStatusNotFoundException {
		OrderStatus orderstatus = orderstatusservice.getOrderStatusbyid(id);
		return new ResponseEntity<OrderStatus>(orderstatus, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<OrderStatus> updateOrderStatus(@RequestBody OrderStatus orderstatus, @PathVariable("id") int id) throws OrderStatusNotFoundException {
		OrderStatus order = orderstatusservice.updateOrderStatus(orderstatus, id);
		return new ResponseEntity<OrderStatus>(order, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteOrderStatus(@PathVariable("id") int id) throws OrderStatusNotFoundException {
		orderstatusservice.deleteOrderStatus(id);
		return HttpStatus.OK;
	}
}