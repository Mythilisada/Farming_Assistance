package com.capgemini.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Users")
public class User {

	@Id
	@GeneratedValue
	@Column(length = 10)
	private int user_Id;

	@Column(length = 50)
	@NotNull
	private String userName; // 50

	@Column(length = 30, unique = true)
	@NotNull
	private String pan_Id; // 30

	@Column(length = 30, unique = true)
	@NotNull
	private String aadhar_Id; // 30

	@Column(length = 15, unique = true)
	@NotNull
	private String contact_No; // 15

	@Column(length = 45, unique = true)
	@NotNull
	private String email; // 45

	@Column(length = 45)
	@NotNull
	private String password; // 45

	@Column(length = 45)
	// @NotNull
	private String flag; // 45

	public int getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPan_Id() {
		return pan_Id;
	}

	public void setPan_Id(String pan_Id) {
		this.pan_Id = pan_Id;
	}

	public String getAadhar_Id() {
		return aadhar_Id;
	}

	public void setAadhar_Id(String aadhar_Id) {
		this.aadhar_Id = aadhar_Id;
	}

	public String getContact_No() {
		return contact_No;
	}

	public void setContact_No(String contact_No) {
		this.contact_No = contact_No;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	

	public User(int user_Id, @NotNull String userName, @NotNull String pan_Id, @NotNull String aadhar_Id,
			@NotNull String contact_No, @NotNull String email, @NotNull String password, String flag) {
		super();
		this.user_Id = user_Id;
		this.userName = userName;
		this.pan_Id = pan_Id;
		this.aadhar_Id = aadhar_Id;
		this.contact_No = contact_No;
		this.email = email;
		this.password = password;
		this.flag = flag;
	}

	public User() {
		super();
	}

}
