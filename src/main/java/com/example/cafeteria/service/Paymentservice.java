package com.example.cafeteria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cafeteria.Exception.OrderStatusNotFoundException;
import com.example.cafeteria.Exception.PaymentNotFoundException;
import com.example.cafeteria.model.Category;
import com.example.cafeteria.model.OrderStatus;
import com.example.cafeteria.model.Payment;
import com.example.cafeteria.repository.CategoryRepository;
import com.example.cafeteria.repository.OrderStatusRepository;
import com.example.cafeteria.repository.PaymentRepository;
@Service
public class Paymentservice {
	@Autowired
	PaymentRepository paymentrepository;

	public Payment payment(Payment payment) {
		Payment Payment1=paymentrepository.save(payment);
		return payment;
	}


	public Payment createpayment1(Payment payment) {
		// TODO Auto-generated method stub
		return null;
	}

	public Payment updatePayment(Payment payment, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deletePayment(int id) {
		// TODO Auto-generated method stub
		
	}
	

	public Payment createpayment(Payment payment) {
		Payment ord=paymentrepository.save(payment);
	
		return ord;
	}

	public Payment getOrderStatusbyid(int id) throws PaymentNotFoundException {
		Optional<Payment> ord=paymentrepository.findById(id);
		if(ord.isPresent()) {
			Payment ord1=ord.get();
			return ord1;
		}else {
			throw new PaymentNotFoundException("Given data is not found");
		}
	}

	public Payment updateOrderStatus(Payment payment, int id) throws PaymentNotFoundException {
		Optional<Payment> order=paymentrepository.findById(payment.getId());
		if(order.isPresent()) {
			Payment ord=order.get();
			if(payment.isAmountcredited()!=false) {
				ord.setAmountcredited(payment.isAmountcredited());
			}
			if(payment.getCOD()!=null) {
				ord.setCOD(payment.getCOD()); 
			}
			if(payment.getBankAccount()!=null)
			{
				ord.setBankAccount(payment.getBankAccount());
			}
			
			if(payment.getUPI()!=null) {
				ord.setUPI(payment.getUPI());
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

	public void deleteOrderStatus(int id) throws PaymentNotFoundException {
		Optional<Payment>ord=paymentrepository.findById(id);
		if(ord.isPresent()) {
			paymentrepository.deleteById(id);
		}else {
			throw new PaymentNotFoundException("Given data is not found");

		}
	}

	public List<Payment> getorderstatus() throws PaymentNotFoundException {
		List<Payment>ord=paymentrepository.findAll();
		if(ord.size()>0) {
			return ord;
		}else {
			throw new PaymentNotFoundException("no data found ");
		}
		
	}
		
}
