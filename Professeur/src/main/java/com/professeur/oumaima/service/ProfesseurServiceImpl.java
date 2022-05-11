package com.professeur.oumaima.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.professeur.oumaima.entities.Grade;
import com.professeur.oumaima.entities.Professeur;
import com.professeur.oumaima.repos.ProfesseurRepo;

@Service

public class ProfesseurServiceImpl implements ProfesseurService{
	
	
	@Autowired
	ProfesseurRepo professeurRepository;
	@Override
	public Professeur saveProfesseur(Professeur p) {
		
		return professeurRepository.save(p);
	}

	@Override
	public Professeur updateProfesseur(Professeur p) {
		
		return professeurRepository.save(p);
	}

	@Override
	public void deleteProfesseur(Professeur p) {
	
		professeurRepository.delete(p);
	}

	@Override
	public void deleteProfesseurById(Long id) {
		
		professeurRepository.deleteById(id);
	}

	@Override
	public Professeur getProfesseur(Long id) {
		
		return professeurRepository.getById(id);
	}

	@Override
	public List<Professeur> getAllProfesseurs() {
	
		return professeurRepository.findAll();
	}

	@Override
	public Page<Professeur> getAllProfesseursParPage(int page, int size) {
		
		return professeurRepository.findAll(PageRequest.of(page, size));
	}



	@Override
	public List<Professeur> findByGrade(Grade grade) {
		
		return professeurRepository.findByGrade(grade);
	}

	@Override
	public List<Professeur> findByGradeIdCat(Long id) {
		
		return professeurRepository.findByGradeIdGrade(id);
	}


	@Override
	public List<Professeur> trierProfesseursNoms() {
		
		return professeurRepository.trierProfesseursNoms();
	}
	@Override
	public List<Professeur> findByNomGrade(String nom) {
		return professeurRepository.findByNomGrade(nom);
	}
	@Override
	public List<Professeur> findByNomProfesseur(String nom) {
		return professeurRepository.findByNomProfesseur(nom);
	}

}
