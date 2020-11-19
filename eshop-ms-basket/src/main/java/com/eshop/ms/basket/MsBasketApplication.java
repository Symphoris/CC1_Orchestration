package com.eshop.ms.basket;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import com.eshop.ms.basket.model.Panier;
import com.eshop.ms.basket.model.Product;
import com.eshop.ms.basket.repository.PanierRepository;
import com.eshop.ms.basket.repository.ProductRepository;

@SpringBootApplication


public class MsBasketApplication implements CommandLineRunner {

	private Product product1, product2;
	
	private PanierRepository panierRepository = new PanierRepository();
	
	
	public static void main(String[] args) {
		SpringApplication.run(MsBasketApplication.class, args);
		
		System.out.println("hello ESIPEN");
	}

	@Override
	public void run(String... args) throws Exception {
		product1 = new Product("159753258456", "Samsung S20+", 1000, 1);
		product2 = new Product("159753258457", "Dell Latitude", 700, 2);
		
	
		List<Product> list = new ArrayList<>();
		list.add(product1);
		list.add(product2);
	
		Panier panier = new Panier("symphoris@esipe.com", 2400, "Created",list );
		
		PanierRepository.addProduct(panier);
	}

}
