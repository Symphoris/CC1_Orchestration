package com.eshop.ms.menbership.model;

import java.util.List;

public class Panier {
	private String user;
	private int totalAmount;
	private String  status;
	private List<Product> items;
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
	
}
