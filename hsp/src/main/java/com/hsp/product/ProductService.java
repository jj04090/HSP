package com.hsp.product;

import java.util.List;

public interface ProductService {
	public void registProduct(Product product);
	public void updateProduct(Product product);
	public void deleteProduct(Product product);
	public List<Product> viewProductList(Product product);
	public Product viewProduct(Product product);
}
