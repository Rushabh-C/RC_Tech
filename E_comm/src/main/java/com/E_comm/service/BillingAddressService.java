package com.E_comm.service;

import com.E_comm.domain.BillingAddress;
import com.E_comm.domain.UserBilling;

public interface BillingAddressService {

	BillingAddress setByUserBilling(UserBilling userBilling, BillingAddress billingAddress);
}
