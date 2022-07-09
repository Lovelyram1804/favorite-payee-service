package com.fps.exceptions;

public class NoDataFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoDataFoundException(String string) {
		super(string);
	}

}
