package com.E_comm.service;

import com.E_comm.domain.BillingAddress;
import com.E_comm.domain.Order;
import com.E_comm.domain.Payment;
import com.E_comm.domain.ShippingAddress;
import com.E_comm.domain.ShoppingCart;
import com.E_comm.domain.User;

public interface OrderService {

	Order createOrder(ShoppingCart shoppingCart, ShippingAddress shippingAddress, BillingAddress billingAddress,
			Payment payment, String shippingMethod, User user);

	Order findById(Long id);
}
