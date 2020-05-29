package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.model.Crop;
import com.capgemini.model.User;
import com.capgemini.service.FarmerServ;

@CrossOrigin(origins = "*") 
@RestController
@RequestMapping("/farming")
public class FarmerController {
	
	@Autowired
	FarmerServ farmerServ;

	//Register Farmer
	@PostMapping("/createuser")
	public User createUserAccount(@RequestBody User userReg){
		return farmerServ.createUserAccount(userReg);
	}
	
	//Login Farmer
	@GetMapping("/login/{email}/{password}")
	public User loginByuserEmail(@PathVariable String email, @PathVariable String password) {
		return farmerServ.loginByuserEmail(email, password);
	}
	
	//Fetch Products Requirements
	@GetMapping("/viewproductrequirements")
	public List<Crop> viewProductRequirements(){
		return farmerServ.viewProductRequirements();
	}
}
