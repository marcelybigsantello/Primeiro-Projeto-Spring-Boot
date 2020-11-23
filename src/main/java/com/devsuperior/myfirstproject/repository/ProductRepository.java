package com.devsuperior.myfirstproject.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.devsuperior.myfirstproject.entities.Product;

@Component
public class ProductRepository {
	
	private Map<Integer, Product> map = new HashMap<>();

	public void save(Product obj) {
		map.put(obj.getId(), obj);
	}
	
	public List<Product> findAll(){
		return new ArrayList<Product>(map.values());
	}
	
	public Product findById(Integer id) {
		return map.get(id);
	}
}
