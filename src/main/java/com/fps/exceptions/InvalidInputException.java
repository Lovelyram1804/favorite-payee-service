package com.fps.exceptions;

public class InvalidInputException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidInputException(String string) {
		super(string);
	}

}
