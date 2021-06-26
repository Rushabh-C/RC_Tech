package com.E_comm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.E_comm.domain.Product;
import com.E_comm.repository.ProductRepository;
import com.E_comm.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAll() {
		List<Product> productList = (List<Product>) productRepository.findAll();
		List<Product> activeProductList = new ArrayList<>();

		for (Product product : productList) {
			if (product.isActive()) {
				activeProductList.add(product);
			}
		}
		return activeProductList;
	}

	public Product findById(Long id) {
		return productRepository.findById(id).get();
	}

	public List<Product> findByCategory(String category) {
		List<Product> productList = productRepository.findByCategory(category);

		List<Product> activeProductList = new ArrayList<>();

		for (Product product : productList) {
			if (product.isActive()) {
				activeProductList.add(product);
			}
		}

		return activeProductList;
	}

	public List<Product> blurrySearch(String title) {
		List<Product> productList = productRepository.findByTitleContaining(title);

		List<Product> activeProductList = new ArrayList<>();

		for (Product product : productList) {
			if (product.isActive()) {
				activeProductList.add(product);
			}
		}

		return activeProductList;
	}
}
