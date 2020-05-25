package com.ezeeshop.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "products")
/*
 * @Data
 * 
 * @Getter
 * 
 * @Setter
 */
//@ApiModel(description="Model Class of Products")
public class Product
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	//@ApiModelProperty(notes = "Id of Product")
	private Long id;
	
	@Column(name="product_name")
	//@ApiModelProperty(notes = "Name of Product")
	private String productName;
	
	@Column(name="product_price")
	//@ApiModelProperty(notes = "Price of Product")
	private int productPrice;
	
	@Column(name="product_image_url")
	//@ApiModelProperty(notes = "ImageUrl of Product")
	private String productImageUrl;
	
	@Column(name="product_add_date")
	//@ApiModelProperty(notes = "AddDate of Product")
	private LocalDate productAddDate;
	
	@Column(name="product_description")
	//@ApiModelProperty(notes = "Description of Product")
	private String productDescription;
	
	@Column(name="product_rating")
	//@ApiModelProperty(notes = "Rating of Product")
	private double productRating;
	
	@Transient
	//@ApiModelProperty(notes = "Category_Id of Product")
	private Long categoryId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="category_id", nullable=false)
	//@ApiModelProperty(notes = "Category of Product")
	private ProductCategory category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductImageUrl() {
		return productImageUrl;
	}

	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}

	public LocalDate getProductAddDate() {
		return productAddDate;
	}

	public void setProductAddDate(LocalDate productAddDate) {
		this.productAddDate = productAddDate;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getProductRating() {
		return productRating;
	}

	public void setProductRating(double productRating) {
		this.productRating = productRating;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productImageUrl=" + productImageUrl + ", productAddDate=" + productAddDate
				+ ", productDescription=" + productDescription + ", productRating=" + productRating + ", categoryId="
				+ categoryId + "]";
	}
}
