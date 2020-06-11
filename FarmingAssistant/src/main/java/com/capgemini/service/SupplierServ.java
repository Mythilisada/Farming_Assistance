package com.capgemini.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.capgemini.model.Advertisement;
import com.capgemini.model.Crop;
import com.capgemini.model.SellCrop;
import com.capgemini.model.Supplier;

@Service
public interface SupplierServ {
	
	//Supplier Registration
	public Supplier supplierRegistration(Supplier supplierReg);
	
	//Supplier Login
	public Supplier loginBySupplierEmail(String supplier_Email,String supplier_Password);
	
	//Add Advertisement
	public Advertisement addPost(MultipartFile file, String advtment);
	
	// View All Crops Details
		public List<SellCrop> viewAllCropDetails();

}
