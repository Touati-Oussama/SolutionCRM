package com.project.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "societe")
public class Societe {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}



	public Societe(Long id, String name, List<User> employees) {
		super();
		this.id = id;
		this.name = name;
		//this.employees = employees;
	}

	public Societe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
