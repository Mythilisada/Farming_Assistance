package com.capgemini.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.model.Crop;

@Repository
public interface CropDao extends JpaRepository<Crop, Integer>{

}
