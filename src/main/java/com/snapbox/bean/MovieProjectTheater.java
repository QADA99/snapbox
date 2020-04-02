package com.snapbox.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class MovieProjectTheater implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private String ref;
	
	
	@ManyToOne
	private Movie movie;
    
	@ManyToOne
	private Theatre theater;
	
	@Temporal(TemporalType.DATE)
	private Date showDate;
	
	private int tartib;
	
    private int availablePlaces;
	
	public int getAvailablePlaces() {
		return availablePlaces;
	}

	public void setAvailablePlaces(int availablePlaces) {
		this.availablePlaces = availablePlaces;
	}

	public MovieProjectTheater(Long id, String ref, Date date, int order, Movie movie, Theatre theater,int availablePlaces) {
		super();
		this.id = id;
		this.ref = ref;
		this.showDate = date;
		this.tartib = order;
		this.movie = movie;
		this.theater = theater;
		this.availablePlaces= availablePlaces;
	}

	public MovieProjectTheater() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public Date getShowDate() {
		return showDate;
	}

	public void setDate(Date date) {
		this.showDate = date;
	}

	public int getTartib() {
		return tartib;
	}

	public void setTatib(int t) {
		this.tartib = t;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Theatre getTheater() {
		return theater;
	}

	public void setTheater(Theatre theater) {
		this.theater = theater;
	}

	@Override
	public String toString() {
		return "MovieProjectTheater [id=" + id + ", ref=" + ref + ", movie=" + movie + ", theater=" + theater
				+ ", showDate=" + showDate + ", tartib=" + tartib + "]";
	}
    
	
	
}
