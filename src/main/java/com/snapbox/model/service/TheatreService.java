package com.snapbox.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snapbox.bean.Theatre;
import com.snapbox.model.dao.TheatreDao;

@Service
public class TheatreService {
     @Autowired
	 private TheatreDao theatreDao;

	public Theatre findByName(String Name) {
		return theatreDao.findByName(Name);
	}

	public int save(Theatre t) {
		Theatre fondedTheater = findByName(t.getName());
		if(fondedTheater!=null)
			return -1;
		else if(t.getCapacite()<0)
			return -2;
		else {
		 theatreDao.save(t);
		 return 1;
		}
	}

	public List<Theatre> findAll() {
		return theatreDao.findAll();
	}
	 
}
