package com.capgemini.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.model.AdminLogin;


@Repository
public interface AdminDao extends JpaRepository<AdminLogin	, String> {

	@Query("from AdminLogin where a_id=?1")
	public AdminLogin loginByaID(String a_id,String a_password);
}
