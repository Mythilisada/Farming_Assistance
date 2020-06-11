package com.capgemini.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "farmer_complaint")
public class FarmerComplaint {

	@Id
	@GeneratedValue
	@Column(length=11)
	private int comp_id;
	
	@Column(length=255)
	private String complaint;

	public FarmerComplaint() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FarmerComplaint(int comp_id, String complaint) {
		super();
		this.comp_id = comp_id;
		this.complaint = complaint;
	}

	public int getComp_id() {
		return comp_id;
	}

	public void setComp_id(int comp_id) {
		this.comp_id = comp_id;
	}

	public String getComplaint() {
		return complaint;
	}

	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}
	
	
}
