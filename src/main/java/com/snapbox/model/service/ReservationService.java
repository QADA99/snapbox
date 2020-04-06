package com.snapbox.model.service;

import java.util.Iterator;
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
    
    public List<Reservation> findAll() {
		return reservationDao.findAll();
	}
	@Autowired
    private MovieProjectTheaterService projectionService;
    
	public List<Reservation> findByNameAndShowRef(String name, String ref) {
		return reservationDao.findByNameAndProjectionRef(name, ref);
	}
	public List<Reservation> findByMovie(String name) {
		return reservationDao.findByProjectionMovieNameStartingWith(name);
	}
	
	public List<Reservation> findByShowRef(String ref) {
		return reservationDao.findByProjectionRefStartingWith(ref);
	}
	public List<Reservation> findByName(String name) {
		return reservationDao.findByNameStartingWith(name);
	}
	
	public  int save(Reservation r){
		MovieProjectTheater foundedProjection = projectionService.findByRef(r.getProjection().getRef());
		if(foundedProjection==null)
          return -1;
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
	 
	public double sales(String name){
		double s = 0;
		List<Reservation> lists = findByMovie(name);
		for(Reservation r :lists) {
		 s += r.getPrice();
		}
		return s;
	}
	
    
    
}
