package com.example.webanbanhang.model;

import java.util.ArrayList;
import java.util.List;

public class CartInfo {
	int orderNum;
	CustomerInfo customerInfo;
	List<CartLineInfo> cartLines = new ArrayList<CartLineInfo>();

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	public List<CartLineInfo> getCartLines() {
		return cartLines;
	}

	public void setCartLines(List<CartLineInfo> cartLines) {
		this.cartLines = cartLines;
	}

	public CartInfo(int orderNum, CustomerInfo customerInfo, List<CartLineInfo> cartLines) {
		super();
		this.orderNum = orderNum;
		this.customerInfo = customerInfo;
		this.cartLines = cartLines;
	}

	@Override
	public String toString() {
		return "CartInfo [orderNum=" + orderNum + ", customerInfo=" + customerInfo + ", cartLines=" + cartLines + "]";
	}

	public CartInfo() {
		super();
	}

	public CartLineInfo findlineByCode(String code) {
		for (CartLineInfo cartLineInfo : cartLines) {
			if (cartLineInfo.getProductInfo().getCode().equals(code)) {
				return cartLineInfo;
			}
		}
		return null;
	}

	public void addProduct(ProductInfo productInfo, int quanlity) {
		CartLineInfo line = this.findlineByCode(productInfo.getCode());
		if (line == null) {
			line = new CartLineInfo();
			line.setQuanlity(0);
			line.setProductInfo(productInfo);
			this.cartLines.add(line);
		}
		int newQuanlity = line.getQuanlity() + quanlity;
		if (newQuanlity <= 0) {
			this.cartLines.remove(line);

		} else {
			line.setQuanlity(newQuanlity);
		}
	}

	public void valid() {

	}

	public void upDateProduct(String code, int quanlity) {
		CartLineInfo line = this.findlineByCode(code);
		if (line != null) {
			if (quanlity <= 0) {
				this.cartLines.remove(line);
			} else {
				line.setQuanlity(quanlity);
			}
		}
	}

	public void removeProduct(ProductInfo productInfo) {
		CartLineInfo lineInfo = this.findlineByCode(productInfo.getCode());
		if (lineInfo != null) {
			this.cartLines.remove(lineInfo);
		}
	}

	public boolean isEmty() {
		return this.cartLines.isEmpty();
	}

	public boolean jsValidCustomer() {
		return this.customerInfo != null && this.customerInfo.isValid();
	}

	public int getQuanlityTotal() {
		int quanlity = 0;
		for (CartLineInfo cartLineInfo : cartLines) {
			quanlity += cartLineInfo.getQuanlity();
		}
		return quanlity;
	}

	public double getAmountTotal() {
		double total = 0;
		for (CartLineInfo cartLineInfo : cartLines) {
			total += cartLineInfo.getAmount();
		}
		return total;
	}

	public void updateQuanlity(CartInfo cartForm) {
		if (cartForm != null) {
			List<CartLineInfo> line = cartForm.getCartLines();
			for (CartLineInfo cartLineInfo : line) {
				this.upDateProduct(cartLineInfo.getProductInfo().getCode(), cartLineInfo.getQuanlity());
			}
		}
	}
//	public void setCustomerInfo(CustomerInfo customerInfo) {
//		for (CartLineInfo cartLineInfo : cartLines) {
//			if (cartLineInfo.) {
//				
//			}
//		}
//		
//		
//		
//		return null;
//	}
}
