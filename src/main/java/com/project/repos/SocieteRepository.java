package com.project.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entities.Societe;



public interface SocieteRepository extends JpaRepository<Societe, Long> {

	Societe findByName(String name);
	//Boolean existsById(Long id);
	Boolean existsByName(String name);
}
