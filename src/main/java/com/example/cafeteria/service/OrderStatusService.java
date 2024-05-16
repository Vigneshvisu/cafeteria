package com.example.cafeteria.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cafeteria.Exception.OrderStatusNotFoundException;
import com.example.cafeteria.Exception.UserEntityNotFoundException;
import com.example.cafeteria.model.Address;
import com.example.cafeteria.model.OrderStatus;
import com.example.cafeteria.model.UserEntity;
import com.example.cafeteria.repository.AddressRepository;
import com.example.cafeteria.repository.OrderStatusRepository;
import com.example.cafeteria.repository.UserEntityRepository;

@Service
public class OrderStatusService {
	@Autowired
	OrderStatusRepository orderstatusrepository;

	public OrderStatus createorderstatus(OrderStatus orderstatus) {
		OrderStatus ord=orderstatusrepository.save(orderstatus);
	
		return ord;
	}

	public OrderStatus getOrderStatusbyid(int id) throws OrderStatusNotFoundException {
		Optional<OrderStatus> ord=orderstatusrepository.findById(id);
		if(ord.isPresent()) {
			OrderStatus ord1=ord.get();
			return ord1;
		}else {
			throw new OrderStatusNotFoundException("Given data is not found");
		}
	}

	public OrderStatus updateOrderStatus(OrderStatus orderstatus, int id) throws OrderStatusNotFoundException {
		Optional<OrderStatus> order=orderstatusrepository.findById(id);
		if(order.isPresent()) {
			OrderStatus ord=order.get();
			if(orderstatus.getOrderingDate()!=null) {
				ord.setOrderingDate(orderstatus.getOrderingDate());
			}
			if(orderstatus.isOrderAssigned()!=false) {
				ord.setOrderAssigned(orderstatus.isOrderAssigned()); 
			}
			if(orderstatus.isOrderDispatched()!=false)
			{
				ord.setOrderDispatched(orderstatus.isOrderDispatched());
			}
			if(orderstatus.isOrderDelivered()!=false) {
				ord.setOrderDelivered(orderstatus.isOrderDelivered());
			}
			return orderstatusrepository.save(ord);
		}
		else {
			throw new OrderStatusNotFoundException("Given data is not found");

		}
	}

	public void deleteOrderStatus(int id) throws OrderStatusNotFoundException {
		Optional<OrderStatus>ord=orderstatusrepository.findById(id);
		if(ord.isPresent()) {
			orderstatusrepository.deleteById(id);
		}else {
			throw new OrderStatusNotFoundException("Given data is not found");

		}
	}
	public OrderStatus viewOrder(Integer id) throws OrderStatusNotFoundException {
		Optional<OrderStatus> opt = orderstatusrepository.findById(id);
		if(opt.isPresent()) {
			OrderStatus order = opt.get();
			return order;
		}else {
			throw new OrderStatusNotFoundException("No Order found with ID: "+id);
		}
	}

	public List<OrderStatus> getorderstatus() throws OrderStatusNotFoundException {
		List<OrderStatus>ord=orderstatusrepository.findAll();
		if(ord.size()>0) {
			return ord;
		}else {
			throw new OrderStatusNotFoundException("no data found ");
		}
		
	}
}