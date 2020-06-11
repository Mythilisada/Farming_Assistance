package com.capgemini.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.model.Advertisement;
import com.capgemini.model.Crop;
import com.capgemini.model.FarmerComplaint;
import com.capgemini.model.SellCrop;
import com.capgemini.model.Supplier;
import com.capgemini.model.User;
@Service
public interface FarmerServ {
	

	        //Farmer Registration
			public User createUserAccount(User userReg);
			
			//Farmer Login
			public User loginByuserEmail(String email, String password);
			
			//Viewing Product Requirements
			public List<Advertisement> viewProductRequirements();
			
			//View All Users
			public List<Supplier> viewAllUsers();
			
			//Forgot Password
			public User forgotPassword(String pan_Id, String email, String password);
			
			//Sell crop by Farmer
			public SellCrop saveCropByFarmer(SellCrop sellcrop);
			
			// Add complaint by farmer
			public FarmerComplaint addComplaint(FarmerComplaint farmercomplaint);
			
			
}
