package com.E_comm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.E_comm.domain.UserShipping;
import com.E_comm.repository.UserShippingRepository;
import com.E_comm.service.UserShippingService;

@Service
public class UserShippingServiceImpl implements UserShippingService {

	@Autowired
	private UserShippingRepository userShippingRepository;

	public UserShipping findById(Long id) {
		return userShippingRepository.findById(id).get();
	}

	public void removeById(Long id) {
		userShippingRepository.deleteById(id);
	}

}
