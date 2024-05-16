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

import com.example.cafeteria.Exception.DeliveryManServiceNotFoundException;
import com.example.cafeteria.model.DeliveryMan;
import com.example.cafeteria.service.DeliveryManService;


@RestController
@RequestMapping("/deliveryman")
public class DeliveryManController {
	@Autowired
	DeliveryManService deliverymanservice;

		@PostMapping
		public ResponseEntity<DeliveryMan> createDeliveryMan(@RequestBody DeliveryMan deliveryman) {
			DeliveryMan deli = deliverymanservice.createdeliverymanService(deliveryman);
			return new ResponseEntity<DeliveryMan>(deli, HttpStatus.CREATED);
		}

		@GetMapping
		public ResponseEntity<List<DeliveryMan>> getDeliveryMan() throws DeliveryManServiceNotFoundException {
			List<DeliveryMan>deliver = deliverymanservice.getdeliverymanService();
			return new ResponseEntity<List<DeliveryMan>>(deliver, HttpStatus.OK);

		}

		@GetMapping("/{id}")
		public ResponseEntity<DeliveryMan> getDeliveryManbyid(@PathVariable("id") int id) throws DeliveryManServiceNotFoundException {
			DeliveryMan man = deliverymanservice.getDeliveryManServicebyid(id);
			return new ResponseEntity<DeliveryMan>(man, HttpStatus.OK);
		}

		@PutMapping("/{id}")
		public ResponseEntity<DeliveryMan> updateDeliveryMan(@RequestBody DeliveryMan deliveryman, @PathVariable("id") int id)
				throws DeliveryManServiceNotFoundException {
			DeliveryMan deli = deliverymanservice.updateDeliveryManService(deliveryman, id);
			return new ResponseEntity<DeliveryMan>(deli, HttpStatus.CREATED);
		}

		@DeleteMapping("/{id}")
		public HttpStatus deleteDeliveryMan(@PathVariable("id") int id) throws DeliveryManServiceNotFoundException {
			deliverymanservice.deleteDeliveryManService(id);
			return HttpStatus.OK;
		} 

	}


