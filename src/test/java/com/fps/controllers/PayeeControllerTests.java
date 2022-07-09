package com.fps.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.math.BigInteger;

import com.fps.controllers.PayeeController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fps.dto.PayeeDto;
import com.fps.services.PayeeService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PayeeControllerTests {

	@Autowired
	private WebApplicationContext context;
	
	@InjectMocks
	PayeeController controller;
	
	@Mock
	PayeeService payeeService;
	
	/*@Test
	void testUpdatePayeeSuccess() throws Exception {

		PayeeDto dto = PayeeDto.builder().customerId(BigInteger.ONE).iban("ABCD1111").payeeName("Akhil123").build();

		MockMvcBuilders.webAppContextSetup(context).build()
				.perform(post("/payee-service/api/v1/payee"))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}*/
	
}
