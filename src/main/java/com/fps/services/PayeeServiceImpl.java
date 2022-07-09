package com.fps.services;

import java.math.BigInteger;
import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fps.dto.PayeeDto;
import com.fps.entities.Bank;
import com.fps.entities.Customer;
import com.fps.entities.Payee;
import com.fps.exceptions.InvalidInputException;
import com.fps.exceptions.NoDataFoundException;
import com.fps.repos.BankRepository;
import com.fps.repos.CustomerRepository;
import com.fps.repos.PayeeRepository;
import com.fps.utils.AddPayeeRequestValidator;
import com.fps.utils.PayeeUtils;

@Service
public class PayeeServiceImpl implements PayeeService{
	
	@Autowired
	private PayeeRepository payeeRepository;
	
	@Autowired
	private BankRepository bankRepository;

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Payee addPayee(PayeeDto payeeDto) {
		
		// Validate Payee Request
		AddPayeeRequestValidator.validate(payeeDto);
		
		// Fetch Customer by Customer Id
		Optional<Customer> customer = customerRepository.findById(payeeDto.getCustomerId());
		if(!customer.isPresent()) {
			throw new NoDataFoundException("Customer with id: "+ payeeDto.getCustomerId() +" does not exists");		
		}
		
		// Fetch Bank by Bank Code
		String bankCode = PayeeUtils.extractBankCode(payeeDto.getIban());
		Optional<Bank> bank = bankRepository.findById(bankCode);
		if(!bank.isPresent()) {
			throw new NoDataFoundException("Bank with code: "+ bankCode +" does not exists");		
		}
		
		// Validate Max Favorite Account Exceeded
		int payeesForCustCount = payeeRepository.countPayeeByCustomerId(payeeDto.getCustomerId());
		if(payeesForCustCount >= 20) {
			throw new InvalidInputException("Max 20 favourite payees allowed per customer");
		}		
		
		// Add Payee
		return payeeRepository.save(Payee.builder()
				.bank(bank.get())
				.customer(customer.get())
				.iban(payeeDto.getIban())
				.payeeName(payeeDto.getPayeeName())
				.createdDate(Instant.now())
				.lastModifiedDate(Instant.now()).build());
		
	}

	@Override
	public Optional<Payee> findById(BigInteger payeeId) {
		return payeeRepository.findById(payeeId);
	}

	@Override
	public Payee update(Payee updatedpayee) {
		validatePayee(updatedpayee);
		//once all validation pass add date change
		updatedpayee.setLastModifiedDate(Instant.now());
		return payeeRepository.save(updatedpayee);
	}

	public void validatePayee(Payee payee){

		PayeeDto payeeDto = new PayeeDto();
		payeeDto.setPayeeName(payee.getPayeeName());
		payeeDto.setIban(payee.getIban());
		payeeDto.setPayeeName(payee.getPayeeName());
		payeeDto.setCustomerId(payee.getCustomer().getCustId());
		// Validate Payee Request
		AddPayeeRequestValidator.validate(payeeDto);

		// Fetch Customer by Customer Id
		Optional<Customer> customer = customerRepository.findById(payeeDto.getCustomerId());
		if(!customer.isPresent()) {
			throw new NoDataFoundException("Customer with id: "+ payeeDto.getCustomerId() +" does not exists");
		}

		// Fetch Bank by Bank Code
		String bankCode = PayeeUtils.extractBankCode(payeeDto.getIban());
		Optional<Bank> bank = bankRepository.findById(bankCode);
		if(!bank.isPresent()) {
			throw new NoDataFoundException("Bank with code: "+ bankCode +" does not exists");
		}

		// Validate Max Favorite Account Exceeded
		int payeesForCustCount = payeeRepository.countPayeeByCustomerId(payeeDto.getCustomerId());
		if(payeesForCustCount >= 20) {
			throw new InvalidInputException("Max 20 favourite payees allowed per customer");
		}

	}

}
