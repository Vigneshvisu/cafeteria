package com.example.cafeteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cafeteria.model.OrderStatus;
import com.example.cafeteria.model.Payment;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	Payment save(Payment payment);



}
