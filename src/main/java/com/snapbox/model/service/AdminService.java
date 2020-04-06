package com.snapbox.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snapbox.bean.admin;
import com.snapbox.model.dao.adminDao;

@Service
public class AdminService {
	@Autowired
   private adminDao adminDao;

	public admin findByLogin(String login) {
		return adminDao.findByLogin(login);
	}
   public void save(admin a) {
	   adminDao.save(a);
   }
	
}
