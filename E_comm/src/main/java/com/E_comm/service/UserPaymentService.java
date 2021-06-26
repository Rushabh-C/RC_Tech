package com.E_comm.service;

import com.E_comm.domain.UserPayment;

public interface UserPaymentService {

	UserPayment findById(Long id);
	
	void removeById(Long id);

}
