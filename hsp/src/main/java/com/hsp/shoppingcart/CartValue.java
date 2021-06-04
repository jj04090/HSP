package com.hsp.shoppingcart;

import java.io.Serializable;

import com.hsp.product.Product;

public class CartValue implements Serializable {
	private Product product;
	private ShoppingCart shoppingCart;
	public CartValue() {
	}
	public CartValue(Product product, ShoppingCart shoppingCart) {
		this.product = product;
		this.shoppingCart = shoppingCart;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	@Override
	public String toString() {
		return "CartValue [product=" + product + ", shoppingCart=" + shoppingCart + "]";
	}
	
	
	
}
