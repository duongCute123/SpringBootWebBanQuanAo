package com.example.webanbanhang.model;

public class OrderDetailnfo {
	String id;
	String productCodel;
	String productName;
	int quanlity;
	double price;
	double amount;
	public OrderDetailnfo(String id, String productCodel, String productName, int quanlity, double price,
			double amount) {
		super();
		this.id = id;
		this.productCodel = productCodel;
		this.productName = productName;
		this.quanlity = quanlity;
		this.price = price;
		this.amount = amount;
	}
	public OrderDetailnfo() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductCodel() {
		return productCodel;
	}
	public void setProductCodel(String productCodel) {
		this.productCodel = productCodel;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuanlity() {
		return quanlity;
	}
	public void setQuanlity(int quanlity) {
		this.quanlity = quanlity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
