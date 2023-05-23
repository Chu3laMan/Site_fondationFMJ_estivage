/***********************************************************************
 * Module:  ASSEtatResidenceDate.java
 * Author:  Loqman
 * Purpose: Defines the Class ASSEtatResidenceDate
 ***********************************************************************/
package org.baeldung.persistence.model.estivage;


import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "ASSEtatResidenceDate")
public class ASSEtatResidenceDate {
	
	@Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
   public int idEtatResidence;
   public Date dateDebut;
   public Date dateFin;
   public String commentaire;
   public Date dateCreation;
   public Date dateModification;
   public int idUserCreePar;
   public int idUserModifierPar;
   public int supprime;
   
   @ManyToOne
   @JoinColumn(name="id_residence " ,referencedColumnName = "idResidence")
   public Residence residence;
   
   
   /** @pdGenerated default parent getter */
   public Residence getResidence() {
      return residence;
   }
   
   /** @pdGenerated default parent setter
     * @param newResidence */
   public void setResidence(Residence newResidence) {
      if (this.residence == null || !this.residence.equals(newResidence))
      {
         if (this.residence != null)
         {
            Residence oldResidence = this.residence;
            this.residence = null;
            oldResidence.removeASSEtatResidenceDate(this);
         }
         if (newResidence != null)
         {
            this.residence = newResidence;
            this.residence.addASSEtatResidenceDate(this);
         }
      }
   }

}