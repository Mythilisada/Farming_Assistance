package com.capgemini.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin_login")
public class AdminLogin {
	
	@Id
	@Column(length = 255)
	private String a_id;
	
	@Column(length = 255)
	private String a_password;

	public AdminLogin(String a_id, String a_password) {
		super();
		this.a_id = a_id;
		this.a_password = a_password;
	}

	public AdminLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getA_id() {
		return a_id;
	}

	public void setA_id(String a_id) {
		this.a_id = a_id;
	}

	public String getA_password() {
		return a_password;
	}

	public void setA_password(String a_password) {
		this.a_password = a_password;
	}
	
	
	

}
