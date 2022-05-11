package com.professeur.oumaima.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.professeur.oumaima.entities.Grade;
@RepositoryRestResource(path = "rest")
public interface GradeRepo extends JpaRepository<Grade, Long> {

}
