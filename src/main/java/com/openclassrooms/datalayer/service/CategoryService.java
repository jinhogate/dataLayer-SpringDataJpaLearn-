package com.openclassrooms.datalayer.service;

import java.util.Optional;

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

	/**
	 * Recuperer une catégorie à travers son id
	 * @param id
	 * @return
	 */
	public Optional<Category> getCategoryById(Integer id){
		return categoryRepository.findById(id);
	}

}
