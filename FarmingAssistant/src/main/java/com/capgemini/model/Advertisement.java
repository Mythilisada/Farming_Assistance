package com.capgemini.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "addPost")
public class Advertisement {

	@Id
	@GeneratedValue
	private int crop_Id;

	@Column
	private String crop_Name;

	@Column
	private String crop_Qty;

	
	@GeneratedValue
	private int docId;

	@Column
	private String docType;

	@Lob
	private byte[] docData;

	public int getCrop_Id() {
		return crop_Id;
	}

	public void setCrop_Id(int crop_Id) {
		this.crop_Id = crop_Id;
	}

	public String getCrop_Name() {
		return crop_Name;
	}

	public void setCrop_Name(String crop_Name) {
		this.crop_Name = crop_Name;
	}

	public String getCrop_Qty() {
		return crop_Qty;
	}

	public void setCrop_Qty(String crop_Qty) {
		this.crop_Qty = crop_Qty;
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public byte[] getDocData() {
		return docData;
	}

	public void setDocData(byte[] docData) {
		this.docData = docData;
	}

	public Advertisement(int crop_Id, String crop_Name, String crop_Qty, int docId, String docType, byte[] docData) {
		super();
		this.crop_Id = crop_Id;
		this.crop_Name = crop_Name;
		this.crop_Qty = crop_Qty;
		this.docId = docId;
		this.docType = docType;
		this.docData = docData;
	}

	public Advertisement() {
		super();
	}

}
