package com.example.cafeteria.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cafeteria.model.History;
import com.example.cafeteria.model.OrderStatus;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Integer> {

	OrderStatus save(OrderStatus orderstatus);

	Optional<OrderStatus> findById(int id);

	List<OrderStatus> findAll();

	void deleteById(int id);

}
