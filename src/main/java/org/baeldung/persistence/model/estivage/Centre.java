/***********************************************************************
 * Module:  Centre.java
 * Author:  Loqman
 * Purpose: Defines the Class Centre
 ***********************************************************************/
package org.baeldung.persistence.model.estivage;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Centre")

public class Centre {
	@Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
   public int idCentre;
   public String commentaire;
   public String compteBancaire;
   public Date dateCreation;
   public Date dateModification;
   public String description;
   public int idUserCreePar;
   public int idUserModifierPar;
   public int nbrResidence;
   public int supprime;
   public String tel;
   public String ville;
   
   @OneToMany (mappedBy ="centre" )
   private Collection<ASSEtatCentreDate> aSSEtatCentreDate;
  // public java.util.Collection<ASSEtatCentreDate> aSSEtatCentreDate;
   
   @OneToMany (mappedBy ="centre" )
   private Collection<ASSPrixCategorieCentreTypeResidence> aSSPrixCategorieCentreTypeResidence;
   
   
  // public java.util.Collection<ASSPrixCategorieCentreTypeResidence> aSSPrixCategorieCentreTypeResidence;
   
   @OneToMany (mappedBy ="centre" )
   private Collection<ASSServiceCentre> aSSServiceCentre;
   
   
  // public java.util.Collection<ASSServiceCentre> aSSServiceCentre;
   
   
   
   @OneToMany(mappedBy ="centre", cascade = CascadeType.ALL)
   private Collection<Residence> residence;
   
  // public java.util.Collection<Residence> residence;
   
   
   @OneToMany(mappedBy ="centre", cascade = CascadeType.ALL)
   private Collection<Selection> selection;
   
   //public java.util.Collection<Selection> selection;
   
   
   /** @pdGenerated default getter */
   public Collection<ASSEtatCentreDate> getASSEtatCentreDate() {
      if (aSSEtatCentreDate == null)
         aSSEtatCentreDate = new java.util.HashSet<ASSEtatCentreDate>();
      return aSSEtatCentreDate;
   }
   
   /** @pdGenerated default iterator getter */
   public  Iterator<ASSEtatCentreDate> getIteratorASSEtatCentreDate() {
      if (aSSEtatCentreDate == null)
         aSSEtatCentreDate = new HashSet<ASSEtatCentreDate>();
      return aSSEtatCentreDate.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newASSEtatCentreDate */
   public void setASSEtatCentreDate(java.util.Collection<ASSEtatCentreDate> newASSEtatCentreDate) {
      removeAllASSEtatCentreDate();
      for (Iterator<ASSEtatCentreDate> iter = newASSEtatCentreDate.iterator(); iter.hasNext();)
         addASSEtatCentreDate((ASSEtatCentreDate)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newASSEtatCentreDate */
   public void addASSEtatCentreDate(ASSEtatCentreDate newASSEtatCentreDate) {
      if (newASSEtatCentreDate == null)
         return;
      if (this.aSSEtatCentreDate == null)
         this.aSSEtatCentreDate = new java.util.HashSet<ASSEtatCentreDate>();
      if (!this.aSSEtatCentreDate.contains(newASSEtatCentreDate))
      {
         this.aSSEtatCentreDate.add(newASSEtatCentreDate);
         newASSEtatCentreDate.setCentre(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldASSEtatCentreDate */
   public void removeASSEtatCentreDate(ASSEtatCentreDate oldASSEtatCentreDate) {
      if (oldASSEtatCentreDate == null)
         return;
      if (this.aSSEtatCentreDate != null)
         if (this.aSSEtatCentreDate.contains(oldASSEtatCentreDate))
         {
            this.aSSEtatCentreDate.remove(oldASSEtatCentreDate);
            oldASSEtatCentreDate.setCentre((Centre)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllASSEtatCentreDate() {
      if (aSSEtatCentreDate != null)
      {
         ASSEtatCentreDate oldASSEtatCentreDate;
         for (Iterator<ASSEtatCentreDate> iter = getIteratorASSEtatCentreDate(); iter.hasNext();)
         {
            oldASSEtatCentreDate = (ASSEtatCentreDate)iter.next();
            iter.remove();
            oldASSEtatCentreDate.setCentre((Centre)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public  Collection<ASSPrixCategorieCentreTypeResidence> getASSPrixCategorieCentreTypeResidence() {
      if (aSSPrixCategorieCentreTypeResidence == null)
         aSSPrixCategorieCentreTypeResidence = new HashSet<ASSPrixCategorieCentreTypeResidence>();
      return aSSPrixCategorieCentreTypeResidence;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator<ASSPrixCategorieCentreTypeResidence> getIteratorASSPrixCategorieCentreTypeResidence() {
      if (aSSPrixCategorieCentreTypeResidence == null)
         aSSPrixCategorieCentreTypeResidence = new  HashSet<ASSPrixCategorieCentreTypeResidence>();
      return aSSPrixCategorieCentreTypeResidence.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newASSPrixCategorieCentreTypeResidence */
   public void setASSPrixCategorieCentreTypeResidence(java.util.Collection<ASSPrixCategorieCentreTypeResidence> newASSPrixCategorieCentreTypeResidence) {
      removeAllASSPrixCategorieCentreTypeResidence();
      for (Iterator<ASSPrixCategorieCentreTypeResidence> iter = newASSPrixCategorieCentreTypeResidence.iterator(); iter.hasNext();)
         addASSPrixCategorieCentreTypeResidence((ASSPrixCategorieCentreTypeResidence)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newASSPrixCategorieCentreTypeResidence */
   public void addASSPrixCategorieCentreTypeResidence(ASSPrixCategorieCentreTypeResidence newASSPrixCategorieCentreTypeResidence) {
      if (newASSPrixCategorieCentreTypeResidence == null)
         return;
      if (this.aSSPrixCategorieCentreTypeResidence == null)
         this.aSSPrixCategorieCentreTypeResidence = new  HashSet<ASSPrixCategorieCentreTypeResidence>();
      if (!this.aSSPrixCategorieCentreTypeResidence.contains(newASSPrixCategorieCentreTypeResidence))
      {
         this.aSSPrixCategorieCentreTypeResidence.add(newASSPrixCategorieCentreTypeResidence);
         newASSPrixCategorieCentreTypeResidence.setCentre(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldASSPrixCategorieCentreTypeResidence */
   public void removeASSPrixCategorieCentreTypeResidence(ASSPrixCategorieCentreTypeResidence oldASSPrixCategorieCentreTypeResidence) {
      if (oldASSPrixCategorieCentreTypeResidence == null)
         return;
      if (this.aSSPrixCategorieCentreTypeResidence != null)
         if (this.aSSPrixCategorieCentreTypeResidence.contains(oldASSPrixCategorieCentreTypeResidence))
         {
            this.aSSPrixCategorieCentreTypeResidence.remove(oldASSPrixCategorieCentreTypeResidence);
            oldASSPrixCategorieCentreTypeResidence.setCentre((Centre)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllASSPrixCategorieCentreTypeResidence() {
      if (aSSPrixCategorieCentreTypeResidence != null)
      {
         ASSPrixCategorieCentreTypeResidence oldASSPrixCategorieCentreTypeResidence;
         for (Iterator<ASSPrixCategorieCentreTypeResidence> iter = getIteratorASSPrixCategorieCentreTypeResidence(); iter.hasNext();)
         {
            oldASSPrixCategorieCentreTypeResidence = (ASSPrixCategorieCentreTypeResidence)iter.next();
            iter.remove();
            oldASSPrixCategorieCentreTypeResidence.setCentre((Centre)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public Collection<ASSServiceCentre> getASSServiceCentre() {
      if (aSSServiceCentre == null)
         aSSServiceCentre = new  HashSet<ASSServiceCentre>();
      return aSSServiceCentre;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator<ASSServiceCentre> getIteratorASSServiceCentre() {
      if (aSSServiceCentre == null)
         aSSServiceCentre = new  HashSet<ASSServiceCentre>();
      return aSSServiceCentre.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newASSServiceCentre */
   public void setASSServiceCentre(java.util.Collection<ASSServiceCentre> newASSServiceCentre) {
      removeAllASSServiceCentre();
      for (Iterator<ASSServiceCentre> iter = newASSServiceCentre.iterator(); iter.hasNext();)
         addASSServiceCentre((ASSServiceCentre)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newASSServiceCentre */
   public void addASSServiceCentre(ASSServiceCentre newASSServiceCentre) {
      if (newASSServiceCentre == null)
         return;
      if (this.aSSServiceCentre == null)
         this.aSSServiceCentre = new  HashSet<ASSServiceCentre>();
      if (!this.aSSServiceCentre.contains(newASSServiceCentre))
      {
         this.aSSServiceCentre.add(newASSServiceCentre);
         newASSServiceCentre.setCentre(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldASSServiceCentre */
   public void removeASSServiceCentre(ASSServiceCentre oldASSServiceCentre) {
      if (oldASSServiceCentre == null)
         return;
      if (this.aSSServiceCentre != null)
         if (this.aSSServiceCentre.contains(oldASSServiceCentre))
         {
            this.aSSServiceCentre.remove(oldASSServiceCentre);
            oldASSServiceCentre.setCentre((Centre)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllASSServiceCentre() {
      if (aSSServiceCentre != null)
      {
         ASSServiceCentre oldASSServiceCentre;
         for (Iterator<ASSServiceCentre> iter = getIteratorASSServiceCentre(); iter.hasNext();)
         {
            oldASSServiceCentre = (ASSServiceCentre)iter.next();
            iter.remove();
            oldASSServiceCentre.setCentre((Centre)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public  Collection<Residence> getResidence() {
      if (residence == null)
         residence = new  HashSet<Residence>();
      return residence;
   }
   
   /** @pdGenerated default iterator getter */
   public  Iterator<Residence> getIteratorResidence() {
      if (residence == null)
         residence = new  HashSet<Residence>();
      return residence.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newResidence */
   public void setResidence(java.util.Collection<Residence> newResidence) {
      removeAllResidence();
      for (Iterator<Residence> iter = newResidence.iterator(); iter.hasNext();)
         addResidence((Residence)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newResidence */
   public void addResidence(Residence newResidence) {
      if (newResidence == null)
         return;
      if (this.residence == null)
         this.residence = new  HashSet<Residence>();
      if (!this.residence.contains(newResidence))
      {
         this.residence.add(newResidence);
         newResidence.setCentre(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldResidence */
   public void removeResidence(Residence oldResidence) {
      if (oldResidence == null)
         return;
      if (this.residence != null)
         if (this.residence.contains(oldResidence))
         {
            this.residence.remove(oldResidence);
            oldResidence.setCentre((Centre)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllResidence() {
      if (residence != null)
      {
         Residence oldResidence;
         for (Iterator<Residence> iter = getIteratorResidence(); iter.hasNext();)
         {
            oldResidence = (Residence)iter.next();
            iter.remove();
            oldResidence.setCentre((Centre)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public  Collection<Selection> getSelection() {
      if (selection == null)
         selection = new  HashSet<Selection>();
      return selection;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator<Selection> getIteratorSelection() {
      if (selection == null)
         selection = new  HashSet<Selection>();
      return selection.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newSelection */
   public void setSelection( Collection<Selection> newSelection) {
      removeAllSelection();
      for (Iterator<Selection> iter = newSelection.iterator(); iter.hasNext();)
         addSelection((Selection)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newSelection */
   public void addSelection(Selection newSelection) {
      if (newSelection == null)
         return;
      if (this.selection == null)
         this.selection = new java.util.HashSet<Selection>();
      if (!this.selection.contains(newSelection))
      {
         this.selection.add(newSelection);
         newSelection.setCentre(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldSelection */
   public void removeSelection(Selection oldSelection) {
      if (oldSelection == null)
         return;
      if (this.selection != null)
         if (this.selection.contains(oldSelection))
         {
            this.selection.remove(oldSelection);
            oldSelection.setCentre((Centre)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllSelection() {
      if (selection != null)
      {
         Selection oldSelection;
         for (Iterator<Selection> iter = getIteratorSelection(); iter.hasNext();)
         {
            oldSelection = (Selection)iter.next();
            iter.remove();
            oldSelection.setCentre((Centre)null);
         }
      }
   }

}