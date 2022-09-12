package com.example.webanbanhang.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Products")
public class Product {
	@Id
	@Column(name ="Code",length = 20,nullable = false)
	String code;
	@Column(name = "Name",length = 255,nullable = false)
	String name;
	double price;
	byte [] image;
	Date createDate;
	
}
