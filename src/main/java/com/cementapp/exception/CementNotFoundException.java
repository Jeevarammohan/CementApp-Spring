package com.cementapp.exception;

public class CementNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CementNotFoundException() {
		super();
	}

	public CementNotFoundException(String message) {
		super(message);
	}

}
