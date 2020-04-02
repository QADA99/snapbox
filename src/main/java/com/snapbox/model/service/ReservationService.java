package com.snapbox.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snapbox.bean.MovieProjectTheater;
import com.snapbox.bean.Reservation;
import com.snapbox.model.dao.ReservationDao;

@Service
public class ReservationService {
    @Autowired
	private ReservationDao reservationDao;
    @Autowired
    private MovieProjectTheaterService projectionService;
    
	public List<Reservation> findByNameAndShowRef(String name, String ref) {
		return reservationDao.findByNameAndProjectionRef(name, ref);
	}
	public List<Reservation> findByShowRef(String ref) {
		return reservationDao.findByProjectionRef(ref);
	}
	public List<Reservation> findByName(String name) {
		return reservationDao.findByName(name);
	}
	public  int save(Reservation r){
		MovieProjectTheater foundedProjection = projectionService.findByRef(r.getProjection().getRef());
		if(foundedProjection==null)
          return -1;
		else if(foundedProjection.getAvailablePlaces()+1>foundedProjection.getTheater().getCapacite())
			return -2;
		else {
		foundedProjection.setAvailablePlaces(foundedProjection.getAvailablePlaces()+1);
		 r.setProjection(foundedProjection);
		 reservationDao.save(r);
		 return 1;
		 }
		
	}
	public int saveAll(Reservation rs,int n) {
		  for (int i = 0; i < n; i++) {
			if(save(rs)!=1)
				return -2;
		  }
		return 1;
	}
	
    
    
}
