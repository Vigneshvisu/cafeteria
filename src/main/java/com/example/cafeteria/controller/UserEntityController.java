package com.example.cafeteria.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cafeteria.Exception.UserEntityNotFoundException;
import com.example.cafeteria.model.UserEntity;
import com.example.cafeteria.service.UserEntityService;

@RestController
@RequestMapping("/userentity")
public class  UserEntityController  {
	@Autowired
	UserEntityService userentityservice;

	@PostMapping
	public ResponseEntity<UserEntity> createAddress(@RequestBody UserEntity userentity) {
		UserEntity user = userentityservice.createuserentity(userentity);
		return new ResponseEntity<UserEntity>(user, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<UserEntity>> getUserEntity() throws UserEntityNotFoundException {
		List<UserEntity> userentity = userentityservice.getuserentity();
		return new ResponseEntity<List<UserEntity>>(userentity, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<UserEntity> getUserEntitybyid(@PathVariable("id") int id) throws UserEntityNotFoundException {
		UserEntity userentity =userentityservice.getUserEntitybyid(id);
		return new ResponseEntity<UserEntity>(userentity, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserEntity> updateUserEntity(@RequestBody UserEntity userentity, @PathVariable("id") int id) throws UserEntityNotFoundException {
		UserEntity user = userentityservice.updateUserEntity(userentity, id);
		return new ResponseEntity<UserEntity>(user, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteUserEntity(@PathVariable("id") int id) throws UserEntityNotFoundException {
		userentityservice.deleteUserEntity(id);
		return HttpStatus.OK;
	}

}