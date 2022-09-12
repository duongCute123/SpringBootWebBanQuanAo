package com.example.webanbanhang.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Orders", uniqueConstraints = { @UniqueConstraint(columnNames = "Order_Num") })
public class Order {
	@Id
	@Column(name = "ID")
	String id;
	@Column(name = "Order_Date")
	Date oderDate;
	@Column(name = "Order_Num")
	int orderNum;
	@Column(name = "Amount")
	double amount;
	@Column(name = "Customer_Name")
	String customerName;
	@Column(name = "Customer_Address")
	String customerAddress;
	@Column(name = "Customer_Email")
	String customerEmail;
	@Column(name = "Customer_Phone")
	String customerPhone;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getOderDate() {
		return oderDate;
	}

	public void setOderDate(Date oderDate) {
		this.oderDate = oderDate;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
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

	public Order(String id, Date oderDate, int orderNum, double amount, String customerName, String customerAddress,
			String customerEmail, String customerPhone) {
		super();
		this.id = id;
		this.oderDate = oderDate;
		this.orderNum = orderNum;
		this.amount = amount;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", oderDate=" + oderDate + ", orderNum=" + orderNum + ", amount=" + amount
				+ ", customerName=" + customerName + ", customerAddress=" + customerAddress + ", customerEmail="
				+ customerEmail + ", customerPhone=" + customerPhone + "]";
	}

	public Order() {
		super();
	}

}
