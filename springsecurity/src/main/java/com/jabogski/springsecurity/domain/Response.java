package com.jabogski.springsecurity.domain;

import java.io.Serializable;

public class Response implements Serializable {
	
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5473489970694128301L;
	private String message;
	
	public Response(String message) {
		super();
		this.message = message;
	}

	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
