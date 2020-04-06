package com.snapbox.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snapbox.bean.admin;

@Repository
public interface adminDao extends JpaRepository<admin,Long>{
	admin findByLogin(String login);

}
