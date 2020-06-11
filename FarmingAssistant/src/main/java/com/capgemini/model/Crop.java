package com.capgemini.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Crops")
public class Crop {
	
	@Id
	@GeneratedValue
	@Column(length=11)
	private int crop_Id;
	
	@Column(length=45)
	@NotNull
	private String crop_Name;
	
	@Column(length=45)
	@NotNull
	private String crop_Details;
	
	@Column(length=45)
	@NotNull
	private String crop_Price;
	
	@Column(length=45)
	@NotNull
	private String crop_Qty;
	
	@Column(length=11)
	@NotNull
	private int farmer_Id;
	
	@Column(length=11)
	@NotNull
	private int Supplier_Id;
	
	@Column(length=6)
	//@NotNull
	private String flag;
	
	
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
	
	public String getCrop_Details() {
		return crop_Details;
	}
	public void setCrop_Details(String crop_Details) {
		this.crop_Details = crop_Details;
	}
	
	public String getCrop_Price() {
		return crop_Price;
	}
	public void setCrop_Price(String crop_Price) {
		this.crop_Price = crop_Price;
	}
	
	public String getCrop_Qty() {
		return crop_Qty;
	}
	public void setCrop_Qty(String crop_Qty) {
		this.crop_Qty = crop_Qty;
	}
	
	public int getFarmer_Id() {
		return farmer_Id;
	}
	public void setFarmer_Id(int farmer_Id) {
		this.farmer_Id = farmer_Id;
	}
	
	public int getSupplier_Id() {
		return Supplier_Id;
	}
	public void setSupplier_Id(int supplier_Id) {
		Supplier_Id = supplier_Id;
	}
	
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
	public Crop(int crop_Id, String crop_Name, String crop_Details, String crop_Price, String crop_Qty, int farmer_Id,
			int supplier_Id, String flag) {
		super();
		this.crop_Id = crop_Id;
		this.crop_Name = crop_Name;
		this.crop_Details = crop_Details;
		this.crop_Price = crop_Price;
		this.crop_Qty = crop_Qty;
		this.farmer_Id = farmer_Id;
		Supplier_Id = supplier_Id;
		this.flag = flag;
	}
	
	
	public Crop() {
		super();
	}
	
	
	

}
