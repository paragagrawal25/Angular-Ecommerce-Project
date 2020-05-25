package com.ezeeshop.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
/*
 * @Getter
 * 
 * @Setter
 */
//@ApiModel(description="Model Class of Product_Category")
public class ProductCategory 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	//@ApiModelProperty(notes = "Id of ProductCategory")
	private Long id;
	
	@Column(name="category_name")
	//@ApiModelProperty(notes = "Name of ProductCategory")
	private String productCategoryName;
	
	@JsonManagedReference
	@OneToMany(cascade=CascadeType.ALL, mappedBy="category")
	//@ApiModelProperty(notes = "List of Product in particular ProductCategory")
	private Set<Product> productList;

	public ProductCategory() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductCategoryName() {
		return productCategoryName;
	}

	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
	}
	
	
}

