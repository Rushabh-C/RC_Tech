package com.E_comm.service;

import com.E_comm.domain.ShippingAddress;
import com.E_comm.domain.UserShipping;

public interface ShippingAddressService {

	ShippingAddress setByUserShipping(UserShipping userShipping, ShippingAddress shippingAddress);

}
