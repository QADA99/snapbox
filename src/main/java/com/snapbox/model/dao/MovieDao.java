package com.snapbox.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snapbox.bean.Movie;

@Repository
public interface MovieDao extends JpaRepository<Movie,Long> {
  Movie findByName(String name);
  List<Movie> findByCategorie(String categorie);
}
