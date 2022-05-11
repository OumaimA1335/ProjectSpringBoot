package com.professeur.oumaima.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.professeur.oumaima.entities.Grade;
import com.professeur.oumaima.repos.GradeRepo;
@Service
public class GradeServiceImpl implements GradeService {
	
	  @Autowired
	    GradeRepo gradeRepo;
		@Override
		public List<Grade> getAllGrades() {
			
			return gradeRepo.findAll() ;
		}

		@Override
		public Grade saveGrade(Grade grade) {
			
			return gradeRepo.save(grade);
		}

		@Override
		public Page<Grade> getAllGradesParPage(int page, int size) {
			
			return gradeRepo.findAll(PageRequest.of(page,size));
		}

		@Override
		public void deleteGradeById(Long id) {
			
			gradeRepo.deleteById(id);
			
		}

		@Override
		public Grade getGrade(Long id) {
		
			return gradeRepo.getById(id);
		}

		@Override
		public Grade updateGrade(Grade grade) {
			
			return gradeRepo.save(grade);
		}


}
