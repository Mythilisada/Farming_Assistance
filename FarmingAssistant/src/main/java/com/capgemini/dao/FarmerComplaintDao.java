package com.capgemini.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.model.FarmerComplaint;

public interface FarmerComplaintDao extends JpaRepository<FarmerComplaint, Integer> {

}
