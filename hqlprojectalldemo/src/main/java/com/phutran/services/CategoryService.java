package com.phutran.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.phutran.entities.Category;
public interface CategoryService {
	List<Category> findAll();

	Category findByCatId(Long catId);

	Category save(Category category);

	void delete(Long crowdNewsId);
}
