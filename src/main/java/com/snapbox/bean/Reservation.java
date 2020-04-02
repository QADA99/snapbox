package com.snapbox.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reservation implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@ManyToOne
	private MovieProjectTheater projection;
	
	private String name;
	private String type;
	private double price;
	
	public Reservation(Long id, MovieProjectTheater projection, String name, String type, double price) {
		super();
		this.id = id;
		this.projection = projection;
		this.name = name;
		this.type = type;
		this.price = price;
	}
	public Reservation() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public MovieProjectTheater getProjection() {
		return projection;
	}
	public void setProjection(MovieProjectTheater projection) {
		this.projection = projection;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", projection=" + projection + ", name=" + name + ", type=" + type + ", price="
				+ price + "]";
	}
	
	
}
