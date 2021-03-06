package com.snapbox.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snapbox.bean.Reservation;

@Repository
public interface ReservationDao extends JpaRepository<Reservation,Long> {
    List<Reservation> findByNameAndProjectionRef(String name,String ref);
    List<Reservation> findByProjectionRefStartingWith(String ref);
    List<Reservation> findByNameStartingWith(String name);
	List<Reservation> findByProjectionMovieNameStartingWith(String name);
}
