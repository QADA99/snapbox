package com.snapbox.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie  implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String cast;
    private String director;
    private String poster;
    private String trailer;
    private String categorie ;
    private double price;
    private String story;

	public Movie() {
		super();
       
	}




	public Movie(Long id, String name, String cast, String director, String poster, String trailer, String categorie,
			double price, String story) {
		super();
		this.id = id;
		this.name = name;
		this.cast = cast;
		this.director = director;
		this.poster = poster;
		this.trailer = trailer;
		this.categorie = categorie;
		this.price = price;
		this.story = story;
	}




	public String getStory() {
		return story;
	}




	public void setStory(String story) {
		this.story = story;
	}




	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCast() {
		return cast;
	}


	public void setCast(String cast) {
		this.cast = cast;
	}


	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}


	public String getPoster() {
		return poster;
	}


	public void setPoster(String poster) {
		this.poster = poster;
	}


	public String getTrailer() {
		return trailer;
	}


	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}


	public String getCategorie() {
		return categorie;
	}


	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", cast=" + cast + ", director=" + director + ", poster=" + poster
				+ ", trailer=" + trailer + ", categorie=" + categorie + ", price=" + price + "]";
	}
	
    
}
