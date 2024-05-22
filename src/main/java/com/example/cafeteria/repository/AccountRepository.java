package com.example.cafeteria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cafeteria.model.Account;
import com.example.cafeteria.model.Payment;
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>  {

//	Account save(Account account);

//	Account findByaccounttype(Account string);

    Account findByAccountType(String accountType);
//	Account findByAccount(Account accountType);

//	Account findByaccount(String paymentmode);
	

}
