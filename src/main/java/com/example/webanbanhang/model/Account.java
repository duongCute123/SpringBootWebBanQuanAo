package com.example.webanbanhang.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Account")
public class Account {
	@Id
	@Column(name = "User_Name", length = 20, nullable = false)
	String userName;
	@Column(name = "Encryted_Password", length = 128, nullable = false)
	String encytedPassword;
	@Column(name = "Active", length = 1, nullable = false)
	boolean active;
	@Column(name = "User_Role", length = 20, nullable = false)
	String userRolel;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEncytedPassword() {
		return encytedPassword;
	}

	public void setEncytedPassword(String encytedPassword) {
		this.encytedPassword = encytedPassword;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getUserRolel() {
		return userRolel;
	}

	public void setUserRolel(String userRolel) {
		this.userRolel = userRolel;
	}

	public Account(String userName, String encytedPassword, boolean active, String userRolel) {
		super();
		this.userName = userName;
		this.encytedPassword = encytedPassword;
		this.active = active;
		this.userRolel = userRolel;
	}

	@Override
	public String toString() {
		return "Account [userName=" + userName + ", encytedPassword=" + encytedPassword + ", active=" + active
				+ ", userRolel=" + userRolel + "]";
	}

	public Account() {
		super();
	}

}
