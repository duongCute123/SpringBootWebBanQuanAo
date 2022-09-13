package com.example.webanbanhang.dao;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.webanbanhang.model.CartInfo;
import com.example.webanbanhang.model.CartLineInfo;
import com.example.webanbanhang.model.CustomerInfo;
import com.example.webanbanhang.model.Order;
import com.example.webanbanhang.model.OrderDetail;
import com.example.webanbanhang.model.OrderDetailnfo;
import com.example.webanbanhang.model.OrderInfo;
import com.example.webanbanhang.model.Product;

@Transactional
@Repository
public class OrderDao {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	ProductDao productDao;

	private int getMaxxOrder() {
		String sql = "select max(o.orderNum) from" + Order.class.getName() + "o";
		Session session = this.sessionFactory.getCurrentSession();
		Query<Integer> query = session.createQuery(sql, Integer.class);
		Integer value = (Integer) query.getSingleResult();
		if (value == null) {
			return 0;
		}
		return value;

	}

	@Transactional(rollbackFor = Exception.class)
	public void saveOrder(CartInfo cartInfo) {
		Session session = sessionFactory.getCurrentSession();
		int orderNum = this.getMaxxOrder();
		Order order = new Order();
		order.setId(UUID.randomUUID().toString());
		order.setOrderNum(orderNum);
		order.setOderDate(new Date());
		order.setAmount(cartInfo.getAmountTotal());
		CustomerInfo customerInfo = cartInfo.getCustomerInfo();
		order.setCustomerName(customerInfo.getName());
		order.setCustomerEmail(customerInfo.getEmail());

		order.setCustomerPhone(customerInfo.getPhone());
		order.setCustomerAddress(customerInfo.getAddress());
		session.persist(order);
		List<CartLineInfo> lines = cartInfo.getCartLines();
		for (CartLineInfo cartLineInfo : lines) {
			OrderDetail detail = new OrderDetail();
			detail.setId(UUID.randomUUID().toString());
			detail.setOrder(order);
			detail.setAmount(cartLineInfo.getAmount());
			detail.setPrice(cartLineInfo.getQuanlity());
			String code = cartLineInfo.getProductInfo().getCode();
			Product product = this.productDao.findProduct(code);
			detail.setProduct(product);
			session.persist(detail);
		}
		cartInfo.setOrderNum(orderNum);
		session.flush();

	}

	// @page = 1, 2, ...
	public PaginationResult<OrderInfo> listOrderInfo(int page, int maxResult, int maxNavigationPage) {
		String sql = "Select new " + OrderInfo.class.getName()//
				+ "(ord.id, ord.orderDate, ord.orderNum, ord.amount, "
				+ " ord.customerName, ord.customerAddress, ord.customerEmail, ord.customerPhone) " + " from "
				+ Order.class.getName() + " ord "//
				+ " order by ord.orderNum desc";

		Session session = this.sessionFactory.getCurrentSession();
		Query<OrderInfo> query = session.createQuery(sql, OrderInfo.class);
		return new PaginationResult<OrderInfo>(query, page, maxResult, maxNavigationPage);
	}

	public Order findOrder(String orderId) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.find(Order.class, orderId);
	}

	public OrderInfo getOrderInfo(String orderId) {
		Order order = this.findOrder(orderId);
		if (order == null) {
			return null;
		}
		return new OrderInfo(order.getId(), order.getOderDate(), order.getOrderNum(), order.getAmount(),
				order.getCustomerName(), order.getCustomerEmail(), order.getCustomerAddress(),
				order.getCustomerPhone());
	}

	public List<OrderDetailnfo> listOrderDetailInfos(String orderId) {
		String sql = "Select new " + OrderDetailnfo.class.getName() //
				+ "(d.id, d.product.code, d.product.name , d.quanity,d.price,d.amount) "//
				+ " from " + OrderDetail.class.getName() + " d "//
				+ " where d.order.id = :orderId ";

		Session session = this.sessionFactory.getCurrentSession();
		Query<OrderDetailnfo> query = session.createQuery(sql, OrderDetailnfo.class);
		query.setParameter("orderId", orderId);

		return query.getResultList();
	}
}
