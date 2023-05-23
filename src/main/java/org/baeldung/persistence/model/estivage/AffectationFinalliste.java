package org.baeldung.persistence.model.estivage;

/***********************************************************************
 * Module:  AffectationFinalliste.java
 * Author:  Loqman
 * Purpose: Defines the Class AffectationFinalliste
 ***********************************************************************/
 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "affectationFinalliste")

public class AffectationFinalliste {
	
	@Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
   public int idAffectation;
   public int idPeriode;
   public int idCentre;
   public int idResidence;
   public int idUtilisateur;
   public boolean selected;

}