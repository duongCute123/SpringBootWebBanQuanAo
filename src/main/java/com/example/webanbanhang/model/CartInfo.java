package com.example.webanbanhang.model;

public class CartInfo {
	int orderNum;
	CustomerInfo customerInfo;

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

	@Override
	public String toString() {
		return "CartInfo [orderNum=" + orderNum + ", customerInfo=" + customerInfo + "]";
	}

	public CartInfo(int orderNum, CustomerInfo customerInfo) {
		super();
		this.orderNum = orderNum;
		this.customerInfo = customerInfo;
	}

	public CartInfo() {
		super();
	}

}
