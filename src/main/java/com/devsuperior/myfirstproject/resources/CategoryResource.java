package com.devsuperior.myfirstproject.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.myfirstproject.entities.Category;
import com.devsuperior.myfirstproject.repository.CategoryRepository;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	//Injeção de dependência através do framework Spring boot
	@Autowired
	private CategoryRepository categoryRepository; 
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> categories = categoryRepository.findAll();
		
		return ResponseEntity.ok().body(categories);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Integer id){
		Category category = categoryRepository.findById(id);
		
		return ResponseEntity.ok().body(category);
	}
	
	
	
}
