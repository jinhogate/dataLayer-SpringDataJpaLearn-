package com.openclassrooms.datalayer;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.openclassrooms.datalayer.model.Category;
import com.openclassrooms.datalayer.model.Comment;
import com.openclassrooms.datalayer.model.Product;
import com.openclassrooms.datalayer.service.CategoryService;
import com.openclassrooms.datalayer.service.CommentService;
import com.openclassrooms.datalayer.service.ProductService;

@SpringBootApplication
public class DataLayerApplication implements CommandLineRunner {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CommentService commentService;

	public static void main(String[] args) {
		SpringApplication.run(DataLayerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// LES INSTRUCTIONS DE CETTE METHODE SERONT EXECUTEES A CHAQUE FOIS QUE L APPLI SERA LANCEE

		System.out.println("#La liste des noms des produits");
		Iterable<Product> products = productService.getAllProducts();
		products.forEach(product-> System.out.println("-->"+product.getName()));

		System.out.println("#La liste des noms des categories");
		Iterable<Category> categories = categoryService.getAllCategories();
		categories.forEach(category-> System.out.println("-->"+category.getName()));

		System.out.println("#La liste des noms des commentaires");
		Iterable<Comment> comments = commentService.getAllComments();
		comments.forEach(comment-> System.out.println("-->"+comment.getContent()));

		System.out.println("#Reucperer un produit par son ID");
		final Integer PRODUCT_ID = 2;
		Optional<Product> product = productService.getProductById(PRODUCT_ID);
		if(product.isPresent()) {
			System.out.println("-->Le produit N:" + PRODUCT_ID + " = " + product.get().getName());
		}

		System.out.println("#Recuperer les produits par leur ID");
		Iterable<Integer> idList = Arrays.asList(1,2,3);
		Iterable<Product> productList = productService.getProducstById(idList);
		productList.forEach(productElement-> System.out.println("-->" + productElement.getName()));
	}

}
