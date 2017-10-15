package com.spring.web.controller;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/*
 * @ExceptionHandler :  is local to a controller 
 * only exceptions from this controller is routed to its @ExceptionHandler
 * it does not work for another controllers,it works only for specific controllers
 * 
 * @ControllerAdvice : used for global error handling.
 * It also has full control over the body of the response and the status code.
 * it applies to all the defined controller.
 */
@ControllerAdvice
public class ErrorHandler {

	@ExceptionHandler(DataAccessException.class)
	public String DatabaseException(DataAccessException ex) {
		return "Error";
	}
}
