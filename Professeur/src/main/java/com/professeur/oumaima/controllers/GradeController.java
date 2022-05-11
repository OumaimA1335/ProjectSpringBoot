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

import com.professeur.oumaima.service.GradeService;
import com.professeur.oumaima.service.ProfesseurService;
import com.professeur.oumaima.entities.Grade;
import com.professeur.oumaima.entities.Professeur;
@Controller
public class GradeController {
	
	
	    @Autowired
	    ProfesseurService   profService;
	    @Autowired
	    GradeService gradeService;
	    @RequestMapping("/CreateGrade")
	    public String CreateGrade(ModelMap modelMap)
	    {
	    Grade grade = new Grade();	
	    modelMap.addAttribute("grade", grade);
	    modelMap.addAttribute("mode", "new");
	    return "formGrade";
	    }
	    
	    @RequestMapping("/saveGrade")
	    public String savegrade(@Valid Grade grade,BindingResult bindingResult)
	    {
	    if (bindingResult.hasErrors()) return "formGrade";
	     
	    gradeService.saveGrade(grade);
		return "redirect:/ListeGrades";
	    }
	    
	    
	    @RequestMapping("/ListeGrades")
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
	    	 Page<Grade> gradess = gradeService.getAllGradesParPage(page, size);
		     modelMap.addAttribute("grade", gradess);
		     modelMap.addAttribute("pages", new int[gradess.getTotalPages()]);
		     modelMap.addAttribute("currentPage", page);
		    return "listeGrade";
	    	
	    }
	    @RequestMapping("/modifierGrade")
	    public String editerGrade(@RequestParam("id") Long id,ModelMap modelMap)
	    {
	    Grade g= gradeService.getGrade(id);
	    modelMap.addAttribute("grade", g);
	    modelMap.addAttribute("mode", "edit");
	    return "formGrade";
	    }

	    
	    @RequestMapping("/updateGrade")
	    public String updateGrade(@ModelAttribute("grade") Grade grade,
	                                ModelMap modelMap) throws ParseException
	    {

	        gradeService.updateGrade(grade);
	        List<Grade> grds = gradeService.getAllGrades();
	        modelMap.addAttribute("grades", grds);
	        return "listeGrade";
	    }
	    @RequestMapping("/supprimerGrade")
	    public String supprimerGrade(@RequestParam("id") Long id,ModelMap modelMap,
	    		@RequestParam (name="page",defaultValue = "0") int page,
	    		@RequestParam (name="size", defaultValue = "2") int size)
	    {
	        gradeService.deleteGradeById(id);
	        Page<Grade> gradess = gradeService.getAllGradesParPage(page, size);
		     modelMap.addAttribute("grade", gradess);
		     modelMap.addAttribute("pages", new int[gradess.getTotalPages()]);
		     modelMap.addAttribute("currentPage", page);
	        		return "redirect:/ListeGrades";
	    }
	    
	    
	    @RequestMapping("/chercher")
	    public String chercherProfesseur(@RequestParam("nomGrade")String nom,ModelMap modelMap)
	    {     
	    	  List <Professeur> profs= profService.findByNomGrade(nom);
	    	
	    	  modelMap.addAttribute("Professeurs",profs);
	    	  return "resultatRecherche";
	    	  
	    	  
	    }

}
