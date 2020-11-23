package com.devsuperior.myfirstproject;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.myfirstproject.entities.Category;
import com.devsuperior.myfirstproject.entities.Product;
import com.devsuperior.myfirstproject.repository.CategoryRepository;
import com.devsuperior.myfirstproject.repository.ProductRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	
	//Injeção de dependência através do framework Spring Boot
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category c1 = new Category(null, "Fashion");
		Category c2 = new Category(null, "Books");
		Category c3 = new Category(null, "House and decoration");
		
		Product p1 = new Product(null, "Scarpin nude bico fino", 150.00f, c1);
		Product p2 = new Product(null, "Escrivaninha alta branca", 400.00f, c3);
		Product p3 = new Product(null, "Querido John, Nicholas Sparks", 25.00f, c2);
		Product p4 = new Product(null, "Uma longa jornada, Nicholas Sparks", 21.90f, c2);
		Product p5 = new Product(null, "Short jeans tamanho 40", 69.90f, c1);

		c1.getProducts().addAll(Arrays.asList(p1, p5));
		c2.getProducts().addAll(Arrays.asList(p3, p4));
		c3.getProducts().addAll(Arrays.asList(p2));
		
		categoryRepository.save(c1);
		categoryRepository.save(c2);
		categoryRepository.save(c3);
		
		productRepository.save(p1);
		productRepository.save(p2);
		productRepository.save(p3);
		productRepository.save(p4);
		productRepository.save(p5);
	}

}
