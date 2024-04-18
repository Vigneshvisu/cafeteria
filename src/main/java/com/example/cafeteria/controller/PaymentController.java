package com.example.cafeteria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.cafeteria.Exception.AddressNotFoundException;
import com.example.cafeteria.Exception.CategoryNotFoundException;
import com.example.cafeteria.Exception.PaymentNotFoundException;
import com.example.cafeteria.model.Category;
import com.example.cafeteria.model.Payment;
import com.example.cafeteria.service.Categoryservice;
import com.example.cafeteria.service.Paymentservice;

public class PaymentController {
	@Autowired
	Paymentservice paymentservice;

	@PostMapping
	public ResponseEntity<Payment> createPayment(Payment payment) {
		Payment payment1 = paymentservice.createpayment1(payment);
		return new ResponseEntity<Payment>(payment1, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Payment> updatePayment(@RequestBody Payment payment, @PathVariable("id") int id) throws PaymentNotFoundException {
		Payment payment2 = paymentservice.updatePayment(payment, id);
		return new ResponseEntity<Payment>(payment2, HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	public HttpStatus deleteCategory(@PathVariable("id") int id) throws AddressNotFoundException, PaymentNotFoundException {
		paymentservice.deletePayment(id);
		return HttpStatus.OK;
	}
}
