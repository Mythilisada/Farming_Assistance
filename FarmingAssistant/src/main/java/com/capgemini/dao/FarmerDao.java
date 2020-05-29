package com.capgemini.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.model.User;
@Repository
public interface FarmerDao extends JpaRepository<User, Integer>{
	//login
		@Query("from User where email=?1")
		public User loginByuserEmail(String email,String password);

}
