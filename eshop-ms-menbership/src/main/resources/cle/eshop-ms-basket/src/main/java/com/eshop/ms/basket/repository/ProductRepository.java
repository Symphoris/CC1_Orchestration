package com.eshop.ms.basket.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.eshop.ms.basket.model.Product;

@Component
public class ProductRepository {

	private static Map<String, Product> panierInMemory = new HashMap<>();
	
	public static void addProduct(Product product){
		
		panierInMemory.put(product.getLabel(), product);
	}
	
	public Product getProductByLabel(String label){
		
		return panierInMemory.get(label);
	}
	
	public List<Product> getAll(){
		return new ArrayList<Product>(panierInMemory.values());
	}
	
	public void updateProduct(Product product){
		
		panierInMemory.put(product.getLabel(), product);
	}
	
	public void deleteProductByLabel(String label){
		
		panierInMemory.remove(label);
	}
}
