package com.fps.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PayeeUtils {

	public static String extractBankCode(String iban) {		
		return iban.substring(4, 8);	
	}
	
	public static boolean validateStringWithRegex(String input, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(input);
		return match.find();
	} 

}
