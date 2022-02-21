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

	/**
	 * Création d'un nouveau produit
	 * @param product
	 * @return
	 */
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	/**
	 * Suppression d'u produit
	 * @param idProduct
	 * @return
	 */
	public void deleteProduct(Integer idProduct) {
		productRepository.deleteById(idProduct);
	}

	/**
	 * Recupérer les produits à travers les noms
	 * @param name
	 * @return
	 */
	public Iterable<Product> getProductsByName(String name){
		return productRepository.findByName(name);
	}

	public Iterable<Product> getProductsLike(String name){
		return productRepository.findByNameLike(name);
	}

	public Iterable<Product> getProduitByCategorieName(String catName){
		return productRepository.findByCategoriesName(catName);
	}

	public Iterable<Product> getProduitByNameJPQL(String catName){
		return productRepository.findByNameJPQL(catName);
	}


	public Iterable<Product> getProduitByNameNative(String catName){
		return productRepository.findByNameNativeQuery(catName);
	}








}
