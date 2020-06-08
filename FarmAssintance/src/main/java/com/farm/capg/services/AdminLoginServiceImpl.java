package com.farm.capg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farm.capg.dao.AdminLoginRepo;
import com.farm.capg.model.AdminLogin;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {
	@Autowired
	private AdminLoginRepo adminloginRepo;
	@Override
	public AdminLogin getAdminById(String aId) {
		return adminloginRepo.getOne(aId);
	}

}
