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
import com.example.cafeteria.model.Account;
import com.example.cafeteria.service.Accountservice;

@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired
	Accountservice accountservice;
	
	@PostMapping
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		Account account1= accountservice.createAccount(account);
		return new ResponseEntity<Account>(account1, HttpStatus.CREATED);
		
	}
	@GetMapping
	public ResponseEntity<List<Account>> getAccount() throws PaymentNotFoundException {
		List<Account>account = accountservice.getaccount();
		return new ResponseEntity<List<Account>>(account, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Account> getaccountbyid(@PathVariable("id") int id) throws PaymentNotFoundException {
		Account account = accountservice.getAccountbyid(id);
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Account> updateAccount(@RequestBody Account account, @PathVariable("id") int id) throws PaymentNotFoundException {
		Account account2 = accountservice.updateAccount(account, id);
		return new ResponseEntity<Account>(account2, HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	public HttpStatus deleteAccount(@PathVariable("id") int id) throws  PaymentNotFoundException {
		accountservice.deleteAccount(id);
		return HttpStatus.OK;
	}
}

