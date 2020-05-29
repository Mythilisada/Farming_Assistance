package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.CropDao;
import com.capgemini.dao.FarmerDao;
import com.capgemini.exception.UserCreationException;
import com.capgemini.model.Crop;
import com.capgemini.model.User;
import com.capgemini.util.Decryption;
import com.capgemini.util.Encryption;

@Service
public class FarmerServImpl implements FarmerServ {
	
	@Autowired
	FarmerDao farmerDao;
	
	@Autowired
	CropDao cropDao;
	

	
	//Farmer Registration
	
	@Override
	public User createUserAccount(User userReg) {
		

		if (userReg == null) {
			throw new UserCreationException("User Account is Not Created. Please fill the required fields");
		} else {
			userReg.setPassword(Encryption.encrypt(userReg.getPassword()));
			
			farmerDao.save(userReg);
			return userReg;
		}
	}
	
	
	//Farmer Login
public User loginByuserEmail(String email, String password) {
		
		User user = farmerDao.loginByuserEmail(email, password);
		String user_Mail = user.getEmail();
		String user_passwd = (Decryption.decrypt(user.getPassword()));
		System.out.println(email+" "+password);
		System.out.println(user_Mail+" "+user_passwd);
		if (user_Mail.equals(email) && user_passwd.equals(password)) {
			System.out.println("Login Successfully");
			return user;
		} else {
			return null;
		}
	}

//View Products Requirements
public List<Crop> viewProductRequirements() {
	return cropDao.findAll();
}

}
