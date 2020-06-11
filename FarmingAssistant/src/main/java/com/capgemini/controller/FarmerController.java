package com.capgemini.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.capgemini.exception.InvalidDetailsException;
import com.capgemini.exception.UserCreationException;
import com.capgemini.model.AdminLogin;
import com.capgemini.model.AdminTips;
import com.capgemini.model.Advertisement;
import com.capgemini.model.Crop;
import com.capgemini.model.FarmerComplaint;
import com.capgemini.model.Response;
import com.capgemini.model.SellCrop;
import com.capgemini.model.Supplier;
import com.capgemini.model.User;
import com.capgemini.service.AdminServ;
import com.capgemini.service.FarmerServ;
import com.capgemini.service.SupplierServ;

@CrossOrigin(origins = "*") 
@RestController
@RequestMapping("/farming")
public class FarmerController {
	
	@Autowired
	FarmerServ farmerServ;
	
	@Autowired
	SupplierServ supplierServ;
	
	@Autowired
	AdminServ adminserv;
	
	

	//Register Farmer
	@PostMapping("/createuser")
	public User createUserAccount(@RequestBody User userReg){
		return farmerServ.createUserAccount(userReg);
	}
	
	//Login Farmer
	@GetMapping("/login/{email}/{password}")
	public User loginByuserEmail(@PathVariable String email, @PathVariable String password, HttpSession session) {
		User lgn=new User();
		lgn.setEmail(email);
		lgn.setPassword(password);
		//addUserInSession( lgn, session);
		return farmerServ.loginByuserEmail(email, password);
	}
	
	//Fetch Products Requirements
	@GetMapping("/viewproductrequirements")
	public List<Advertisement> viewProductRequirements(){
		return farmerServ.viewProductRequirements();
	}
	
	@PutMapping("/forgotpassword/{pan_Id}/{email}/{password}")
	public User forgotPassword(@PathVariable String pan_Id, @PathVariable String email,
			@PathVariable String password) {
		return farmerServ.forgotPassword(pan_Id,email,password);
	}
	
	//Fetch All Users
	@GetMapping("/fetchusers")
	public List<Supplier> viewAllUsers(){
		return farmerServ.viewAllUsers();
	}
	
	
	//sell crop by farmer
	@PostMapping("/farmerSellCrop")
	public SellCrop saveCropByFarmer(@RequestBody SellCrop sellcrop ) {
		return farmerServ.saveCropByFarmer(sellcrop);
	}
	
	@PostMapping("/registerComplaint")
	public FarmerComplaint saveComplaint(@RequestBody FarmerComplaint farmercomplaint)
	{
		return farmerServ.addComplaint(farmercomplaint);
	}
	
	private void addUserInSession(User lgn,HttpSession session)
	{
		session.setAttribute("uname",lgn.getUserName());
		session.setAttribute("pass", lgn.getPassword());
		//session.setAttribute("role", lgn.getFlag());
		
	}
	
	
	@RequestMapping("/logout.htm")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "login";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Supplier Part
	//Supplier Registration
	@PostMapping("/createsupplier")
	public Supplier createSupplierAccount(@RequestBody Supplier supplierReg){
		return supplierServ.supplierRegistration(supplierReg);
	}
	
	//Supplier Login
	@GetMapping("/supplierlogin/{supplier_Email}/{supplier_Password}")
	public Supplier loginBySupplierEmail(@PathVariable String supplier_Email, @PathVariable String supplier_Password,HttpSession session) {
		Supplier lgn=new Supplier();
		lgn.setSupplier_Email(supplier_Email);
		lgn.setSupplier_Password(supplier_Password);
		//addUserInSession(lgn, session);
		return supplierServ.loginBySupplierEmail(supplier_Email, supplier_Password);
	}
	
	//Add Advertisement
	@PostMapping(value="/addPost",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public Advertisement addPost(@RequestParam("file") MultipartFile file, @RequestParam("advtment") String advtment) {
		/*Uploading the document*/
	
	   
	    
	    	Advertisement advertisement=supplierServ.addPost(file, advtment);
	    	if(advertisement!=null)
	    	{
	    		return advertisement;
	    	}
	    	else
	    	{
	    		throw new UserCreationException("Document Not uploaded");
	    	}
	    }
	
	@ExceptionHandler(InvalidDetailsException.class)
	public ResponseEntity<Response> usernotfound1(InvalidDetailsException e)
	{
		return new ResponseEntity<>(new Response(e.getMessage()),HttpStatus.OK);
	}		
		
	//view all crop details
			@GetMapping("/cropDetails")
			public List<SellCrop> viewAllCropDetails(){
				return supplierServ.viewAllCropDetails();
			}
		
	
	
	
/*----------------------------------admin code--------------------------------------------------*/	
	
//Login Farmer
			
	@GetMapping("/adminlogin/{a_id}/{a_password}")
	public AdminLogin adminloginByuserEmail(@PathVariable String a_id, @PathVariable String a_password, HttpSession session) {
		AdminLogin lgn=new AdminLogin();
		lgn.setA_id(a_id);
		lgn.setA_password(a_password);
		//addUserInSession( lgn, session);
		return adminserv.loginByuserID(a_id, a_password);
	}

	@PostMapping("/adminTips")
	public AdminTips saveTips(@RequestBody AdminTips admintips)
	{
		return adminserv.adminSaveTips(admintips) ;
	}
}







