package com.example.cafeteria.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cafeteria.model.OrderStatus;
import com.example.cafeteria.model.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer>{

	UserEntity save(UserEntity userentity);

	Optional<UserEntity> findById(int id);

	void deleteById(int id);

	List<UserEntity> findAll();

}
