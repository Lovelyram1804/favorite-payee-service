package com.fps.repos;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fps.entities.Payee;

public interface PayeeRepository extends JpaRepository<Payee, BigInteger>{
	
	@Query(nativeQuery = true, value= "select count(1) from PAYEE p where CUST_ID = :custId")
	int countPayeeByCustomerId(BigInteger custId);
	
}
