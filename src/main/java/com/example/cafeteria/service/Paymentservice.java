package com.example.cafeteria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cafeteria.Exception.PaymentNotFoundException;
import com.example.cafeteria.model.Account;
import com.example.cafeteria.model.Payment;
import com.example.cafeteria.repository.AccountRepository;
import com.example.cafeteria.repository.PaymentRepository;
@Service
public class Paymentservice {
	@Autowired
	PaymentRepository paymentrepository;
	Accountservice accountservice;
	@Autowired
	AccountRepository accountrepository;

	public Payment payment(Payment payment) {
		return payment;}
	
	
//	public Payment Paymentmode(Payment payment ) throws PaymentNotFoundException {
//        Account account = accountrepository.findByaccounttype(payment.getPaymentmode());
//        if (payment.getPaymentmode().equalsIgnoreCase("upi")) {
//        	payment.setPaymentmode(account.getAccountType());
//            return paymentrepository.save(payment);
//        }else {
//        	throw new PaymentNotFoundException("given data is not found");
//        }
//	}
//	
	
//	public Payment savePayment(Payment payment) {
//        return paymentrepository.save(payment);
//    }
//
//    public List<Payment> getAllPayments() {
//        return paymentrepository.findAll();
//    }

	public Payment createpayment(Payment payment) {
		Payment ord=paymentrepository.save(payment);
		return ord;
	}

	public Payment getPaymentbyid(int id) throws PaymentNotFoundException {
		Optional<Payment> ord=paymentrepository.findById(id);
		if(ord.isPresent()) {
			Payment ord1=ord.get();
			return ord1;
		}else {
			throw new PaymentNotFoundException("Given data is not found");
		}
	}

	public Payment updatePayment(Payment payment, int id) throws PaymentNotFoundException {
		Optional<Payment> order=paymentrepository.findById(id);
		if(order.isPresent()) {
			Payment ord=order.get();
			if(payment.isAmountcredited()!=false) {
				ord.setAmountcredited(payment.isAmountcredited());
			}
			if(payment.getPaymentmode()!=null) {
				ord.setPaymentmode(payment.getPaymentmode());
			}
			if(payment.getCOD()!=null) {
				ord.setCOD(payment.getCOD()); 
			}
			
			if(payment.getDeliveryfee()!=null)
			{
				ord.setDeliveryfee(payment.getDeliveryfee());
			}
			
			return paymentrepository.save(ord);
		}
		else {
			throw new PaymentNotFoundException("Given data is not found");

		}
	}

	public void deletePayment(int id) throws PaymentNotFoundException {
		Optional<Payment>ord=paymentrepository.findById(id);
		if(ord.isPresent()) {
			paymentrepository.deleteById(id);
		}else {
			throw new PaymentNotFoundException("Given data is not found");

		}
	}

	public List<Payment> getpayment() throws PaymentNotFoundException {
		List<Payment>ord=paymentrepository.findAll();
		if(ord.size()>0) {
			return ord;
		}else {
			throw new PaymentNotFoundException("no data found ");
		}
		
	}
	public Payment Payments(Payment payment) throws PaymentNotFoundException {
	   String ac = payment.getAccounttype(); 
	    Account obj1 = accountrepository.findByAccountType(ac); 
	    String var = obj1.getAccountType(); 

	    if (ac != null && var != null && ac.equals(var)) { 
	        payment.setAccountId(null); 
	       Payment pay= paymentrepository.save(payment);
	        return pay;
	    } else {
	       throw new PaymentNotFoundException("accoud data mis match");
	    }
	}
	
		
}
