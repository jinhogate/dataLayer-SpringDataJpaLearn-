/**
 * 
 */
package com.openclassrooms.datalayer.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.openclassrooms.datalayer.model.Product;

/**
 * @author jorji
 *
 */

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

	public Iterable<Product> findByName(String name); // Exemple de méthode qui est une requête dérivée
	public Iterable<Product> findDistinctByName(String name); // Exemple de méthode qui est une requête dérivée
	public Iterable<Product> findByNameAndCost(String name, Long cost); // Exemple de méthode qui est une requête dérivée
	public Iterable<Product> findByNameOrCost(String name, Long cost); // Exemple de méthode qui est une requête dérivée
	public Iterable<Product> findByNameLike(String name); // Exemple de méthode qui est une requête dérivée
	public Iterable<Product> findByNameContaining(String name); // Exemple de méthode qui est une requête dérivée
	public Iterable<Product> findByCategoriesName(String catName);

	// JPQL
	@Query("FROM Product WHERE name = ?1")
	public Iterable<Product> findByNameJPQL(String name);

	// Native Query
	@Query(value = "Select * from produit where nom = :name", nativeQuery = true)
	public Iterable<Product> findByNameNativeQuery(@Param("name")String name);

}
