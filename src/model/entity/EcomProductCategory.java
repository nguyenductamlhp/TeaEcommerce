package model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ecom_product_category database table.
 * 
 */
@Entity
@Table(name="ecom_product_category")
@NamedQuery(name="EcomProductCategory.findAll", query="SELECT e FROM EcomProductCategory e")
public class EcomProductCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="product_category_id")
	private int productCategoryId;

	@Column(name="category_name")
	private String categoryName;

	private String description;

	public EcomProductCategory() {
	}

	public int getProductCategoryId() {
		return this.productCategoryId;
	}

	public void setProductCategoryId(int productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}