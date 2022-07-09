package com.fps.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fps.entities.Bank;

public interface BankRepository extends JpaRepository<Bank, String>{
	
}
