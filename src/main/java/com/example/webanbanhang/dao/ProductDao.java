package com.example.webanbanhang.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.webanbanhang.model.Product;
import com.example.webanbanhang.model.ProductInfo;

@Transactional
@Repository
public class ProductDao {
	@Autowired 
	SessionFactory sessionFactory;
	public  Product findProduct(String code) {
		try {
			String sql="select e from"+Product.class.getName()+"e where e.code=:code";
			Session session=this.sessionFactory.getCurrentSession();
			Query<Product> query=session.createQuery(sql,Product.class);
			query.setParameter("code",code);
		} catch (Exception e) {
			return null;
		}
		return null;
	}
	public ProductInfo  finProductInfo(String code) {
		Product product=this.findProduct(code);
		if (product==null) {
			return null;
		}
		return new ProductInfo(product.getCode(),product.getName(), product.getPrice());
	}
	@Transactional
	public void name() {
		
	}
}
