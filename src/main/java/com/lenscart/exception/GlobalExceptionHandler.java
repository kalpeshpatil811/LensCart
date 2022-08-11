package com.lenscart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = SunGlassIdNotFoundException.class)
	public ResponseEntity<Object> handleSunGlassIdNotFoundException(SunGlassIdNotFoundException exception) {
		return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = InvalidSunGlassDataException.class)
	public ResponseEntity<Object> handleInvalidSunGlassDataException(InvalidSunGlassDataException exception) {
		return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.CONFLICT);
	}

	@ExceptionHandler(value = NoSuchSunGlassFoundException.class)
	public ResponseEntity<Object> handleNoSuchSunGlassFoundException(NoSuchSunGlassFoundException exception) {
		return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = GlassIdNotFoundException.class)
	public ResponseEntity<Object> handleGlassIdNotFoundException(GlassIdNotFoundException exception) {
		return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = InvalidGlassDataException.class)
	public ResponseEntity<Object> handleInvalidGlassDataException(InvalidGlassDataException exception) {
		return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.CONFLICT);
	}

	@ExceptionHandler(value = NoSuchGlassFoundException.class)
	public ResponseEntity<Object> handleNoSuchGlassFoundException(NoSuchGlassFoundException exception) {
		return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = LensIdNotFoundException.class)
	public ResponseEntity<Object> handleLensIdNotFoundException(LensIdNotFoundException exception) {
		return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = InvalidLensDataException.class)
	public ResponseEntity<Object> handleInvalidLensDataException(InvalidLensDataException exception) {
		return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.CONFLICT);
	}

	@ExceptionHandler(value = NoSuchLensFoundException.class)
	public ResponseEntity<Object> handleNoSuchLensFoundException(NoSuchLensFoundException exception) {
		return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = FrameIdNotFoundException.class)
	public ResponseEntity<Object> handleFrameIdNotFoundException(FrameIdNotFoundException exception) {
		return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = InvalidFrameDataException.class)
	public ResponseEntity<Object> handleInvalidFrameDataException(InvalidFrameDataException exception) {
		return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.CONFLICT);
	}

	@ExceptionHandler(value = NoSuchFrameFoundException.class)
	public ResponseEntity<Object> handleNoSuchFrameFoundException(NoSuchFrameFoundException exception) {
		return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = WrongPasswordException.class)
	public ResponseEntity<Object> handleWrongPasswordException(WrongPasswordException exception) {
		return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = CustomerNotFoundException.class)
	public ResponseEntity<Object> handleCustomerNotFoundException(CustomerNotFoundException exception) {
		return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.CONFLICT);
	}

	@ExceptionHandler(value = WrongUsernameAndPassword.class)
	public ResponseEntity<Object> handleWrongUsernameAndPassword(WrongUsernameAndPassword exception) {
		return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

}
