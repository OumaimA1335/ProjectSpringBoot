package com.professeur.oumaima.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.professeur.oumaima.entities.Grade;

public interface GradeService {
	
	List<Grade> getAllGrades();
	Grade saveGrade(Grade grade);
	Page<Grade> getAllGradesParPage(int page, int size);
	void deleteGradeById(Long id);
	Grade getGrade(Long id);
	Grade updateGrade(Grade c);

}
