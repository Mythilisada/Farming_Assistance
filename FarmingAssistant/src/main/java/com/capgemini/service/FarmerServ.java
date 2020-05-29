package com.capgemini.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.model.Crop;
import com.capgemini.model.User;
@Service
public interface FarmerServ {
	

	        //Farmer Registration
			public User createUserAccount(User userReg);
			
			//Farmer Login
			public User loginByuserEmail(String email, String password);
			
			//Viewing Product Requirements
			public List<Crop> viewProductRequirements();
			
			//View All Users
//			public List<User> viewAllUsers();
}
