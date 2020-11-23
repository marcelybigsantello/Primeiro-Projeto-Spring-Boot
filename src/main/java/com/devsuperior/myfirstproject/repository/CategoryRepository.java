package com.devsuperior.myfirstproject.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.devsuperior.myfirstproject.entities.Category;

@Component
public class CategoryRepository {
	
	private Map<Integer, Category> map = new HashMap<>();

	public void save(Category obj) {
		map.put(obj.getId(), obj);
	}
	
	public List<Category> findAll(){
		return new ArrayList<Category>(map.values());
	}
	
	public Category findById(Integer id) {
		return map.get(id);
	}
}
