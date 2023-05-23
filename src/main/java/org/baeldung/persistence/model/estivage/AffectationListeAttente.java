/***********************************************************************
 * Module:  AffectationListeAttente.java
 * Author:  Loqman
 * Purpose: Defines the Class AffectationListeAttente
 ***********************************************************************/
package org.baeldung.persistence.model.estivage;

 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "affectationListeAttente")
public class AffectationListeAttente {
	
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