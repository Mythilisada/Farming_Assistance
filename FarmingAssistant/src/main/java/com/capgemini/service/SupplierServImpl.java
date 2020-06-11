package com.capgemini.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.capgemini.dao.AdvertisementDao;
import com.capgemini.dao.CropDao;
import com.capgemini.dao.SellCropDao;
import com.capgemini.dao.SupplierDao;
import com.capgemini.exception.UserCreationException;
import com.capgemini.model.Advertisement;
import com.capgemini.model.Crop;
import com.capgemini.model.SellCrop;
import com.capgemini.model.Supplier;
import com.capgemini.util.Decryption;
import com.capgemini.util.Encryption;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SupplierServImpl implements SupplierServ{
	
	@Autowired
	SupplierDao supplierDao;
	
	@Autowired
	AdvertisementDao advertisementDao;
	
	@Autowired
	CropDao cropDao;
	
	@Autowired
	SellCropDao sellCropDao;

	//Supplier Registration
	public Supplier supplierRegistration(Supplier supplierReg) {
		if (supplierReg == null) {
			throw new UserCreationException("Supplier Account is Not Created. Please fill the required fields");
		} else {
			supplierReg.setSupplier_Password(Encryption.encrypt(supplierReg.getSupplier_Password()));
			supplierDao.save(supplierReg);
			return supplierReg;
		}
	}

	//Supplier Login
	public Supplier loginBySupplierEmail(String supplier_Email, String supplier_Password) {
		Supplier supplier = supplierDao.loginBySupplierEmail(supplier_Email, supplier_Password);
		String supplier_Mail =supplier.getSupplier_Email();
		String supplier_passwd = (Decryption.decrypt(supplier.getSupplier_Password()));
		System.out.println(supplier_Email + " " + supplier_Password);
		System.out.println(supplier_Mail + " " + supplier_passwd);
		if (supplier_Mail.equals(supplier_Email) && supplier_passwd.equals(supplier_Password)) {
			System.out.println("Login Successfully");
			return supplier;
		} else {
			return null;
		}
	}

	
	//Add Advertisement
	public Advertisement addPost(MultipartFile file, String advtment) {
		Advertisement advertisement=new Advertisement();
		try {
			advertisement = new ObjectMapper().readValue(advtment, Advertisement.class);
		} catch (JsonMappingException e) {
					e.printStackTrace();
		} catch (JsonProcessingException e) {
				e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			advertisement.setDocData(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		advertisement.setDocType(file.getOriginalFilename());  	
		 advertisementDao.save(advertisement);
		return advertisement;
	}

	@Override
	public List<SellCrop> viewAllCropDetails() {
		 List<SellCrop> cropDetails=sellCropDao.findAll();
		return cropDetails;
	}
	
	
	

}
