package com.openclassrooms.datalayer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.datalayer.model.Product;
import com.openclassrooms.datalayer.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	/**
	 * Retourner la liste des produits dans la base
	 * @return
	 */
	public Iterable<Product> getAllProducts(){
		return productRepository.findAll();
	}

	/**
	 * Recuperer un produit par son id
	 * @param id
	 * @return
	 */
	public Optional<Product> getProductById(Integer id){
		return productRepository.findById(id);
	}

	/**
	 * Recuperer des produits en fonction de leur ID
	 * @param idList
	 * @return
	 */
	public Iterable<Product> getProducstById(Iterable<Integer> idList){
		return productRepository.findAllById(idList);
	}
}
