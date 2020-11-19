package com.eshop.ms.basket.model;

import java.util.List;

public class Panier {
	private String user;
	private int totalAmount;
	private String  status;
	private List<Product> items;
	
	
	
	
	public Panier(String user, int totalAmount, String status, List<Product> items) {
		super();
		this.user = user;
		this.totalAmount = totalAmount;
		this.status = status;
		this.items = items;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Product> getItems() {
		return items;
	}
	public void setItems(List<Product> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Panier [user=" + user + ", totalAmount=" + totalAmount + ", status=" + status + ", items=" + items
				+ "]";
	}
	
}
