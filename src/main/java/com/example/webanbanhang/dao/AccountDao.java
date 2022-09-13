package com.example.webanbanhang.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.webanbanhang.model.Account;

@Transactional
@Repository
public class AccountDao {
	@Autowired
	SessionFactory sessionFactory;

	public Account findAccount(String userName) {
		Session s = sessionFactory.getCurrentSession();

		return s.find(Account.class, userName);
	}
}
