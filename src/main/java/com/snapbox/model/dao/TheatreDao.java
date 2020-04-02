package com.snapbox.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snapbox.bean.Theatre;

@Repository
public interface TheatreDao extends JpaRepository<Theatre,Long>{
   Theatre findByName(String Name);
 
}
