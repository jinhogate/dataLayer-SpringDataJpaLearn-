package com.openclassrooms.datalayer;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.openclassrooms.datalayer.model.Category;
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

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// LES INSTRUCTIONS DE CETTE METHODE SERONT EXECUTEES A CHAQUE FOIS QUE L APPLI SERA LANCEE

		//		System.out.println("#La liste des noms des produits");
		//		Iterable<Product> products = productService.getAllProducts();
		//		products.forEach(product-> System.out.println("-->"+product.getName()));
		//
		//		System.out.println("#La liste des noms des categories");
		//		Iterable<Category> categories = categoryService.getAllCategories();
		//		categories.forEach(category-> System.out.println("-->"+category.getName()));
		//
		//		System.out.println("#La liste des noms des commentaires et des produits associés");
		//		Iterable<Comment> comments = commentService.getAllComments();
		//		comments.forEach(comment-> System.out.println("-->"+comment.getContent()+ " & produit: " + comment.getProduct().getName()));
		//
		//		System.out.println("#Reucperer un produit par son ID");
		//		final Integer PRODUCT_ID = 2;
		//		Optional<Product> product = productService.getProductById(PRODUCT_ID);
		//		if(product.isPresent()) {
		//			System.out.println("-->Le produit N:" + PRODUCT_ID + " = " + product.get().getName());
		//		}
		//		System.out.println("### La liste des comments du produit " + PRODUCT_ID);
		//		product.get().getComments().forEach(comment->System.out.println("-->"+comment.getContent()));
		//		System.out.println("### La liste des catégories du produit");
		//		product.get().getCategories().forEach(cat->System.out.println("-->"+cat.getName()));
		//
		//		System.out.println("#Recuperer les produits par leur ID");
		//		Iterable<Integer> idList = Arrays.asList(1,2,3);
		//		Iterable<Product> productList = productService.getProducstById(idList);
		//		productList.forEach(productElement-> System.out.println("-->" + productElement.getName()));
		//
		//		System.out.println("#Reucperer une catégorie par son ID");
		//		final Integer CATEG_ID = 1;
		//		Optional<Category> category = categoryService.getCategoryById(CATEG_ID);
		//		if(category.isPresent()) {
		//			System.out.println("-->La catégorie N:" + CATEG_ID + " = " + category.get().getName());
		//		}
		//		System.out.println("### La liste des produits de la categorie " + CATEG_ID);
		//		category.get().getProducts().forEach(produit_cat->System.out.println("--> produit :" + produit_cat.getName()));

		//		System.out.println("# Ajouter une nouvelle catégorie");
		//		Category cat = new Category();
		//		cat.setName("Promotion");
		//
		//
		//		Category resCat = categoryService.addCategory(cat);
		//		//		System.out.println("--> Categorie ajouté : " + resCat.getCategoryId() + "-" + resCat.getName());
		//
		//		Product produit = new Product();
		//		produit.setName("Mango");
		//		produit.setDescription("Fruit tropicale");
		//		produit.setCost((long) 500);
		//		// Cette ligne permet de faire le lien entre la catégorie et le produit.
		//		resCat.addProduct(produit);
		//
		//		Product produitRes = productService.addProduct(produit);

		// Recuperer le produit sur lequel on veut ajouter le commentaire
		//		Product product = productService.getProductById(7).get();
		//		Comment newComment = new Comment();
		//		newComment.setContent("Ce produit est très sucré et coute moins cher");
		//		product.addComment(newComment);
		//
		//		commentService.addComment(newComment);

		//		Product existedProduct = productService.getProductById(7).get();
		//		existedProduct.setCost((long) 300);
		//
		//		productService.addProduct(existedProduct);

		//		productService.deleteProduct(7);
		//		Iterable<Product> products = productService.getProduitByNameNative("AssuranceAuTiersSimple");
		//		products.forEach(product->System.out.println("-->"+product.getName()));
		//		Iterable<Product> products2 = productService.getProduitByCategorieName("Standard");
		//		products2.forEach(product->System.out.println("-->"+product.getName()));

		Category newCat = new Category();
		newCat.setName("Last category");

		Product newProduct = new Product();
		newProduct.setName("Assurance moto");
		newProduct.setDescription("Assurance pour tous les automobilistes");
		newProduct.setCost((long)1000);

		newProduct.getCategories().add(newCat);
		newCat.getProducts().add(newProduct);

		productService.addProduct(newProduct);











	}

}
