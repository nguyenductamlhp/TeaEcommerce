package com.t3h.ecommerce.entity;


public class ProductCart {
private EcomProduct ecomProduct;
private int quantity;
public ProductCart(EcomProduct ecomProduct, int quantity) {
	super();
	this.ecomProduct = ecomProduct;
	this.quantity = quantity;
}
/**
 * @return the ecomProduct
 */
public EcomProduct getEcomProduct() {
	return ecomProduct;
}
/**
 * @param ecomProduct the ecomProduct to set
 */
public void setEcomProduct(EcomProduct ecomProduct) {
	this.ecomProduct = ecomProduct;
}
/**
 * @return the quantity
 */
public int getQuantity() {
	return quantity;
}
/**
 * @param quantity the quantity to set
 */
public void setQuantity(int quantity) {
	this.quantity = quantity;
}

}
