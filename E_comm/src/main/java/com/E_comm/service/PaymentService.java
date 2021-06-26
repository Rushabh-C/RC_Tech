package com.E_comm.service;

import com.E_comm.domain.Payment;
import com.E_comm.domain.UserPayment;

public interface PaymentService {

	Payment setByUserPayment(UserPayment userPayment, Payment payment);
}
