package com.fps.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//handling global error message
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ResponseMessage {

	String message;
	
	Integer status;
	
	@JsonInclude(Include.NON_EMPTY)
	String errorCode;
}
