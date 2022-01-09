package com.selenium.express.ctl;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ExceptionHandling extends RuntimeException{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	public ExceptionHandling() {
		
	}


	public ExceptionHandling(String message) {
		super(message);
		
	}
	
	
}
