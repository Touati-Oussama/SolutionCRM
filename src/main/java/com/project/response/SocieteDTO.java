package com.project.response;

public class SocieteDTO {

	private Long id;
	private String name;
	private int nbEmpl;
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
	public int getNbEmpl() {
		return nbEmpl;
	}
	public void setNbEmpl(int nbEmpl) {
		this.nbEmpl = nbEmpl;
	}
	@Override
	public String toString() {
		return "SocieteDTO [id=" + id + ", name=" + name + ", nbEmpl=" + nbEmpl + "]";
	}
	public SocieteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
