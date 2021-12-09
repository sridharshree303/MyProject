package com.cg.dms.exception;

public class CompanyAlreadyExistsException extends RuntimeException{

	//if company already exists, handles CompanyAlreadyExistsException
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8535133578980601110L;
	
	public CompanyAlreadyExistsException() {
		super();
	}

	public CompanyAlreadyExistsException(String s) {
		super(s);
	}
}
