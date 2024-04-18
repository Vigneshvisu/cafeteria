package com.example.cafeteria.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cafeteria.Exception.DeliveryManServiceNotFoundException;
import com.example.cafeteria.model.Address;
import com.example.cafeteria.model.DeliveryMan;
import com.example.cafeteria.repository.AddressRepository;
import com.example.cafeteria.repository.DeliveryManRepository;


@Service
public class DeliveryManService {
	@Autowired
	DeliveryManRepository deliverymanrepository;

	public DeliveryMan createdeliverymanService(DeliveryMan deliveryman) {
		DeliveryMan del=deliverymanrepository.save(deliveryman);
		
		return del;
	}

	public DeliveryMan getDeliveryManServicebyid(int id) throws DeliveryManServiceNotFoundException {
		Optional<DeliveryMan>deli=deliverymanrepository.findById(id);
		if(deli.isPresent()) {
			DeliveryMan del=deli.get();
			return del;
		}else {
			throw new DeliveryManServiceNotFoundException("Given data is not found");
		}
	}

	public DeliveryMan updateDeliveryManService(DeliveryMan deliveryman, int id) throws DeliveryManServiceNotFoundException {
		Optional<DeliveryMan> deli=deliverymanrepository.findById(id);
		if(deli.isPresent()) {
			DeliveryMan del=deli.get();
			if(deliveryman.getName()!=null) {
				del.setName(deliveryman.getName());
			}
			if(deliveryman.getMobile()!=null) {
				del.setMobile(deliveryman.getMobile());  
			}
			if(deliveryman.getAddress()!=null)
			{
				del.setAddress(deliveryman.getAddress());
			}
			return deliverymanrepository.save(del);
		}
		else {
			throw new DeliveryManServiceNotFoundException("Given data is not found");

		}
	}


	public void deleteDeliveryManService(int id) throws DeliveryManServiceNotFoundException {
		Optional<DeliveryMan> del=deliverymanrepository.findById(id);
		if(del.isPresent()) {
			deliverymanrepository.deleteById(id);
		}else {
			throw new DeliveryManServiceNotFoundException("Given data is not found");

		}
	}

	public List<DeliveryMan> getdeliverymanService() throws DeliveryManServiceNotFoundException {
		List<DeliveryMan> del=deliverymanrepository.findAll();
		if(del.size()>0) {
			return del;
		}else {
			throw new DeliveryManServiceNotFoundException("no data found ");
		}
		
	}
}