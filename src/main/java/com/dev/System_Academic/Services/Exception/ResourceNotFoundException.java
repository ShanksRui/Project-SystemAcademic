package com.dev.System_Academic.Services.Exception;

public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Long id) {
		super("resource not Found! "+ id);
	}

}
