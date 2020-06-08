package com.farm.capg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.farm.capg.model.AdminLogin;
import com.farm.capg.model.AdminTips;
import com.farm.capg.services.AdminLoginServiceImpl;
import com.farm.capg.services.AdminTipsServiceImpl;

@Controller
public class FarmController {

	@Autowired
    AdminLoginServiceImpl adminLoginServiceImpl; 
	
	@Autowired
	AdminTipsServiceImpl adminTipsServiceImpl;
	
	@RequestMapping("home")
	public String home() {
		return "index";
	}

	@RequestMapping("userForm")
	public String landingIntoPortal(@ModelAttribute("adminLogin")AdminLogin adminLogin, ModelMap modelMap) { 
		 try {
			 String userid = adminLoginServiceImpl.getAdminById(adminLogin.getaId()).getaId();
			 System.out.println(userid);
			 if(!adminLogin.getaPassword().equals(adminLoginServiceImpl.getAdminById(adminLogin.getaId()).getaPassword())){
				// System.out.println("hello");
				 String msg =  "password is not correct";
				 System.out.println("msg");
				 modelMap.addAttribute("msg", msg);
				 return "adminlogin";
			 } 
			 else {
				 System.out.println("Successfully Login!!!"+userid+" and password:"+adminLogin.getaPassword());
				 return "admindashboard";
				 }
		} catch (Exception e) {
			String msg1 = adminLogin.getaId() + " Does not exist in the db";
			modelMap.addAttribute("msg1", msg1);
			return "adminlogin";
		} 
	}
	
	@RequestMapping("comm")
	public String AddTips2()
	{
		return "admintips";
	}
	
	@RequestMapping("comms")
	public String AddTips(@RequestParam("tips")String tips)
	{
		//System.out.println("***********"+ tips);
		AdminTips ad = new AdminTips();
		ad.setTips(tips);
		adminTipsServiceImpl.saveTips(ad);
		return "admintips";
	}
	
	@RequestMapping("about")
	public String abt() {
		return "aboutus";
	}
}
