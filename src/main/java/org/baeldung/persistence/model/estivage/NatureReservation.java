/***********************************************************************
 * Module:  NatureReservation.java
 * Author:  Loqman
 * Purpose: Defines the Class NatureReservation
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
import java.util.Iterator;


@Entity
@Table(name = "NatureReservation")
public class NatureReservation {
	
	@Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
   public int idNatureReservation;
   public String code;
   public String commentaire;
   public Date dateCreation;
   public Date dateModification;
   public int idUserCreePar;
   public int idUserModifierPar;
   public String libelle;
   public int reduction;
   public int supprime;
   
    @OneToMany(mappedBy ="natureReservation",cascade=CascadeType.ALL) 
     private Collection<Reservation> reservation ;
    
 //  public java.util.Collection<Reservation> reservation;
   
   
   /** @pdGenerated default getter */
   public Collection<Reservation> getReservation() {
      if (reservation == null)
         reservation = new  HashSet<Reservation>();
      return reservation;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator<Reservation> getIteratorReservation() {
      if (reservation == null)
         reservation = new  HashSet<Reservation>();
      return reservation.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newReservation */
   public void setReservation( Collection<Reservation> newReservation) {
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
         this.reservation = new  HashSet<Reservation>();
      if (!this.reservation.contains(newReservation))
      {
         this.reservation.add(newReservation);
         newReservation.setNatureReservation(this);      
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
            oldReservation.setNatureReservation((NatureReservation)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllReservation() {
      if (reservation != null)
      {
         Reservation oldReservation;
         for (Iterator<Reservation> iter = getIteratorReservation(); iter.hasNext();)
         {
            oldReservation = (Reservation)iter.next();
            iter.remove();
            oldReservation.setNatureReservation((NatureReservation)null);
         }
      }
   }

}