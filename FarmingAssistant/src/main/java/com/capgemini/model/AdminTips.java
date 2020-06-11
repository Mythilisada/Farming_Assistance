package com.capgemini.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AdminTips {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sno;
	private String tips;
	
	public AdminTips() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminTips(int sno, String tips) {
		super();
		this.sno = sno;
		this.tips = tips;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
	
}
