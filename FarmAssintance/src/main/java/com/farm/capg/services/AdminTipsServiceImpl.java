package com.farm.capg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.farm.capg.dao.AdminTipsRepo;
import com.farm.capg.model.AdminTips;

@Service
public class AdminTipsServiceImpl implements AdminTipsService {

	@Autowired
	private AdminTipsRepo adminTipsRepo;
	public AdminTipsRepo getAdminTipsRepo() {
		return adminTipsRepo;
	}
	public void setAdminTipsRepo(AdminTipsRepo adminTipsRepo) {
		this.adminTipsRepo = adminTipsRepo;
	}
	@Override
	public AdminTips getAdminTipsBysno(int sno) {
		// TODO Auto-generated method stub
		return adminTipsRepo.getOne(sno);
	}
	@Override
	public AdminTips saveTips(AdminTips adminTips) {
		// TODO Auto-generated method stub
		return adminTipsRepo.save(adminTips);
	}
	@Override
	public AdminTips delTips(AdminTips adminTips) {
		// TODO Auto-generated method stub
		return null;
	}

}
