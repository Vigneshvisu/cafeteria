package com.example.cafeteria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.cafeteria.Exception.HistoryNotFoundException;
import com.example.cafeteria.model.History;
import com.example.cafeteria.service.Historyservice;


public class HistoryController {
	@Autowired
	Historyservice historyservice;
	@GetMapping
	public ResponseEntity<List<History>> getHistory() throws HistoryNotFoundException {
		List<History> history1 = historyservice.gethistory();
		return new ResponseEntity<List<History>>(history1, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<History> getHistorybyid(@PathVariable("id") int id) throws HistoryNotFoundException {
		History history1 = historyservice.getHistorybyid(id);
		return new ResponseEntity<History>(history1, HttpStatus.OK);
	}

}
