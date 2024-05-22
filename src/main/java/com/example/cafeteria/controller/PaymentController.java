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

import com.example.cafeteria.Exception.PaymentNotFoundException;
import com.example.cafeteria.model.Payment;
import com.example.cafeteria.service.Paymentservice;
@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	Paymentservice paymentservice;
//	  @PostMapping
//	    public Payment addPayment(@RequestBody Payment payment) {
//	        return paymentservice.savePayment(payment);
//	    }
//
//	    @GetMapping
//	    public List<Payment> getAllPayments() {
//	        return paymentservice.getAllPayments();
//	    }


	@PostMapping
	public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
		Payment payment1= paymentservice.createpayment(payment);
		return new ResponseEntity<Payment>(payment1, HttpStatus.CREATED);
		
	}
	
	@PostMapping("/payments")
	public ResponseEntity<Payment> Paymentmode(@RequestBody Payment payment) throws PaymentNotFoundException {
		Payment payment1= paymentservice.Payments(payment);
		return new ResponseEntity<Payment>(payment1, HttpStatus.CREATED);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Payment>> getPayment() throws PaymentNotFoundException {
		List<Payment>payment = paymentservice.getpayment();
		return new ResponseEntity<List<Payment>>(payment, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Payment> getPaymentbyid(@PathVariable("id") int id) throws PaymentNotFoundException {
		Payment payment = paymentservice.getPaymentbyid(id);
		return new ResponseEntity<Payment>(payment, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Payment> updatePayment(@RequestBody Payment payment, @PathVariable("id") int id) throws PaymentNotFoundException {
		Payment payment2 = paymentservice.updatePayment(payment, id);
		return new ResponseEntity<Payment>(payment2, HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	public HttpStatus deletePayment(@PathVariable("id") int id) throws  PaymentNotFoundException {
		paymentservice.deletePayment(id);
		return HttpStatus.OK;
	}
}
