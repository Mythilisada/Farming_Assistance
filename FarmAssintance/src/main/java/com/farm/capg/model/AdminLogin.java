package com.farm.capg.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdminLogin {
	@Id
	private String aId;
	private String aPassword;
	public String getaId() {
		return aId;
	}
	public void setaId(String aId) {
		this.aId = aId;
	}
	public String getaPassword() {
		return aPassword;
	}
	public void setaPassword(String aPassword) {
		this.aPassword = aPassword;
	}
	@Override
	public String toString() {
		return "AdminLogin [aId=" + aId + ", aPassword=" + aPassword + "]";
	}
	

}
