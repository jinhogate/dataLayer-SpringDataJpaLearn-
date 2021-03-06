package com.openclassrooms.datalayer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.datalayer.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer>{
}
