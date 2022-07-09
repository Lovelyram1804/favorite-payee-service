package com.fps.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fps.dto.PayeeDto;
import com.fps.dto.ResponseMessage;
import com.fps.entities.Payee;
import com.fps.services.PayeeService;

import io.swagger.annotations.ApiOperation;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Calendar;
@RestController
@RequestMapping("/payee-service/api/v1")
public class PayeeController {

	@Autowired
	private PayeeService payeeService;

	@PostMapping("/payee")
	@ApiOperation(value = "Add new payee")
	public ResponseEntity<ResponseMessage> addPayee(PayeeDto payeeDto) {
		Payee payee = payeeService.addPayee(payeeDto);

		return new ResponseEntity<>(ResponseMessage.builder()
				.status(HttpStatus.CREATED.value())
				.message("Payee Added Successfully with Id: " + payee.getPayeeId()).build(), HttpStatus.CREATED);

	}

	@PutMapping("/payee/{payeeId}")
	@ApiOperation(value = "update payee")
	public ResponseEntity updateFavoriteAccount(@PathVariable(value = "id") BigInteger payeeId,
										 @RequestBody PayeeDto payeeRequest) throws Exception {
		Payee updatedpayee = payeeService.findById(payeeId)
				.orElseThrow(() -> new Exception("Payee not found for this id :: " + payeeId));
         //populated
		updatedpayee.setPayeeName(payeeRequest.getPayeeName());
		updatedpayee.getCustomer().setCustId(payeeRequest.getCustomerId());
		updatedpayee.setIban(payeeRequest.getIban());

		return ResponseEntity.ok(payeeService.update(updatedpayee));
	}

}
