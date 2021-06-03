package com.hsp.shoppingcart;

import java.io.Serializable;

import com.hsp.product.Product;

public class ShoppingList implements Serializable {
	private Product product;
	private ShoppingCart shoppingCart;
	
	public ShoppingList() {
	}

	public ShoppingList(Product product, ShoppingCart shoppingCart) {
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
		return "ShoppingList [product=" + product + ", shoppingCart=" + shoppingCart + "]";
	}
}
