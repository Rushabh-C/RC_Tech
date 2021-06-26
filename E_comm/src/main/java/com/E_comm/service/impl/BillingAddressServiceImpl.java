package com.E_comm.service.impl;

import org.springframework.stereotype.Service;

import com.E_comm.domain.BillingAddress;
import com.E_comm.domain.UserBilling;
import com.E_comm.service.BillingAddressService;

@Service
public class BillingAddressServiceImpl implements BillingAddressService {
	
	public BillingAddress setByUserBilling(UserBilling userBilling, BillingAddress billingAddress) {
		billingAddress.setBillingAddressName(userBilling.getUserBillingName());
		billingAddress.setBillingAddressStreet1(userBilling.getUserBillingStreet1());
		billingAddress.setBillingAddressStreet2(userBilling.getUserBillingStreet2());
		billingAddress.setBillingAddressCity(userBilling.getUserBillingCity());
		billingAddress.setBillingAddressState(userBilling.getUserBillingState());
		billingAddress.setBillingAddressCountry(userBilling.getUserBillingCountry());
		billingAddress.setBillingAddressPincode(userBilling.getUserBillingPincode());
		
		return billingAddress;
	}

}
