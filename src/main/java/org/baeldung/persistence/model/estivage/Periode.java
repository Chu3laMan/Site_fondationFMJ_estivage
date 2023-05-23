/***********************************************************************
 * Module:  Periode.java
 * Author:  Loqman
 * Purpose: Defines the Class Periode
 ***********************************************************************/
package org.baeldung.persistence.model.estivage;
 

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

@Entity
@Table(name = "Periode")


public class Periode {
	@Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
   public int idPeriode;
   public byte active;
   public String commentaire;
   public Date dateCreation;
   public Date dateDebut;
   public Date dateFin;
   public Date dateModification;
   public int idTypePeriode;
   public int idUserCreePar;
   public int idUserModifierPar;
   public int nbrJours;
   public int supprime;
   
   @OneToMany(mappedBy = "periode", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
   public Collection<Reservation> reservation;
   //public java.util.Collection<Reservation> reservation;
	 
   
   @OneToMany(mappedBy = "periode", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
   public Collection<Selection> selection;
    
   
   
   /** @pdGenerated default getter */
   public Collection<Reservation> getReservation() {
      if (reservation == null)
         reservation = new HashSet<Reservation>();
      return reservation;
   }
   
   /** @pdGenerated default iterator getter */
   public  Iterator<Reservation> getIteratorReservation() {
      if (reservation == null)
         reservation = new HashSet<Reservation>();
      return reservation.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newReservation */
   public void setReservation(Collection<Reservation> newReservation) {
      removeAllReservation();
      for (Iterator<Reservation> iter = newReservation.iterator(); iter.hasNext();)
         addReservation((Reservation)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newReservation */
   public void addReservation(Reservation newReservation) {
      if (newReservation == null)
         return;
      if (this.reservation == null)
         this.reservation = new HashSet<Reservation>();
      if (!this.reservation.contains(newReservation))
      {
         this.reservation.add(newReservation);
         newReservation.setPeriode(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldReservation */
   public void removeReservation(Reservation oldReservation) {
      if (oldReservation == null)
         return;
      if (this.reservation != null)
         if (this.reservation.contains(oldReservation))
         {
            this.reservation.remove(oldReservation);
            oldReservation.setPeriode((Periode)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllReservation() {
      if (reservation != null)
      {
         Reservation oldReservation;
         for ( Iterator<Reservation> iter = getIteratorReservation(); iter.hasNext();)
         {
            oldReservation = (Reservation)iter.next();
            iter.remove();
            oldReservation.setPeriode((Periode)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public Collection<Selection> getSelection() {
      if (selection == null)
         selection = new HashSet<Selection>();
      return selection;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator<Selection> getIteratorSelection() {
      if (selection == null)
         selection = new HashSet<Selection>();
      return selection.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newSelection */
   public void setSelection(Collection<Selection> newSelection) {
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
         this.selection = new HashSet<Selection>();
      if (!this.selection.contains(newSelection))
      {
         this.selection.add(newSelection);
         newSelection.setPeriode(this);      
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
            oldSelection.setPeriode((Periode)null);
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
            oldSelection.setPeriode((Periode)null);
         }
      }
   }

}