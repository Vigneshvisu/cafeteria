package com.example.cafeteria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cafeteria.model.Account;
import com.example.cafeteria.model.Payment;

public interface AccountRepository extends JpaRepository<Account, Integer>  {

//	Account save(Account account);

	Account findByaccounttype(String accounttype);

}
