package com.example.cafeteria.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.NOT_FOUND)

public class AddressNotFoundException extends Exception {

	public AddressNotFoundException(String message) {
		super(message);
	}
	

}
