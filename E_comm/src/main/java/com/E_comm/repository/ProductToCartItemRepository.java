package com.E_comm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.E_comm.domain.CartItem;
import com.E_comm.domain.ProductToCartItem;

@Transactional
public interface ProductToCartItemRepository extends CrudRepository<ProductToCartItem, Long> {

	void deleteByCartItem(CartItem cartItem);
}
