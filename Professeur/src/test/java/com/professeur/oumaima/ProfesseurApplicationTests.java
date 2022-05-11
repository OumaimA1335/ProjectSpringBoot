package com.professeur.oumaima;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;


import com.professeur.oumaima.entities.Grade;
import com.professeur.oumaima.entities.Professeur;
import com.professeur.oumaima.repos.GradeRepo;
import com.professeur.oumaima.repos.ProfesseurRepo;


@SpringBootTest
class ProfesseurApplicationTests {
	@Autowired 
	ProfesseurRepo profRepo;
	@Autowired
	GradeRepo gradeRepo;
	
	
	@Test
	public void testCreateGrade() {
		Grade grade = new Grade("Maître conférences","Troiséme grade");
		gradeRepo.save(grade);
	}
	@Test
	public void testCreateprof() {
		Professeur prof = new Professeur("oumaima","science");
		profRepo.save(prof);
	}
	
	 @Test
	 public void testfindByGrade()
	 {
	 Grade grade = new Grade();
	 grade.setIdGrade(1L);
	 List<Professeur> profs = profRepo.findByGrade(grade);
	 for (Professeur p : profs)
	 {
	 System.out.println(p);
	 }
	 }
	 
	 @Test
	 public void findByGradeIdGrade()
	 {
	 List<Professeur> profs = profRepo.findByGradeIdGrade(1L);
	 for (Professeur p : profs)
	 {
	 System.out.println(p);
	 }
	  }
	 

	 @Test
	 public void testTrierProfesseursNoms()
	 {
	 List<Professeur> profs = profRepo.trierProfesseursNoms();
	 for (Professeur p : profs)
	 {
	 System.out.println(p);
	 }
	 }
	 @Test
		public void testListerTousProfs()
		{
			List<Professeur> profs = profRepo.findAll();
			for (Professeur p : profs)
			{
				System.out.println(p);
			}
		}
	 
	 @Test
		public void testDeleteProf()
		{
			profRepo.deleteById(1L);;
		}
	 @Test
		public void testUpdateProf()
		{
			Professeur p = profRepo.findById(1L).get();
			p.setNomProf("ichrak");
			profRepo.save(p);
		}
	 
	 @Test
		public void testFindProf()
		{
			Professeur p = profRepo.findById(1L).get();
			System.out.println(p);
		}
	 
	 @Test
	 public void testFindByNomGrade()
	 {
	 List<Professeur> profs = profRepo.findByNomGrade("Assistant");
	 for (Professeur p : profs)
	 {
	 System.out.println(p);
	 }
	 }
	 
	 @Test
	 public void testFindByNomProf()
	 {
	 List<Professeur> profs = profRepo.findByNomProfesseur("oumaima");
	 for (Professeur p : profs)
	 {
	 System.out.println(p);
	 }
	 }

}
