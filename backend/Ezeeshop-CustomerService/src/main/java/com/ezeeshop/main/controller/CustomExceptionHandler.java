package com.ezeeshop.main.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ezeeshop.main.entity.ErrorEntity;

@ControllerAdvice
public class CustomExceptionHandler {

        @ExceptionHandler
		public ResponseEntity<ErrorEntity> handleException(CustomerExceptionClass exc)
		{
			ErrorEntity error = new ErrorEntity(HttpStatus.NOT_FOUND.value(),exc.getMessage(), System.currentTimeMillis());
			return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		}
		
       
        
		// Add another exception handler ... to catch any exception (catch all)

		/*
		 * @ExceptionHandler public ResponseEntity<ErrorEntity>
		 * handleException(Exception exc) { ErrorEntity error = new
		 * ErrorEntity(HttpStatus.BAD_REQUEST.value(),exc.getMessage(),
		 * System.currentTimeMillis()); return new ResponseEntity<>(error,
		 * HttpStatus.BAD_REQUEST); }
		 */

}
