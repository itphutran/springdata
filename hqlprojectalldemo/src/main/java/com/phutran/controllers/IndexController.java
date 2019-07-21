package com.phutran.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.phutran.entities.Category;
import com.phutran.repositories.CategoryRepository;
import com.phutran.services.CategoryService;

@Controller
public class IndexController {
	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public String index() {
		return "public/index";
	}

	@GetMapping("add/{name}")
	public String addItem(@PathVariable String name) {
		Category categorySave = categoryService.save(new Category(name));
		System.out.println(categorySave);
		return "public/index";
	}
}
