package com.fps.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "CUST_ID")
	private BigInteger custId;	
	
	@Column(name = "CUST_NAME", nullable = false)	
	private String custName;
	
	@Column(name = "CREATED_DATE", nullable = false)	
	private Instant createdDate;

}
