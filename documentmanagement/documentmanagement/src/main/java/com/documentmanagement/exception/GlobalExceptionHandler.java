package com.documentmanagement.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	// error handle for @Valid
		@Override
		protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
				HttpHeaders headers, HttpStatus status, WebRequest request) {

			Map<String, Object> body = new LinkedHashMap<>();
			body.put("timestamp", new Date());
			body.put("status", status.value());

			// Get all errors
			List<String> errors = ex.getBindingResult().getFieldErrors().stream()
					.map(x -> x.getField() + " : " + x.getDefaultMessage()).collect(Collectors.toList());
			body.put("errors", errors);
			return new ResponseEntity<>(body, headers, status);
		}
		  @ExceptionHandler(Exception.class)
		  public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
			  Map<String, Object> body = new LinkedHashMap<>();
				body.put("timestamp", new Date());
				body.put("status",HttpStatus.INTERNAL_SERVER_ERROR);
		    List<String> details = new ArrayList<>();
		    details.add(ex.getMessage());
		    body.put("errors", details);
		    return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
		  }
		  @ExceptionHandler(IOException.class)
		  public final ResponseEntity<Object> handleAllException1(IOException ex, WebRequest request) {
			  Map<String, Object> body = new LinkedHashMap<>();
				body.put("timestamp", new Date());
				body.put("status",HttpStatus.INTERNAL_SERVER_ERROR);
		    List<String> details = new ArrayList<>();
		    details.add(ex.getMessage());
		    body.put("errors", details);
		    return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
		  }

		 @ExceptionHandler(CustomException.class)
		  public final ResponseEntity<Object> handleAllCustomException(Exception ex, WebRequest request) {
			  Map<String, Object> body = new LinkedHashMap<>();
				body.put("timestamp", new Date());
				body.put("status",HttpStatus.BAD_REQUEST);
		    List<String> details = new ArrayList<>();
		    details.add(ex.getMessage());
		    body.put("errors", details);
		    return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
		  }
	 
		 
		 
}

