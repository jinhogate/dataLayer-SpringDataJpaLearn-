/**
 * 
 */
package com.openclassrooms.datalayer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.datalayer.model.Product;

/**
 * @author jorji
 *
 */

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
