package com.example.webanbanhang.model;

public class CartLineInfo {
	ProductInfo productInfo;
	int quanlity;

	public ProductInfo getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}

	public int getQuanlity() {
		return quanlity;
	}

	public void setQuanlity(int quanlity) {
		this.quanlity = quanlity;
	}

	public CartLineInfo(ProductInfo productInfo, int quanlity) {
		super();
		this.productInfo = productInfo;
		this.quanlity = quanlity;
	}

	public CartLineInfo() {
		// TODO Auto-generated constructor stub
	}

	public double getAmount() {
		return this.productInfo.getPrice() * this.quanlity;
	}
}
