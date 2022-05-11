package com.professeur.oumaima.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.professeur.oumaima.entities.Professeur;
import com.professeur.oumaima.service.ProfesseurService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProfesseurRestController {
	
	@Autowired
	ProfesseurService profService;
	@RequestMapping(method = RequestMethod.GET)
	
	public List<Professeur> getAllProfesseurs() {
	return profService.getAllProfesseurs();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Professeur getProfesseurById(@PathVariable("id") Long id) {
	return profService.getProfesseur(id);
	 }
	
	@RequestMapping(method = RequestMethod.POST)
	public Professeur createProfesseur(@RequestBody Professeur professeur) {
	return profService.saveProfesseur(professeur);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Professeur updateProf(@RequestBody Professeur prof) {
	return profService.updateProfesseur(prof);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteProfesseur(@PathVariable("id") Long id)
	{
	profService.deleteProfesseurById(id);
	}
	
	@RequestMapping(value="/prodscat/{idCat}",method = RequestMethod.GET)
	public List<Professeur> getProfesseursByCatId(@PathVariable("idCat") Long idCat) {
	return profService.findByGradeIdCat(idCat);
	}

}
