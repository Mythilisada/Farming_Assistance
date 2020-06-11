package com.capgemini.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.model.Supplier;
import com.capgemini.model.User;

@Repository
public interface SupplierDao extends JpaRepository<Supplier, Integer>{
	//login
			@Query("from Supplier where supplier_Email=?1")
			public Supplier loginBySupplierEmail(String supplier_Email,String supplier_Password);

}
