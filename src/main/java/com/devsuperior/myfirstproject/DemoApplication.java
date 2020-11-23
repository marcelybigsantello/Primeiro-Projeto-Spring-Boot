package com.devsuperior.myfirstproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.myfirstproject.entities.Category;
import com.devsuperior.myfirstproject.repository.CategoryRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	
	//Injeção de dependência através do framework Spring Boot
	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category c1 = new Category(1, "Travels and trips");
		Category c2 = new Category(2, "Books");
		Category c3 = new Category(3, "House and decoration");
		
		categoryRepository.save(c1);
		categoryRepository.save(c2);
		categoryRepository.save(c3);		
	}

}
