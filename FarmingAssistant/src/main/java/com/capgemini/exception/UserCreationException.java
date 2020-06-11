package com.capgemini.exception;


@SuppressWarnings("serial")
public class UserCreationException extends RuntimeException{
	
	public UserCreationException(String errMsg) {
		super(errMsg);
	}
	
	public UserCreationException() {
		super();
	}


}
