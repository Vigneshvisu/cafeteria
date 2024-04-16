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

import com.example.cafeteria.model.Address;
import com.example.cafeteria.model.AddressNotFoundException;
import com.example.cafeteria.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
	AddressService addressservice;

	@PostMapping
	public ResponseEntity<Address> createAddress(Address address) {
		Address addres = addressservice.cretaeaddress(address);
		return new ResponseEntity<Address>(addres, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Address>> getAddress() throws AddressNotFoundException {
		List<Address> address = addressservice.getaddress();
		return new ResponseEntity<List<Address>>(address, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Address> getAddressbyid(@PathVariable("id") int id) throws AddressNotFoundException {
		Address address = addressservice.getAddressbyid(id);
		return new ResponseEntity<Address>(address, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Address> updateAddress(@RequestBody Address address, @PathVariable("id") int id) throws AddressNotFoundException {
		Address addres = addressservice.updateAddress(address, id);
		return new ResponseEntity<Address>(addres, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteAddress(@PathVariable("id") int id) throws AddressNotFoundException {
		addressservice.deleteAddress(id);
		return HttpStatus.OK;
	}

}
