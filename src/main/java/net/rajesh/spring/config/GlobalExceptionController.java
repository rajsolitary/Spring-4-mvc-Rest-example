package net.rajesh.spring.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Rajesh Kumar<rajsolitary@gmail.com>
 *
 */

@RestControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(CustomGenericException.class)
	public ResponseEntity<?> handleCustomException(CustomGenericException ex) {
		return new ResponseEntity<>("Exceptions Occures " + ex.getErrCode() + ex.getErrMsg(),
				HttpStatus.METHOD_FAILURE);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleAllException(Exception ex) {
		return new ResponseEntity<>("Exceptions Occures " + ex.getMessage() + ex.getCause(), HttpStatus.METHOD_FAILURE);
	}
}
