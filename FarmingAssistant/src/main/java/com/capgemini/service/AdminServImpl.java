package com.capgemini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.AdminDao;
import com.capgemini.dao.AdminTipsDao;
import com.capgemini.model.AdminLogin;
import com.capgemini.model.AdminTips;

@Service
public class AdminServImpl implements AdminServ {

	@Autowired
	AdminDao admindao;
	
	@Autowired
	AdminTipsDao admintipsdao;
	
	@Override
	public AdminLogin loginByuserID(String a_id, String a_password) {
		AdminLogin user = admindao.loginByaID(a_id, a_password);
		String user_Mail = user.getA_id();
		String user_passwd = user.getA_password();
		System.out.println(a_id + " " + a_password);
		System.out.println(user_Mail + " " + user_passwd);
		if (user_Mail.equals(a_id) && user_passwd.equals(a_password)) {
			System.out.println("Admin Login Successfully");
			return user;
		} else {
			return null;
		}
	}

	@Override
	public AdminTips adminSaveTips(AdminTips admintips) {
		
		return admintipsdao.save(admintips) ;
	}

}
