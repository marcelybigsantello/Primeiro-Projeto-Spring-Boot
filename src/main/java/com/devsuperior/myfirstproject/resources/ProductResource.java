package com.devsuperior.myfirstproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.myfirstproject.entities.Product;
import com.devsuperior.myfirstproject.repository.ProductRepository;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	//Injeção de dependência através do framework Spring boot
	@Autowired
	private ProductRepository productRepository; 
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> products = productRepository.findAll();
		
		return ResponseEntity.ok().body(products);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Integer id){
		Product prod = productRepository.findById(id);
		
		return ResponseEntity.ok().body(prod);
	}
	
	
	
}
