package model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ecom_product database table.
 * 
 */
@Entity
@Table(name="ecom_product")
@NamedQuery(name="EcomProduct.findAll", query="SELECT e FROM EcomProduct e")
public class EcomProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="product_id")
	private int productId;

	private String description;

	private String maker;

	@Column(name="maker_date")
	private Timestamp makerDate;

	@Column(name="product_category_id")
	private int productCategoryId;

	@Column(name="product_image")
	private String productImage;

	@Column(name="product_name")
	private String productName;

	@Column(name="product_price")
	private double productPrice;

	@Column(name="product_price_promotion")
	private double productPricePromotion;

	public EcomProduct() {
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMaker() {
		return this.maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public Timestamp getMakerDate() {
		return this.makerDate;
	}

	public void setMakerDate(Timestamp makerDate) {
		this.makerDate = makerDate;
	}

	public int getProductCategoryId() {
		return this.productCategoryId;
	}

	public void setProductCategoryId(int productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public String getProductImage() {
		return this.productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return this.productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public double getProductPricePromotion() {
		return this.productPricePromotion;
	}

	public void setProductPricePromotion(double productPricePromotion) {
		this.productPricePromotion = productPricePromotion;
	}

}