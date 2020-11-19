package com.eshop.ms.menbership.model;

public class Product {
	
	
	private String gtin;
	
	private String label;
	
	private int unitPrice;
	private int quantity;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Product(String gtin, String label, int unitPrice, int quantity) {
		super();
		this.gtin = gtin;
		this.label = label;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}
	public String getGtin() {
		return gtin;
	}
	public void setGtin(String gtin) {
		this.gtin = gtin;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	

}
