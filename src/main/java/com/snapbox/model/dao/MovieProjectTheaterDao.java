package com.snapbox.model.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snapbox.bean.MovieProjectTheater;

@Repository
public interface MovieProjectTheaterDao extends JpaRepository<MovieProjectTheater, Long>{
	List<MovieProjectTheater> findByShowDate(Date d);
	MovieProjectTheater findByRef(String ref);
}
