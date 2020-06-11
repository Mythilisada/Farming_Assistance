package com.capgemini.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Supplier")
public class Supplier {
	@Id
	@GeneratedValue
	private int supplier_Id;
	
	@Column
	@NotNull
	private String supplier_Name;
	
	@Column
	@NotNull
	private String supplier_Address;
	
	@Column( unique = true)
	@NotNull
	private String supplier_MobileNumber;
	
	@Column( unique = true)
	@NotNull
	private String supplier_Email;
	
	@Column
	@NotNull
	private String supplier_Password;

	public Supplier(int supplier_Id, @NotNull String supplier_Name, @NotNull String supplier_Address,
			@NotNull String supplier_MobileNumber, @NotNull String supplier_Email, @NotNull String supplier_Password) {
		super();
		this.supplier_Id = supplier_Id;
		this.supplier_Name = supplier_Name;
		this.supplier_Address = supplier_Address;
		this.supplier_MobileNumber = supplier_MobileNumber;
		this.supplier_Email = supplier_Email;
		this.supplier_Password = supplier_Password;
	}

	public Supplier() {
		super();
	}

	public int getSupplier_Id() {
		return supplier_Id;
	}

	public void setSupplier_Id(int supplier_Id) {
		this.supplier_Id = supplier_Id;
	}

	public String getSupplier_Name() {
		return supplier_Name;
	}

	public void setSupplier_Name(String supplier_Name) {
		this.supplier_Name = supplier_Name;
	}

	public String getSupplier_Address() {
		return supplier_Address;
	}

	public void setSupplier_Address(String supplier_Address) {
		this.supplier_Address = supplier_Address;
	}

	public String getSupplier_MobileNumber() {
		return supplier_MobileNumber;
	}

	public void setSupplier_MobileNumber(String supplier_MobileNumber) {
		this.supplier_MobileNumber = supplier_MobileNumber;
	}

	public String getSupplier_Email() {
		return supplier_Email;
	}

	public void setSupplier_Email(String supplier_Email) {
		this.supplier_Email = supplier_Email;
	}

	public String getSupplier_Password() {
		return supplier_Password;
	}

	public void setSupplier_Password(String supplier_Password) {
		this.supplier_Password = supplier_Password;
	}
	
	
	

}
