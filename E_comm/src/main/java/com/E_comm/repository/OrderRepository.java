package com.E_comm.repository;

import org.springframework.data.repository.CrudRepository;

import com.E_comm.domain.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
