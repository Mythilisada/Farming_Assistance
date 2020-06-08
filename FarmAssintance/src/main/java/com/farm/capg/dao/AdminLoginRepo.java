package com.farm.capg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.farm.capg.model.AdminLogin;

public interface AdminLoginRepo extends JpaRepository<AdminLogin, String> {

}
