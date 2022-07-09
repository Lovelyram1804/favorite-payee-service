package com.fps.dto;

import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PayeeDto {

	private BigInteger customerId;

	private String payeeName;

	private String iban;

}
