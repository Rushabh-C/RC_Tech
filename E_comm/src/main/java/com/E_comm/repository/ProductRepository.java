package com.E_comm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.E_comm.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findByCategory(String category);

	List<Product> findByTitleContaining(String title);
}
