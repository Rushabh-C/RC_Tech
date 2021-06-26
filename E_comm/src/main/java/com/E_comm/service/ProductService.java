package com.E_comm.service;

import java.util.List;

import com.E_comm.domain.Product;

public interface ProductService {

	List<Product> findAll();

	Product findById(Long id);

	List<Product> findByCategory(String category);

	List<Product> blurrySearch(String title);

}
