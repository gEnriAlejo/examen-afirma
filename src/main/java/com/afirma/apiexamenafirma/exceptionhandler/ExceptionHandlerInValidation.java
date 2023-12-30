package com.afirma.apiexamenafirma.exceptionhandler;

import java.time.format.DateTimeParseException;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerInValidation {

	  @ExceptionHandler(ConstraintViolationException.class)
	  @ResponseStatus(HttpStatus.BAD_REQUEST)
	  @ResponseBody
	  ValidationErrorResponse onConstraintValidationException(ConstraintViolationException e) {
		  
	    ValidationErrorResponse error = new ValidationErrorResponse();
	    for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
	      error.getErrores().add(
	        new ErrorAtributo(violation.getPropertyPath().toString(), violation.getMessage()));
	    }
	    return error;
	  }

	  @ExceptionHandler(MethodArgumentNotValidException.class)
	  @ResponseStatus(HttpStatus.BAD_REQUEST)
	  @ResponseBody
	  ValidationErrorResponse onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		  
		  log.info("*********** Por aqui paso *********** ");
		  
	    ValidationErrorResponse error = new ValidationErrorResponse();
	    for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
	      error.getErrores().add(
	        new ErrorAtributo(fieldError.getField(), fieldError.getDefaultMessage()));
	    }
	    return error;
	  }
	  
	  @ExceptionHandler(DateTimeParseException.class)
	  @ResponseStatus(HttpStatus.BAD_REQUEST)
	  @ResponseBody
	  ValidationErrorResponse onMethodArgumentNotValidException(DateTimeParseException e) {
		  
		  log.info("*********** Fecha con formato incorrecto *********** ");
		  
	    ValidationErrorResponse error = new ValidationErrorResponse();

	      error.getErrores().add(
	        new ErrorAtributo("Fecha", "La fecha '" + e.getParsedString() + "' es incorrecta, favor de verificar"));
		  
	    return error;
	  }
}
