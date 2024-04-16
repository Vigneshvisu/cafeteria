package com.example.cafeteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cafeteria.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

}
