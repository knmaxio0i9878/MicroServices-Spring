package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.ProductEntity;
import com.repository.ProductRepository;


@RestController
public class ProductController {

	@Autowired
	ProductRepository prepo;
	
	@PostMapping("/products")
	public ProductEntity newProduct(@RequestBody ProductEntity pentity) {
		System.out.println(pentity.getProductName());
		System.out.println(pentity.getProductPrice());
		prepo.save(pentity);
		return pentity;
	}
}
