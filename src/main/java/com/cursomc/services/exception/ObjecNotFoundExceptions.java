package com.cursomc.services.exception;

public class ObjecNotFoundExceptions extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ObjecNotFoundExceptions(String msg) {
		super(msg);
	}
	
	public ObjecNotFoundExceptions(String msg, Throwable cause) {
		super (msg, cause);
	}

}
