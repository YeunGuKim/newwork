package com.web.common.exception;

public class LoginCheckException extends RuntimeException {

	private static final long serialVersionUID = 1111580162090445200L;
	
	public LoginCheckException(String msg) {
		super(msg);
	}
}
