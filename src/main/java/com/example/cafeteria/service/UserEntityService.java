package com.example.cafeteria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cafeteria.Exception.UserEntityNotFoundException;
import com.example.cafeteria.model.UserEntity;
import com.example.cafeteria.repository.UserEntityRepository;

@Service
public class UserEntityService {
	@Autowired
	UserEntityRepository userentityrepository;

	public UserEntity createuserentity(UserEntity userentity) {
		UserEntity user=userentityrepository.save(userentity);
		
		return user;
	}

	public UserEntity getUserEntitybyid(int id) throws UserEntityNotFoundException {
		Optional<UserEntity>users=userentityrepository.findById(id);
		if(users.isPresent()) {
			UserEntity user=users.get();
			return user;
		}else {
			throw new UserEntityNotFoundException("Given data is not found");
		}
	}

	public UserEntity updateUserEntity(UserEntity userentity, int id) throws UserEntityNotFoundException {
		Optional<UserEntity>users=userentityrepository.findById(id);
		if(users.isPresent()) {
			UserEntity user=users.get();
			if(userentity.getUsername()!=null) {
				user.setUsername(userentity.getUsername());
			}
			if(userentity.getPassword()!=null) {
				user.setPassword(userentity.getPassword());   
			}
			if(userentity.getMobileNumber()!=null)
			{
				user.setMobileNumber(userentity.getMobileNumber());
			}
			if(userentity.getMailId()!=null) {
				user.setMailId(userentity.getMailId());
			}
			if(userentity.getAddress()!=null) {
				user.setAddress(userentity.getAddress());
			}
			
			return userentityrepository.save(user);
		}
		else {
			throw new UserEntityNotFoundException("Given data is not found");

		}
	}

	public void deleteUserEntity(int id) throws UserEntityNotFoundException {
		Optional<UserEntity>user=userentityrepository.findById(id);
		if(user.isPresent()) {
			userentityrepository.deleteById(id);
		}else {
			throw new UserEntityNotFoundException("Given data is not found");

		}
	}

	public List<UserEntity> getuserentity() throws UserEntityNotFoundException {
		List<UserEntity> user=userentityrepository.findAll();
		if(user.size()>0) {
			return user;
		}else {
			throw new UserEntityNotFoundException("no data found ");
		}
		
	}
}
