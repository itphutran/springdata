package com.phutran.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phutran.entities.Category;
import com.phutran.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	public Category findByCatId(Long id) {
		return categoryRepository.getCategoryById(id);
	}

	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	public void delete(Long id) {
		categoryRepository.deleteById(id);
	}
}
