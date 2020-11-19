package com.eshop.ms.basket.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eshop.ms.basket.model.Panier;
import com.eshop.ms.basket.model.Product;

public class PanierRepository {
	
	public PanierRepository() {
		// TODO Auto-generated constructor stub
	}
	
private static Map<String, Panier> panierInMemory = new HashMap<>();
	
	public static void addProduct(Panier panier){
		
		panierInMemory.put(panier.getUser(), panier);
	}
	
	public static ArrayList<Panier> getAll(){
		return new ArrayList<Panier>(panierInMemory.values());
	}
	
	public static Panier getByUser(String user) {
		
		return panierInMemory.get(user);
		
	}
	
	

}
