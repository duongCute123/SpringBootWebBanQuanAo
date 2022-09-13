package com.example.webanbanhang.model;

import java.util.Date;
import java.util.List;

public class OrderInfo {
	String id;
	Date orderDate;
	int odernum;
	double amount;
	String customerName;
	String customerAddress;
	String customerEmail;
	String customerPhone;
	List<OrderDetailnfo> details;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getOdernum() {
		return odernum;
	}

	public void setOdernum(int odernum) {
		this.odernum = odernum;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public List<OrderDetailnfo> getDetails() {
		return details;
	}

	public void setDetails(List<OrderDetailnfo> details) {
		this.details = details;
	}

	public OrderInfo(String id, Date orderDate, int odernum, double amount, String customerName, String customerAddress,
			String customerEmail, String customerPhone, List<OrderDetailnfo> details) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.odernum = odernum;
		this.amount = amount;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
		this.details = details;
	}
	

	public OrderInfo(String id, Date orderDate, int odernum, double amount, String customerName, String customerAddress,
			String customerEmail, String customerPhone) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.odernum = odernum;
		this.amount = amount;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
	}

	public OrderInfo() {
		super();
	}

}
