package com.cg.hsm.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends Exception{
	
	public RecordNotFoundException(String message) {
		super(message);
	}

}