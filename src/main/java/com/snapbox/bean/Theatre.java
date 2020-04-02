package com.snapbox.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Theatre  implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int capacite;
	public Theatre(Long id, String name, int capacite) {
		super();
		this.id = id;
		this.name = name;
		this.capacite = capacite;
	}
	public Theatre() {
		super();
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
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	@Override
	public String toString() {
		return "Theatre [id=" + id + ", name=" + name + ", capacite=" + capacite + "]";
	}
	
 
}
