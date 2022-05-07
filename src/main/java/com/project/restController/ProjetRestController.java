package com.project.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.entities.Projet;
import com.project.request.ProjetModel;
import com.project.response.JSONResponse;
import com.project.services.ProjetService;
import com.project.services.ReclamationService;
import com.project.services.SocieteService;
import com.project.services.SpecialiteService;
import com.project.services.UserService;



@RestController
@CrossOrigin(origins="*")
@RequestMapping("/projet")
public class ProjetRestController {

	@Autowired
	private ProjetService projetService;
	@Autowired
	UserService userService;
	@Autowired 
	SpecialiteService specialiteService;
	
	@Autowired
	SocieteService societeService;
	
	
	@Autowired
	ReclamationService reclamationService;
	
	@RequestMapping(path="all",method = RequestMethod.GET)
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(projetService.findAll());
	}
	@RequestMapping(path="all/societe/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> getAll(@PathVariable("id") Long id){
		return ResponseEntity.ok(projetService.findBySocieteId(id));
	}
	
	@RequestMapping(path="/societe/{societe}",method = RequestMethod.GET)
	public ResponseEntity<?> getAllBySocieteName(@PathVariable("societe") String societe){
		return ResponseEntity.ok(projetService.findBySocieteName(societe));
	}
	
	@RequestMapping(path="/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> getProjet(@PathVariable("id") Long id){
		return ResponseEntity.ok(projetService.getProjet(id));
	}
	
	@RequestMapping(path="get/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> findProjetById(@PathVariable("id") Long id){
		return ResponseEntity.ok(projetService.findProjetById(id));
	}
	@RequestMapping(path="add",method = RequestMethod.POST)
	public ResponseEntity<?>add(@RequestBody ProjetModel projet){
		Boolean res = projetService.existsByDesignation(projet.getDesignation());
		if (res)
		{
			return ResponseEntity
					.badRequest()
					.body(new JSONResponse("Cann not add this project.It's already exist !"));
		}
		
		Projet p = new Projet();
		p.setDesignation(projet.getDesignation());
		p.setDescription(projet.getDescription());
		p.setSociete(societeService.getSociete(projet.getSociete()));
		p.setSpecialite( specialiteService.getSpecialite(projet.getSpecialite()));
		return ResponseEntity.ok(projetService.add(p));
	}
	
	@RequestMapping(path="update/{id}",method = RequestMethod.POST)
	public ResponseEntity<?>update(@RequestBody ProjetModel projet,@PathVariable("id") Long id){
		Boolean res = reclamationService.existsByProjet(id);
		if (res)
		{
			return ResponseEntity
					.badRequest()
					.body(new JSONResponse("Cann not update this project.It contain complaints !"));
		}
		Projet p = projetService.getProjet(id);
		p.setDesignation(projet.getDesignation());
		p.setDescription(projet.getDescription());
		p.setSociete(societeService.getSociete(projet.getSociete()));
		p.setSpecialite( specialiteService.getSpecialite(projet.getSpecialite()));
		return ResponseEntity.ok(projetService.add(p));
	}
	
	
	@RequestMapping(path="delete/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<?>delete(@PathVariable("id")Long id){
		Boolean res = reclamationService.existsByProjet(id);
		if (res)
		{
			return ResponseEntity
					.badRequest()
					.body(new JSONResponse("Cann not delete this project.It contain complaints !"));
		}
		projetService.deleteProjet(id);
		JSONResponse response = new JSONResponse("Projet Supprimé !");
		return ResponseEntity.ok(response);
	}
}
