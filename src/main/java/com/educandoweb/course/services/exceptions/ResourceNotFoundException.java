package com.educandoweb.course.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{				// RuntimeException => Exceção que o compilador não te obriga a tratar

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException (Object id) {
		super("Resource Not Found. Id " + id);
	}

}
