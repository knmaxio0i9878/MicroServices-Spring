package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.ProductEntity;
import com.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



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
	
	@GetMapping("/getproduct")
	public List<ProductEntity> getProducts() {
		List<ProductEntity> products = prepo.findAll();
		return products;
		
	}
	
	@GetMapping("/getproductbyid/{productId}")
	public ProductEntity getProducts(@PathVariable("productId") Integer productId) {
		Optional<ProductEntity> op = prepo.findById(productId);
		if(op.isEmpty()) {
			return null;
		}
		else {
			ProductEntity pentity = op.get();
			return pentity;
		}
		
	}
	
	
}
