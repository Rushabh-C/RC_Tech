package com.E_comm.service;

import java.util.List;

import com.E_comm.domain.CartItem;
import com.E_comm.domain.Order;
import com.E_comm.domain.Product;
import com.E_comm.domain.ShoppingCart;
import com.E_comm.domain.User;

public interface CartItemService {

	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);

	CartItem updateCartItem(CartItem cartItem);

	CartItem addProductToCartItem(Product product, User user, int qty);

	CartItem findById(Long id);

	void removeCartItem(CartItem cartItem);

	CartItem save(CartItem cartItem);
	
	List<CartItem> findByOrder(Order order);
}
