/***********************************************************************
 * Module:  ASSPrixCategorieCentreTypeResidence.java
 * Author:  Loqman
 * Purpose: Defines the Class ASSPrixCategorieCentreTypeResidence
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
@Table(name = "ASSPrixCategorieCentreTypeResidence")
public class ASSPrixCategorieCentreTypeResidence {
	
	@Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
   public int idCategorie;
   public String commentaire;
   public Date dateCreation;
   public Date dateModification;
   public int idUserCreePar;
   public int idUserModifierPar;
   public int supprime;
   public float tarif;
   
   @ManyToOne
   @JoinColumn(name="id_centre" ,referencedColumnName = "idCentre")
   public Centre centre;
 
   @ManyToOne
   @JoinColumn(name="id_TypeResidence" ,referencedColumnName = "idTypeResidence")
   public TypeResidence typeResidence;
   
   
   /** @pdGenerated default parent getter */
   public Centre getCentre() {
      return centre;
   }
   
   /** @pdGenerated default parent setter
     * @param newCentre */
   public void setCentre(Centre newCentre) {
      if (this.centre == null || !this.centre.equals(newCentre))
      {
         if (this.centre != null)
         {
            Centre oldCentre = this.centre;
            this.centre = null;
            oldCentre.removeASSPrixCategorieCentreTypeResidence(this);
         }
         if (newCentre != null)
         {
            this.centre = newCentre;
            this.centre.addASSPrixCategorieCentreTypeResidence(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public TypeResidence getTypeResidence() {
      return typeResidence;
   }
   
   /** @pdGenerated default parent setter
     * @param newTypeResidence */
   public void setTypeResidence(TypeResidence newTypeResidence) {
      if (this.typeResidence == null || !this.typeResidence.equals(newTypeResidence))
      {
         if (this.typeResidence != null)
         {
            TypeResidence oldTypeResidence = this.typeResidence;
            this.typeResidence = null;
            oldTypeResidence.removeASSPrixCategorieCentreTypeResidence(this);
         }
         if (newTypeResidence != null)
         {
            this.typeResidence = newTypeResidence;
            this.typeResidence.addASSPrixCategorieCentreTypeResidence(this);
         }
      }
   }

}