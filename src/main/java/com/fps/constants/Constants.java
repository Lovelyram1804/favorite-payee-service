package com.fps.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {

	public static final String PAYEE_NAME_REGEX = "[^A-Za-z0-9'-]";
	
	public static final String IBAN_REGEX = "[^A-Za-z0-9]";
}
