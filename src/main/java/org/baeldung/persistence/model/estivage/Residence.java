/***********************************************************************
 * Module:  Residence.java
 * Author:  Loqman
 * Purpose: Defines the Class Residence
 ***********************************************************************/
package org.baeldung.persistence.model.estivage;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Iterator;
import java.util.HashSet;

@Entity
@Table(name = "Residence")

public class Residence {
	
	
	
	@Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
   public int idResidence;
   public String commentaire;
   public Date dateCreation;
   public Date dateModification;
   public int idUserCreePar;
   public int idUserModifierPar;
   public String numeroResidence;
   public int supprime;
   
   @OneToMany(mappedBy ="residence", cascade = CascadeType.ALL)
   private Collection<ASSEtatResidenceDate>aSSEtatResidenceDate;
   
  // public java.util.Collection<ASSEtatResidenceDate> aSSEtatResidenceDate;
   
   @OneToMany(mappedBy = "FK_ASSReservationResidence_Residence_IdResidence", cascade = CascadeType.ALL)
   private Collection<ASSReservationResidence> aSSReservationResidence;

  // public java.util.Collection aSSReservationResidence;
 
   
   @ManyToOne
   @JoinColumn(name="id_centre" ,referencedColumnName = "idCentre")
   public Centre centre;
   
   @ManyToOne
   @JoinColumn(name="id_TypeResedance" ,referencedColumnName = "idTypeResidence")
   public TypeResidence typeResidence;
   
   
   /** @pdGenerated default getter */
   public Collection<ASSEtatResidenceDate> getASSEtatResidenceDate() {
      if (aSSEtatResidenceDate == null)
         aSSEtatResidenceDate = new java.util.HashSet<ASSEtatResidenceDate>();
      return aSSEtatResidenceDate;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator<ASSEtatResidenceDate> getIteratorASSEtatResidenceDate() {
      if (aSSEtatResidenceDate == null)
         aSSEtatResidenceDate = new HashSet<ASSEtatResidenceDate>();
      return aSSEtatResidenceDate.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newASSEtatResidenceDate */
   public void setASSEtatResidenceDate(Collection<ASSEtatResidenceDate> newASSEtatResidenceDate) {
      removeAllASSEtatResidenceDate();
      for (Iterator<ASSEtatResidenceDate> iter = newASSEtatResidenceDate.iterator(); iter.hasNext();)
         addASSEtatResidenceDate((ASSEtatResidenceDate)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newASSEtatResidenceDate */
   public void addASSEtatResidenceDate(ASSEtatResidenceDate newASSEtatResidenceDate) {
      if (newASSEtatResidenceDate == null)
         return;
      if (this.aSSEtatResidenceDate == null)
         this.aSSEtatResidenceDate = new HashSet<ASSEtatResidenceDate>();
      if (!this.aSSEtatResidenceDate.contains(newASSEtatResidenceDate))
      {
         this.aSSEtatResidenceDate.add(newASSEtatResidenceDate);
         newASSEtatResidenceDate.setResidence(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldASSEtatResidenceDate */
   public void removeASSEtatResidenceDate(ASSEtatResidenceDate oldASSEtatResidenceDate) {
      if (oldASSEtatResidenceDate == null)
         return;
      if (this.aSSEtatResidenceDate != null)
         if (this.aSSEtatResidenceDate.contains(oldASSEtatResidenceDate))
         {
            this.aSSEtatResidenceDate.remove(oldASSEtatResidenceDate);
            oldASSEtatResidenceDate.setResidence((Residence)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllASSEtatResidenceDate() {
      if (aSSEtatResidenceDate != null)
      {
         ASSEtatResidenceDate oldASSEtatResidenceDate;
         for (Iterator<ASSEtatResidenceDate> iter = getIteratorASSEtatResidenceDate(); iter.hasNext();)
         {
            oldASSEtatResidenceDate = (ASSEtatResidenceDate)iter.next();
            iter.remove();
            oldASSEtatResidenceDate.setResidence((Residence)null);
         }
      }
   }
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
            oldCentre.removeResidence(this);
         }
         if (newCentre != null)
         {
            this.centre = newCentre;
            this.centre.addResidence(this);
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
            oldTypeResidence.removeResidence(this);
         }
         if (newTypeResidence != null)
         {
            this.typeResidence = newTypeResidence;
            this.typeResidence.addResidence(this);
         }
      }
   }

}