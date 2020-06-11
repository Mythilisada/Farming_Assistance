package com.capgemini.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.model.AdminTips;

public interface AdminTipsDao extends JpaRepository<AdminTips, Integer> {

}
