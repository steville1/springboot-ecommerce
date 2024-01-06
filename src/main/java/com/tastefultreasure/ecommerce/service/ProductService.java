package com.tastefultreasure.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tastefultreasure.ecommerce.dao.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

	public List<ProductProjection> getAllProducts() {
		return productRepository.findAllProjected();
	}

}
