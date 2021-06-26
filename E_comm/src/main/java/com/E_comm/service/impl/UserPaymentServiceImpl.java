package com.E_comm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.E_comm.domain.UserPayment;
import com.E_comm.repository.UserPaymentRepository;
import com.E_comm.service.UserPaymentService;

@Service
public class UserPaymentServiceImpl implements UserPaymentService {

	@Autowired
	private UserPaymentRepository userPaymentRepository;

	public UserPayment findById(Long id) {
		return userPaymentRepository.findById(id).get();
	}

	public void removeById(Long id) {
		userPaymentRepository.deleteById(id);
	}
}
