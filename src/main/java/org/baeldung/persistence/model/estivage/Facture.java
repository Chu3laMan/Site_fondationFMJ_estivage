/***********************************************************************
 * Module:  Facture.java
 * Author:  Loqman
 * Purpose: Defines the Class Facture
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
import java.util.HashSet;
import java.util.Iterator;

@Entity
@Table(name = "Facture")


public class Facture {
	@Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
   public int idFacture;
   public String commentaire;
   public Date dateCreation;
   public Date dateFacture;
   public Date dateModification;
   public int idModePaiement;
   public int idUserCreePar;
   public int idUserModifierPar;
   public float montant;
   public int numFacture;
   public int supprime;
   
   @OneToMany(mappedBy="facture", cascade=CascadeType.ALL)
   private Collection<ASSFactureService> aSSFactureService ;
   //public java.util.Collection<ASSFactureService> aSSFactureService;
  
   
   @OneToMany(mappedBy="facture", cascade=CascadeType.ALL)
    private Collection<Reservation> reservation ;
   
   //public java.util.Collection<Reservation> reservation;
   
   
   /** @pdGenerated default getter */
   public Collection<ASSFactureService> getASSFactureService() {
      if (aSSFactureService == null)
         aSSFactureService = new  HashSet<ASSFactureService>();
      return aSSFactureService;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator<ASSFactureService> getIteratorASSFactureService() {
      if (aSSFactureService == null)
         aSSFactureService = new HashSet<ASSFactureService>();
      return aSSFactureService.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newASSFactureService */
   public void setASSFactureService(Collection<ASSFactureService> newASSFactureService) {
      removeAllASSFactureService();
      for (Iterator<ASSFactureService> iter = newASSFactureService.iterator(); iter.hasNext();)
         addASSFactureService((ASSFactureService)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newASSFactureService */
   public void addASSFactureService(ASSFactureService newASSFactureService) {
      if (newASSFactureService == null)
         return;
      if (this.aSSFactureService == null)
         this.aSSFactureService = new java.util.HashSet<ASSFactureService>();
      if (!this.aSSFactureService.contains(newASSFactureService))
      {
         this.aSSFactureService.add(newASSFactureService);
         newASSFactureService.setFacture(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldASSFactureService */
   public void removeASSFactureService(ASSFactureService oldASSFactureService) {
      if (oldASSFactureService == null)
         return;
      if (this.aSSFactureService != null)
         if (this.aSSFactureService.contains(oldASSFactureService))
         {
            this.aSSFactureService.remove(oldASSFactureService);
            oldASSFactureService.setFacture((Facture)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllASSFactureService() {
      if (aSSFactureService != null)
      {
         ASSFactureService oldASSFactureService;
         for (Iterator<ASSFactureService> iter = getIteratorASSFactureService(); iter.hasNext();)
         {
            oldASSFactureService = (ASSFactureService)iter.next();
            iter.remove();
            oldASSFactureService.setFacture((Facture)null);
         }
      }
   }
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
         newReservation.setFacture(this);      
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
            oldReservation.setFacture((Facture)null);
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
            oldReservation.setFacture((Facture)null);
         }
      }
   }

}