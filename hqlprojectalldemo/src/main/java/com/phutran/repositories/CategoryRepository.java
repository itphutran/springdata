package com.phutran.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phutran.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	Category getCategoryById(Long id);
}
