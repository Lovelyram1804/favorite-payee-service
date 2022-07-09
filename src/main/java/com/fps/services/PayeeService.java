package com.fps.services;

import com.fps.dto.PayeeDto;
import com.fps.entities.Payee;

import java.math.BigInteger;
import java.util.Optional;

public interface PayeeService {
	
	public Payee addPayee(PayeeDto payeeDto);

	public Optional<Payee> findById(BigInteger payeeId);

	public Payee update(Payee updatedpayee);
}
