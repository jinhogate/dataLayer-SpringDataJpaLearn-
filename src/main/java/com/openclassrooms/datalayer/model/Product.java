/**
 * 
 */
package com.openclassrooms.datalayer.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

/**
 * @author jorji
 *
 */

@DynamicUpdate // cette annotation permet lors de la maj des produits, de mettre à jour que les colonnes concernées
@Entity
@Table(name = "produit")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "produit_id")
	private Integer productId;

	@Column(name = "nom")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "cout")
	private Long cost;

	@OneToMany(
			mappedBy = "product",
			cascade = CascadeType.ALL,
			orphanRemoval = true
			)
	private List<Comment> comments = new ArrayList<Comment>();


	@ManyToMany(
			mappedBy = "products",
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE,
					CascadeType.REFRESH
			}
			)
	private List<Category> categories = new ArrayList<Category>();




	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCost() {
		return cost;
	}

	public void setCost(Long cost) {
		this.cost = cost;
	}

	/**
	 * Les méthodes utilitaires
	 * @param comment
	 */
	public void addComment(Comment comment) {
		comments.add(comment);
		comment.setProduct(this);
	}
	public void removeComment(Comment comment) {
		comments.remove(comment);
		comment.setProduct(null);
	}


}
