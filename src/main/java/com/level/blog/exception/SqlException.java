package com.level.blog.exception;

public class SqlException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String email;

	public SqlException(String email) {
		
		super(String.format("%s ", email));
		this.email = email;
	}

	public SqlException() {
		super();
		
	}

	
	

}
