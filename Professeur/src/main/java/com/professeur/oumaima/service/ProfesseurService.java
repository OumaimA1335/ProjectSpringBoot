package com.professeur.oumaima.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.professeur.oumaima.entities.Grade;
import com.professeur.oumaima.entities.Professeur;
@Service
public interface ProfesseurService {
	
	
    Professeur saveProfesseur(Professeur p);
    Professeur updateProfesseur(Professeur p);
    void deleteProfesseur(Professeur p);
    void deleteProfesseurById(Long id);
    Professeur getProfesseur(Long id);
    List<Professeur> getAllProfesseurs();
    Page<Professeur> getAllProfesseursParPage(int page, int size);
    List<Professeur> findByGrade (Grade grade);
    List<Professeur> findByGradeIdCat(Long id);
    List<Professeur> trierProfesseursNoms();
    List<Professeur> findByNomGrade(String nom);
    List<Professeur> findByNomProfesseur(String nom);
}
