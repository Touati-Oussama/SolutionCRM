package com.project.services;

import java.util.List;

import com.project.entities.Etat;
import com.project.entities.Reclamation;
import com.project.entities.TypeReclamation;
import com.project.request.ReclamationModel;
import com.project.response.ReclamationDTO;
import com.project.response.ReclamationDetails;
import com.project.response.ReclamationDetailsDev;
import com.project.response.ReclamationDetailsType;
import com.project.response.TestProjet;



public interface ReclamationService {

	List<ReclamationDTO> findByProjetId(Long id);
	List<ReclamationDTO> findByTypeId(Long id);
	List<ReclamationDTO> findByClient(String username);
	List<ReclamationDTO> findByEtat(String etat);
	List<ReclamationDTO> findByDeveloppeurAndEtat(String username,String etat);
	List<ReclamationDTO> findBySocieteAndEtat(String societe, String etat);
	List<ReclamationDTO> findByFilterAndEtat(String keyword,String etat);
	List<ReclamationDTO> findByFilter(String keyword);
	List<ReclamationDTO> findByStatusList(/*String etat1,String etat2*/);
	List<ReclamationDTO> findByDeveloppeur(String username);
	List<ReclamationDTO> findAll();
	List<ReclamationDTO> findBySociete(String name);
	Boolean existsByProjet(Long p);
	Boolean existsByType(Long type_id);
	Boolean existsByDeveloppeurId(Long id);
	Boolean existsByCustomer(Long id);
	ReclamationDTO getReclamation(Long id);
	Reclamation findById(Long id);
	Reclamation add(ReclamationModel reclamation);
	Reclamation update(Reclamation reclamation);
	void deleteReclamation(Reclamation type);
	void deleteReclamation(Long id);
	ReclamationDetails getDétailsByUser(String username);
	ReclamationDetails getDétailsByEtat();
	List<TestProjet> totalByProjet();
	List<TestProjet> totalByProjetAndEtat(String etat);
	List<ReclamationDetailsType> totalByType();
	List<ReclamationDetailsType> totalByTypeAndEtat(String etat);
	List<ReclamationDetailsDev> totalByDeveloppeurs();
	List<ReclamationDetailsDev>
	totalByDeveloppeursAndEtat(String etat);
}
