package com.eshop.ms.basket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.ms.basket.model.Product;
import com.eshop.ms.basket.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public void addProduct(Product product){
		if("".equals(product.getLabel()) || "".equals(product.getGtin()) || "".equals(product.getQuantity()) || "".equals(product.getUnitPrice())){
			throw new RuntimeException("product exception");
		}
		repository.addProduct(product);
	}
	
	public Product getProduct(String label){
		
		Product product = repository.getProductByLabel(label);
		
		if(product == null){
			throw new RuntimeException("product not found");
		}
		
		return product;
	}
	
	public List<Product> getAll(){
		return repository.getAll();
	}
	
	public void updateProduct(String label, Product product){
		
		if(repository.getProductByLabel(label) == null){
			throw new RuntimeException("product not found");
		}
		
		repository.updateProduct(product);
	}
	
	public void deleteProduct(String label){
		
		if(repository.getProductByLabel(label) == null){
			throw new RuntimeException("product not found");
		}
		
		repository.deleteProductByLabel(label);
	}

	public ProductRepository getRepository() {
		return repository;
	}

	public void setRepository(ProductRepository repository) {
		this.repository = repository;
	}
	
	
}
