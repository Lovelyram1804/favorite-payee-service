package com.fps.entities;

import java.math.BigInteger;
import java.time.Instant;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PAYEE")
public class Payee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "PAYEE_ID")
	private BigInteger payeeId;	
	
	@Column(name = "PAYEE_NAME", nullable = false)	
	private String payeeName;
	
	@Column(name = "IBAN", nullable = false, unique = true)	
	private String iban;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "CUST_ID", insertable = true, updatable = true)
	private Customer customer;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "BANK_CODE", insertable = true, updatable = true)
	private Bank bank;
	
	@Column(name = "CREATED_DT", nullable = false)	
	private Instant createdDate;
	
	@Column(name = "LAST_MODIFIED_DT", nullable = false)	
	private Instant lastModifiedDate;
	
}
