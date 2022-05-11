package com.professeur.oumaima.controllers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.professeur.oumaima.entities.Grade;
import com.professeur.oumaima.entities.Professeur;
import com.professeur.oumaima.service.GradeService;
import com.professeur.oumaima.service.ProfesseurService;



@Controller
public class ProfesseurController {
	
	
	    @Autowired
	    ProfesseurService profService;
	    @Autowired
	    GradeService gradeService;
	    @RequestMapping("/showCreate")
	    public String showCreate(ModelMap modelMap)
	    {
	    Professeur prod = new Professeur();	
	    List<Grade> grades = gradeService.getAllGrades();
	    Grade grade = new Grade();
	    grade = grades.get(0); // prendre la première catégorie de la liste
	    prod.setGrade(grade); //affedter une catégorie par défaut au produit pour éviter le pb avec une catégorie null
	    modelMap.addAttribute("professeur", new Professeur());
	    modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("grades", grades);
	    return "formProf";
	    }

	    
	    @RequestMapping("/saveProfesseur")
	    public String saveProduit(@Valid Professeur prof,BindingResult bindingResult)
	    {
	    if (bindingResult.hasErrors()) return "formProf";
	     
	    profService.saveProfesseur(prof);
		return "redirect:/ListeProfesseurs";
	    }
	    
	    
	   /* @RequestMapping("/ListeProfesseurs")
	    public String listeProduits(ModelMap modelMap,
	    		@RequestParam (name="page",defaultValue = "0") int page,
	    		@RequestParam (name="size", defaultValue = "2") int size)
	    {
	    	Page<Professeur> profs = profService.getAllProfesseursParPage(page, size);
	    	modelMap.addAttribute("professeurs", profs);
	    	 modelMap.addAttribute("pages", new int[profs.getTotalPages()]);
	    	modelMap.addAttribute("currentPage", page);
	    	return "listeProfesseur";
	    }*/
	    @RequestMapping("/supprimerProf")
	    public String supprimerProf(@RequestParam("id") Long id,
	    		ModelMap modelMap,
	    		@RequestParam (name="page",defaultValue = "0") int page,
	    		@RequestParam (name="size", defaultValue = "2") int size)
	    {
	        profService.deleteProfesseurById(id);
	        Page<Professeur> profs = profService.getAllProfesseursParPage(page, 
	        		size);
	        		modelMap.addAttribute("professeurs", profs);
	        		modelMap.addAttribute("pages", new int[profs.getTotalPages()]);
	        		modelMap.addAttribute("currentPage", page);
	        		modelMap.addAttribute("size", size);
	        		return "redirect:/ListeProfesseurs";
	    }
	    
	    
	    @RequestMapping("/modifierProf")
	    public String editerProf(@RequestParam("id") Long id,ModelMap modelMap)
	    {
	    Professeur p= profService.getProfesseur(id);
	    modelMap.addAttribute("professeur", p);
	    modelMap.addAttribute("mode", "edit");
	    List<Grade> grades = gradeService.getAllGrades();
		modelMap.addAttribute("grades", grades);
	    return "formProf";
	    }

	    
	    @RequestMapping("/updateProf")
	    public String updateProf(@ModelAttribute("professeur") Professeur professeur,
	                                @RequestParam("date") String date,
	                                ModelMap modelMap) throws ParseException
	    {
	//conversion de la date
	        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	        Date dateCreation = dateformat.parse(String.valueOf(date));
	        professeur.setDateDeNaissance(dateCreation);

	        profService.updateProfesseur(professeur);
	        List<Professeur> profs = profService.getAllProfesseurs();
	        modelMap.addAttribute("professeurs", profs);
	        return "listeProfesseur";
	    }
	    
	    
	    @RequestMapping("/ListeProfesseurs")
	    public String findProfesseur(ModelMap modelMap,
	    		@RequestParam (name="page",defaultValue = "0") int page,
	    		@RequestParam (name="size", defaultValue = "2") int size)
	    {      
	    	 List<Grade> grades = gradeService.getAllGrades();
	    	 Professeur prof = new Professeur();
	    	 Grade grade = new Grade();
	    	 grade=grades.get(1);;
	    	 prof.setGrade(grade);
	    	 modelMap.addAttribute("Professeur",prof);
	    	 modelMap.addAttribute("grade",grade);
	    	 Page<Professeur> profs = profService.getAllProfesseursParPage(page, size);
		     modelMap.addAttribute("professeurs", profs);
		     modelMap.addAttribute("pages", new int[profs.getTotalPages()]);
		     modelMap.addAttribute("currentPage", page);
		    return "listeProfesseur";
	    	
	    }
	    
	    @RequestMapping("/chercherNom")
	    public String chercherProfesseur(@RequestParam("nomProf")String nom,ModelMap modelMap)
	    {     
	    	  List <Professeur> profs= profService.findByNomProfesseur(nom);
	    	
	    	  modelMap.addAttribute("Professeurs",profs);
	    	  return "resultatRecherche";
	    	  
	    	  
	    }

	}


	    

