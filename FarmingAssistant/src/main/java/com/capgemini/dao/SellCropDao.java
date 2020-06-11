package com.capgemini.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.model.SellCrop;

public interface SellCropDao extends JpaRepository<SellCrop	, Integer> {

}
