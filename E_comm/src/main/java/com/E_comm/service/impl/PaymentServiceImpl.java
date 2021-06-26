package com.E_comm.service.impl;

import org.springframework.stereotype.Service;

import com.E_comm.domain.Payment;
import com.E_comm.domain.UserPayment;
import com.E_comm.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	public Payment setByUserPayment(UserPayment userPayment, Payment payment) {
		payment.setType(userPayment.getType());
		payment.setHolderName(userPayment.getHolderName());
		payment.setCardNumber(userPayment.getCardNumber());
		payment.setExpiryMonth(userPayment.getExpiryMonth());
		payment.setExpiryYear(userPayment.getExpiryYear());
		payment.setCvv(userPayment.getCvv());
		
		return payment;
	}

}
