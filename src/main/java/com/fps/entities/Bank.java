package com.fps.entities;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "BANK")
public class Bank {

	@Id
	@Column(name = "BANK_CODE")
	private String bankCode;	
	
	@Column(name = "BANK_NAME", nullable = false)	
	private String bankName;
	
	@Column(name = "CREATED_DATE", nullable = false)	
	private Instant createdDate;

}
