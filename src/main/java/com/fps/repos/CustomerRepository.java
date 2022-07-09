package com.fps.repos;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fps.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, BigInteger>{

}
