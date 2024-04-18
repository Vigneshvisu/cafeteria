package com.example.cafeteria.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cafeteria.model.DeliveryMan;
import com.example.cafeteria.service.DeliveryManService;

public interface DeliveryManRepository extends  JpaRepository<DeliveryMan, Integer>{

//	DeliveryManService save(DeliveryManService deliverymanService);

	Optional<DeliveryMan> findById(int id);

//	List<DeliveryManService> findAll();

//	void deleteById(int id);

}
