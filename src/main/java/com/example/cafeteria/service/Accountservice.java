package com.example.cafeteria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cafeteria.Exception.PaymentNotFoundException;
import com.example.cafeteria.model.Account;
import com.example.cafeteria.repository.AccountRepository;

@Service
public class Accountservice {
	@Autowired
	AccountRepository accountrepository;

	public Account account(Account account) {
		Account account1=accountrepository.save(account);
		return account1;}
	

	public Account createAccount(Account account) {
		Account ord=accountrepository.save(account);
		return ord;
	}

	public Account getAccountbyid(int id) throws PaymentNotFoundException {
		Optional<Account> ord=accountrepository.findById(id);
		if(ord.isPresent()) {
			Account ord1=ord.get();
			return ord1;
				}
			else {
			throw new PaymentNotFoundException("Given data is not found");
	}
	}

	public Account updateAccount(Account account, int id) throws PaymentNotFoundException {
		Optional<Account> order=accountrepository.findById(id);
		if(order.isPresent()) {
			Account ord=order.get();
			
			if(ord.getAccountnumber()!=null)
			{
				ord.setAccountnumber(account.getAccountnumber());
			}
			
			if(ord.getUPI()!=null) {
				ord.setUPI(account.getUPI());
			}

			if(ord.getAccounttype()!=null) {
				ord.setAccounttype(account.getAccounttype());}
			
			return accountrepository.save(ord);
		}
		else {
			throw new PaymentNotFoundException("Account data data is not found");

		}
	}

	public void deleteAccount(int id) throws PaymentNotFoundException {
		Optional<Account>ord=accountrepository.findById(id);
		if(ord.isPresent()) {
			accountrepository.deleteById(id);
		}else {
			throw new PaymentNotFoundException("Given data is not found");

		}
	}

	public List<Account> getaccount() throws PaymentNotFoundException {
		List<Account>ord=accountrepository.findAll();
		if(ord.size()>0) {
			return ord;
		}else {
			throw new PaymentNotFoundException("no data found ");
		}
		
	}
	
//	public Account getbyAccounttype(String accounttype) throws PaymentNotFoundException {
//		Optional<Account> ord=accountrepository.findByaccounttype(accounttype);
//		if(ord.isPresent()) {
//			Account ord1=ord.get();
//			return ord1;
//				}
//			else {
//			throw new PaymentNotFoundException("Given data is not found");
//			
//	}
//		Account getbypaymentmode(String paymentmode) throws PaymentNotFoundException {
//			Optional<Payment> ord=paymentrepository.findBypaymentmode(paymentmode);
//			if(ord.isPresent()) {
//				Payment ord1=ord.get();
//				return ord1;
//			}else {
//				throw new PaymentNotFoundException("Given data is not found");
//			}
//		}	
}
//}
