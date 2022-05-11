package com.professeur.oumaima.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.professeur.oumaima.entities.Grade;
import com.professeur.oumaima.entities.Professeur;
@RepositoryRestResource(path = "rest")
public interface ProfesseurRepo extends JpaRepository<Professeur, Long> {
	
	  
	
	 @Query("select p from Professeur p where p.nomProf like %?1")
	 List<Professeur> findByNomProfesseur(String nom);	
	
	 @Query("select p from Professeur p where p.grade.nomGrade like %?1")
	 List<Professeur> findByNomGrade(String nom);	
	 @Query("select p from Professeur p where p.grade = ?1")
	 List<Professeur> findByGrade (Grade grade);
	 
	 List<Professeur> findByGradeIdGrade(Long id);
	 @Query("select p from Professeur p order by p.nomProf ASC")
	 List<Professeur> trierProfesseursNoms ();

}
