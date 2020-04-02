package com.snapbox.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snapbox.bean.Movie;
import com.snapbox.model.dao.MovieDao;
@Service
public class MovieService {
	@Autowired
	private MovieDao movieDao;
	
	 public Movie findByName(String name) {
		return movieDao.findByName(name);
	}

	public List<Movie> findByCategorie(String categorie) {
		return movieDao.findByCategorie(categorie);
	}

	public int save(Movie m) {
      Movie foundedMovie = findByName(m.getName());
      if(foundedMovie != null)
    	  return -1;
      else {
    	  if(m.getPrice()<0 || m.getTrailer()==null || m.getPoster()==null)
    		  return -2;
    	  movieDao.save(m);
    	  return 1;
      }
	}

	public List<Movie> findAll() {
		return movieDao.findAll();
	}

	public List<Movie> getAllMoviesThisNight() {
	       List<Movie> mvs = new ArrayList<Movie>();
		 return mvs;
	    }
}
