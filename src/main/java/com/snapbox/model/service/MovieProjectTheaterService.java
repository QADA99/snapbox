package com.snapbox.model.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snapbox.bean.Movie;
import com.snapbox.bean.MovieProjectTheater;
import com.snapbox.bean.Theatre;
import com.snapbox.model.dao.MovieProjectTheaterDao;

@Service
public class MovieProjectTheaterService  {
    @Autowired
	private MovieService movieService ;
    @Autowired
    private TheatreService theatreService;
    @Autowired
	private MovieProjectTheaterDao projectionDao;
    
	public List<MovieProjectTheater> findByDate(Date d) {
		return projectionDao.findByShowDate(d);
	}
	public List<MovieProjectTheater> findAll() {
		return projectionDao.findAll();
	}
	public MovieProjectTheater findByRef(String ref) {
		return projectionDao.findByRef(ref);
	}
	public int save(MovieProjectTheater p) {
		MovieProjectTheater foundedProjection = findByRef(p.getRef());
		Movie foundedMovie = movieService.findByName(p.getMovie().getName());
		Theatre foundedTheatre = theatreService.findByName(p.getTheater().getName());
		List<MovieProjectTheater> lists = findByDate(new Date());
		if(foundedProjection != null)
		  return -1;
		else if(foundedMovie ==null || foundedTheatre==null )
			return -2;
		else if(lists.size()>=3)
          return -3;
		else {
			
			p.setMovie(foundedMovie);
			p.setTheater(foundedTheatre);
			p.setAvailablePlaces(foundedTheatre.getCapacite());
			projectionDao.save(p);
			return 1;
			
		}
	}
	public List<Movie> getMoviesOfThisNight(){
		List<Movie> mvs =  new ArrayList<Movie>();
		for(MovieProjectTheater p : findByDate(new Date())){
			mvs.add(p.getMovie());
		}
		return mvs;
	}
	public List<MovieProjectTheater> getProjectionOfTheNight(){
		return this.findByDate(new Date());
	}
	
}
