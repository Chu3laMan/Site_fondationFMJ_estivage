package org.baeldung.persistence.model.estivage;

/***********************************************************************
 * Module:  Affectation.java
 * Author:  Loqman
 * Purpose: Defines the Class Affectation
 ***********************************************************************/

 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "affectation")
public class Affectation {
	@Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
   public int idAffectation;
   public int idPeriode;
   public int idCentre;
   public int idResidence;
   public int idUtilisateur;

}