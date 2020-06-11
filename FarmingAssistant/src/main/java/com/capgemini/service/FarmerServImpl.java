package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.AdvertisementDao;
import com.capgemini.dao.CropDao;
import com.capgemini.dao.FarmerComplaintDao;
import com.capgemini.dao.FarmerDao;
import com.capgemini.dao.SellCropDao;
import com.capgemini.dao.SupplierDao;
import com.capgemini.exception.UserCreationException;
import com.capgemini.model.AdminLogin;
import com.capgemini.model.Advertisement;
import com.capgemini.model.Crop;
import com.capgemini.model.FarmerComplaint;
import com.capgemini.model.SellCrop;
import com.capgemini.model.Supplier;
import com.capgemini.model.User;
import com.capgemini.util.Decryption;
import com.capgemini.util.Encryption;

@Service
public class FarmerServImpl implements FarmerServ {

	@Autowired
	FarmerDao farmerDao;

	@Autowired
	CropDao cropDao;
	
	@Autowired
	SellCropDao sellcropdao;

	@Autowired
	FarmerComplaintDao complaintdao;
	
	@Autowired
	AdvertisementDao adao;
	
	@Autowired
	SupplierDao supplierDao;
	
	// Farmer Registration
	public User createUserAccount(User userReg) {

		if (userReg == null) {
			throw new UserCreationException("User Account is Not Created. Please fill the required fields");
		} else {
			userReg.setPassword(Encryption.encrypt(userReg.getPassword()));

			farmerDao.save(userReg);
			return userReg;
		}
	}

	// Farmer Login
	public User loginByuserEmail(String email, String password) {

		User user = farmerDao.loginByuserEmail(email, password);
		String user_Mail = user.getEmail();
		String user_passwd = (Decryption.decrypt(user.getPassword()));
		System.out.println(email + " " + password);
		System.out.println(user_Mail + " " + user_passwd);
		if (user_Mail.equals(email) && user_passwd.equals(password)) {
			System.out.println("Login Successfully");
			return user;
		} else {
			return null;
		}
	}

	// View Products Requirements
	public List<Advertisement> viewProductRequirements() {
		return adao.findAll();
	}

	// Fetch All Users
	public List<Supplier> viewAllUsers() {
		List<Supplier> supplier = supplierDao.findAll();
//		for (Supplier u : users) {
//			u.setPassword(Decryption.decrypt(u.getPassword()));
//		}
		return supplier;
	}

	@Override
	public User forgotPassword(String pan_Id, String email, String password) {
		
		System.out.println("Sammu");
		User user= farmerDao.forgotPassword(pan_Id, email, password);
		
		System.out.println(pan_Id + user.getPan_Id()+ email+user.getEmail()+ password +user.getPassword());
		
		if(user.getEmail().equals(email) && user.getPan_Id().equals(pan_Id) ) {
			
			user.setPassword(Encryption.encrypt(password));
			farmerDao.save(user);
		}
		else {
			throw new UserCreationException("Enter the valid credentials");
		}
		
	
		return user;
	}

	//Sell crop by farmer.
	@Override
	public SellCrop saveCropByFarmer(SellCrop sellcrop) {
		
		return sellcropdao.save(sellcrop);
	}

	@Override
	public FarmerComplaint addComplaint(FarmerComplaint farmercomplaint) {
		
		return complaintdao.save(farmercomplaint);
	}

	

	
	}


