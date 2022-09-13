package com.example.webanbanhang.dao;

import java.util.Date;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.webanbanhang.model.Order;

@Transactional
@Repository
public class OrderDao {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	ProductDao productDao;
	private int getMaxxOrder() {
		String sql="select max(o.orderNum) from"+Order.class.getName()+"o";
		Session session=this.sessionFactory.getCurrentSession();
		Query<Integer> query=session.createQuery(sql,Integer.class);
		Integer value = (Integer) query.getSingleResult();
		if (value==null) {
			return 0;
		}
		return value;
		
	}
	public void saveOrder() {
		Session session=sessionFactory.getCurrentSession();
		int orderNum=this.getMaxxOrder();
		Order order=new Order();
		order.setId(UUID.randomUUID().toString());
		order.setOrderNum(orderNum);
		order.setOderDate(new Date());
		order.setAmount(cartInfo.getAmountTotal());
		CustomerInfo customerInfo = cartInfo.getCustomerInfo();
		
	}
}
