package com.professeur.oumaima.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;





@Entity
public class Professeur {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProf;
	@NotNull
	@Size (min = 10,max = 20)
	private String nomProf;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateDeNaissance;
	@NotNull
	private String diplome;
	@NotNull
	private String matiere;
	@Min(value = 1)
	private Double anneeExperience;
	@ManyToOne
	private Grade grade;
	
	
	public Professeur( String nomProf, Date dateDeNaissance, String diplome, String matiere,  Double anneeExperience , Grade grade) {
		
		this.nomProf = nomProf;
		this.dateDeNaissance = dateDeNaissance;
		this.diplome = diplome;
		this.matiere = matiere;
		this.anneeExperience = anneeExperience;
		this.setGrade(grade);
	}



	public Professeur( String nomProf, String matiere) {
		super();
		this.nomProf = nomProf;
		this.matiere = matiere;
	}

	public Professeur() {
		super();
	}



	public Long getIdProf() {
		return idProf;
	}



	public void setIdProf(Long idProf) {
		this.idProf = idProf;
	}



	public String getNomProf() {
		return nomProf;
	}



	public void setNomProf(String nomProf) {
		this.nomProf = nomProf;
	}



	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}



	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}



	public String getDiplome() {
		return diplome;
	}



	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}



	public String getMatiere() {
		return matiere;
	}



	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}



	public Double getAnneeExperience() {
		return anneeExperience;
	}



	public void setAnneeExperience(Double anneeExperience) {
		this.anneeExperience = anneeExperience;
	}



	public Grade getGrade() {
		return grade;
	}



	public void setGrade(Grade grade) {
		this.grade = grade;
	}



	@Override
	public String toString() {
		return "Professeur [idProf=" + idProf + ", nomProf=" + nomProf + ", dateDeNaissance=" + dateDeNaissance
				+ ", diplome=" + diplome + ", matiere=" + matiere + ", anneeExperience=" + anneeExperience + ", grade="
				+ grade + "]";
	}
	
	
	
	
	
	
	
	
	

}
