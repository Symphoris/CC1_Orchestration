package com.eshop.ms.basket.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.ms.basket.model.Context;
import com.eshop.ms.basket.model.Panier;
import com.eshop.ms.basket.model.Product;
import com.eshop.ms.basket.model.Value;
import com.eshop.ms.basket.repository.PanierRepository;
import com.eshop.ms.basket.security.JwTokenValidator;
import com.eshop.ms.basket.service.ProductService;

@RestController
@RequestMapping(value = "products", produces = {"application/json"})
public class ProductResource {
	private PanierRepository panierRepository;

	@Autowired
	private ProductService service;
	
	@Autowired
	private JwTokenValidator jwtvalidator = new JwTokenValidator();
	
	public ProductResource() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping
	public List<Product> getAll(){
		return service.getAll();
	}
	
	@GetMapping("{label}")
	public Product getOne(@PathVariable("label") String label){
		
		return service.getProduct(label);
	}
	
	@PostMapping()
	public void addProduct(@RequestBody Product product){
		
		service.addProduct(product);
	}
	
	@PutMapping("{label}")
	public void updateProduct(@PathVariable("label") String label, @RequestBody Product product){
		
		service.updateProduct(label, product);
	}
	
	@DeleteMapping("{label}")
	public void deleteProduct(@PathVariable("label") String label){
		
		service.deleteProduct(label);
	}
	
	@PostMapping("validate")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	public Panier parseToken(@RequestBody String token) {
		//String token = value.setValue(token);
		
		Context context =	jwtvalidator.transforme(token);
		
		return PanierRepository.getByUser(context.getSubject());
				
		
	}
	
}
