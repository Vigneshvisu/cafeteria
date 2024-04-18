package com.example.cafeteria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.cafeteria.Exception.CategoryNotFoundException;
import com.example.cafeteria.Exception.HistoryNotFoundException;
import com.example.cafeteria.Exception.UserNotFoundException;
import com.example.cafeteria.model.Category;
import com.example.cafeteria.model.History;
import com.example.cafeteria.repository.HistoryRepository;

public class Historyservice {
	private final HistoryRepository historyrepository ;
	@Autowired
	public Historyservice(HistoryRepository historyrepository) {
		this.historyrepository=historyrepository;
	}

	
//	public List<History>getHistory(int id) throws UserNotFoundException{
//		Optional<History> history =historyrepository.findById(id);
//		if(history.isPresent()) {
//			History his=history.get();
//			return his(List<History>his);
//		}else {
//			throw new UserNotFoundException("Given data is not found");
//		}
//
//	}


	public List<History> gethistory() {
		List<History> his=historyrepository.findAll();
		return his;
	}


	public History getHistorybyid(int id) throws HistoryNotFoundException {
		Optional<History> history=historyrepository.findById(id);
		if(history.isPresent()) {
			History his=history.get();
			return his;
		}
		else {
			throw new HistoryNotFoundException("given data is not found");
		}
	}

}
