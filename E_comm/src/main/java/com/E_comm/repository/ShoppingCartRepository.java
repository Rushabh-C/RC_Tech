package com.E_comm.repository;


import org.springframework.data.repository.CrudRepository;

import com.E_comm.domain.ShoppingCart;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {

}
