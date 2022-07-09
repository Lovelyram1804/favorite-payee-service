package com.fps.utils;

import static com.fps.constants.Constants.IBAN_REGEX;
import static com.fps.constants.Constants.PAYEE_NAME_REGEX;
import static com.fps.utils.PayeeUtils.validateStringWithRegex;

import java.math.BigInteger;
import java.util.Objects;

import org.springframework.util.StringUtils;

import com.fps.dto.PayeeDto;
import com.fps.exceptions.InvalidInputException;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AddPayeeRequestValidator {
	
	public static void validate(PayeeDto payeeDto) {
		validateCustomerId(payeeDto.getCustomerId());
		validateIban(payeeDto.getIban());
		validatePayeeName(payeeDto.getPayeeName());
	}

	private static void validatePayeeName(String payeeName) {
		if(StringUtils.isEmpty(payeeName)) {
			throw new InvalidInputException("Payee name is a mandatory field");
		}
		
		if(validateStringWithRegex(payeeName, PAYEE_NAME_REGEX)){
			throw new InvalidInputException("Only Letters/numbers plus ‘ and - are allowed in payee name");
		}
	}
	
	private static void validateIban(String iban) {
		if(StringUtils.isEmpty(iban)) {
			throw new InvalidInputException("IBAN is a mandatory field");
		}
		
		if(validateStringWithRegex(iban, IBAN_REGEX)){
			throw new InvalidInputException("Only letters and numbers are allowed in IBAN");
		}
		
		if(iban.length() > 20) {
			throw new InvalidInputException("IBAN length can not be more than 20");
		}
		
		if(iban.length() < 8) {
			throw new InvalidInputException("Invalid value of IBAN, unable to retrieve bank code");
		}
	}	
	
	private static void validateCustomerId(BigInteger customerId) {
		if(Objects.isNull(customerId)) {
			throw new InvalidInputException("Customer id is a mandatory field");
		}		
	}

}
