/***********************************************************************
 * Module:  TypeResidence.java
 * Author:  Loqman
 * Purpose: Defines the Class TypeResidence
 ***********************************************************************/
package org.baeldung.persistence.model.estivage;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TypeResidence")
public class TypeResidence {
	
	@Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
   public int idTypeResidence;
   public int capacite;
   public String code;
   public String commentaire;
   public Date dateCreation;
   public Date dateModification;
   public String description;
   public int idUserCreePar;
   public int idUserModifierPar;
   public String libelle;
   public int supprime;
   
   @OneToMany (mappedBy ="typeResidence" )
   private Collection<ASSPrixCategorieCentreTypeResidence> aSSPrixCategorieCentreTypeResidence;
   
   //public java.util.Collection<ASSPrixCategorieCentreTypeResidence> aSSPrixCategorieCentreTypeResidence;
   
   
   @OneToMany (mappedBy ="typeResidence" )
   private Collection<Residence> residence;
  // public java.util.Collection<Residence> residence;
   
   @OneToMany (mappedBy ="typeResidence" )
   private Collection<Selection> selection;
   
   //public java.util.Collection<Selection> selection;
   
   
   /** @pdGenerated default getter */
   public Collection<ASSPrixCategorieCentreTypeResidence> getASSPrixCategorieCentreTypeResidence() {
      if (aSSPrixCategorieCentreTypeResidence == null)
         aSSPrixCategorieCentreTypeResidence = new  HashSet<ASSPrixCategorieCentreTypeResidence>();
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
   public void setASSPrixCategorieCentreTypeResidence(Collection<ASSPrixCategorieCentreTypeResidence> newASSPrixCategorieCentreTypeResidence) {
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
         newASSPrixCategorieCentreTypeResidence.setTypeResidence(this);      
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
            oldASSPrixCategorieCentreTypeResidence.setTypeResidence((TypeResidence)null);
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
            oldASSPrixCategorieCentreTypeResidence.setTypeResidence((TypeResidence)null);
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
   public Iterator<Residence> getIteratorResidence() {
      if (residence == null)
         residence = new  HashSet<Residence>();
      return residence.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newResidence */
   public void setResidence( Collection<Residence> newResidence) {
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
         newResidence.setTypeResidence(this);      
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
            oldResidence.setTypeResidence((TypeResidence)null);
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
            oldResidence.setTypeResidence((TypeResidence)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public  Collection<Selection> getSelection() {
      if (selection == null)
         selection = new java.util.HashSet<Selection>();
      return selection;
   }
   
   /** @pdGenerated default iterator getter */
   public  Iterator<Selection> getIteratorSelection() {
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
         this.selection = new  HashSet<Selection>();
      if (!this.selection.contains(newSelection))
      {
         this.selection.add(newSelection);
         newSelection.setTypeResidence(this);      
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
            oldSelection.setTypeResidence((TypeResidence)null);
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
            oldSelection.setTypeResidence((TypeResidence)null);
         }
      }
   }

}