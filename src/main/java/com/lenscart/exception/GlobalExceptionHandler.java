package com.lenscart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = IdNotFoundException.class)
	public ResponseEntity<Object> handleIdNotFoundException(IdNotFoundException exception) {
		return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = InvalidProductDataException.class)
	public ResponseEntity<Object> handleInvalidProductException(InvalidProductDataException exception) {
		return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.CONFLICT);
	}

	@ExceptionHandler(value = NoSuchProductFoundException.class)
	public ResponseEntity<Object> handleNoSuchProductFoundException(NoSuchProductFoundException exception) {
		return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

}
