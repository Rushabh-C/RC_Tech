package com.E_comm.service;

import com.E_comm.domain.UserShipping;

public interface UserShippingService {

	UserShipping findById(Long id);
	
	void removeById(Long id);
}
