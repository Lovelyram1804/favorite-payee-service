package com.fps.service;

import com.fps.dto.PayeeDto;
import com.fps.entities.Customer;
import com.fps.entities.Payee;
import com.fps.repos.PayeeRepository;
import com.fps.services.PayeeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.context.annotation.Import;


import static org.junit.jupiter.api.Assertions.assertNotNull;

@Import(Mockito.class)
public class PayeeServiceTest {

    @InjectMocks
    private PayeeService payeeService;

    @Mock
    private PayeeRepository repository;

   // @Test
    @DisplayName("check thepayee updated with correct data set")
    public void shouldUpdatePayee(){

        //given
        Payee payeeEntity = new Payee();
        payeeEntity.setPayeeName("lovely");
        Customer customerEntity = new Customer();
        customerEntity.setCustName("abc");
        payeeEntity.setCustomer(customerEntity);
        payeeEntity.setIban("Test");

        //when
        payeeEntity = payeeService.update(payeeEntity);

        //then
        assertNotNull(payeeEntity);
        //check the value updated correctl
    }

   // @Test
    @DisplayName("check thepayee updated with correct data set")
    public void shouldUpdatePayeeNotValidData(){

        //given
        Payee payeeEntity = new Payee();
        payeeEntity.setPayeeName("lovely");
        Customer customerEntity = new Customer();
        customerEntity.setCustName("abc+ggggggggg_");
        payeeEntity.setCustomer(customerEntity);
        payeeEntity.setIban("Test");

        //when
        payeeEntity = payeeService.update(payeeEntity);

        //then
        assertNotNull(payeeEntity);
        //check the value updated correctl
    }
}
