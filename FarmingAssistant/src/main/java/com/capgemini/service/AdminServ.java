package com.capgemini.service;



import org.springframework.stereotype.Service;

import com.capgemini.model.AdminLogin;
import com.capgemini.model.AdminTips;

@Service
public interface AdminServ {
	
	//admin login
	public AdminLogin loginByuserID(String a_id, String a_password);
	
	//Admin add tips
	public AdminTips adminSaveTips(AdminTips admintips);
}
