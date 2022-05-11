package com.professeur.oumaima.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Grade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idGrade;
	@NotNull
	@Size (min = 5,max = 30)
	private String nomGrade;
	@NotNull
	@Size (min = 5,max = 30)
	private String descriptionGrade;
	@JsonIgnore
	@OneToMany(mappedBy = "grade")
	private List<Professeur> professeurs;
	
	
	public Grade(String nomGrade, String descriptionGrade) {
		super();
		this.nomGrade = nomGrade;
		this.descriptionGrade = descriptionGrade;
	
	}
	


	public Grade() {
		
	}



	public Long getIdGrade() {
		return idGrade;
	}


	public void setIdGrade(Long idGrade) {
		this.idGrade = idGrade;
	}


	public String getNomGrade() {
		return nomGrade;
	}


	public void setNomGrade(String nomGrade) {
		this.nomGrade = nomGrade;
	}


	public String getDescriptionGrade() {
		return descriptionGrade;
	}


	public void setDescriptionGrade(String descriptionGrade) {
		this.descriptionGrade = descriptionGrade;
	}


	public List<Professeur> getProfesseurs() {
		return professeurs;
	}


	public void setProfesseurs(List<Professeur> professeurs) {
		this.professeurs = professeurs;
	}


	@Override
	public String toString() {
		return "Grade [idGrade=" + idGrade + ", nomGrade=" + nomGrade + ", descriptionGrade=" + descriptionGrade
				+ ", professeurs=" + professeurs + "]";
	}
	
	
	
	
	

}
