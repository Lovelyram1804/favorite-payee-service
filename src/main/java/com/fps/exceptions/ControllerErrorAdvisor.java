package com.fps.exceptions;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fps.dto.ResponseMessage;

@ControllerAdvice
public class ControllerErrorAdvisor {

	@ExceptionHandler({ RuntimeException.class })
	public ResponseEntity<ResponseMessage> handleRunTimeException(RuntimeException e) {
		return error("EC-001", INTERNAL_SERVER_ERROR, e);
	}

	@ExceptionHandler({ NoDataFoundException.class })
	public ResponseEntity<ResponseMessage> handleNotFoundException(NoDataFoundException e) {
		return error("EC-002", NOT_FOUND, e);
	}
	
	@ExceptionHandler({ InvalidInputException.class })
	public ResponseEntity<ResponseMessage> handleInvalidRequestException(InvalidInputException e) {
		return error("EC-003", UNPROCESSABLE_ENTITY, e);
	}

	private static ResponseEntity<ResponseMessage> error(String errorCode, HttpStatus status, Exception e) {
		return ResponseEntity.status(status).body(
				ResponseMessage.builder().errorCode(errorCode).status(status.value()).message(e.getMessage()).build());
	}
}
