package com.openclassrooms.datalayer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.datalayer.model.Category;
import com.openclassrooms.datalayer.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	/**
	 * Retourne la liste des catégories
	 * @return
	 */
	public Iterable<Category> getAllCategories(){
		return categoryRepository.findAll();
	}

}
