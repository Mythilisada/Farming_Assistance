package com.farm.capg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.farm.capg.model.AdminTips;

public interface AdminTipsRepo extends JpaRepository<AdminTips,Integer> {
	
}
