package com.cg.dms.exception;

public class InvalidTransactionException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7993847209506539588L;

	public InvalidTransactionException() {
		super();
	}
	public InvalidTransactionException(String s) {
		super(s);
	}
}
