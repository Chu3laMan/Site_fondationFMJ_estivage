/***********************************************************************
 * Module:  Reservation.java
 * Author:  Loqman
 * Purpose: Defines the Class Reservation
 ***********************************************************************/
package org.baeldung.persistence.model.estivage;
 
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 

import java.util.Collection;
import java.util.Date;

 @Entity
@Table(name = "Reservation")

public class Reservation {
	@Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
   public int idReservation;
   public String commentaire;
   public Date dateCreation;
   public Date dateModification;
   public Date dateReservation;
   public int idEtat;
   public int idModePaiement;
   public int idUserCreePar;
   public int idUserModifierPar;
   public float montantTotal;
   public int nbAccompagneAdlt;
   public int nbAccompagneEnfant;
   public String numReservation ;
   public int supprime;
   

      @ManyToOne
      @JoinColumn (name="id_centre")
      private Centre centre;

      @ManyToOne
      @JoinColumn(name="id_periode",referencedColumnName = "idPeriode")
      private Periode periode;

      @ManyToOne
      @JoinColumn(name="id_utilisateur",referencedColumnName = "adresse")
      private Utilisateur utilisateur;
 

     /* @ManyToOne
      @JoinColumn(name="adresse")
      private Utilisateur utilisateur1;*/

    @OneToMany( cascade=CascadeType.ALL)
    private Collection<Selection> selection ;

     
    @OneToMany(mappedBy = "FK_ASSReservationResidence_Reservation_IdReservation", cascade = CascadeType.ALL)
     private Collection<ASSReservationResidence> aSSReservationResidence;

    
        // public java.util.Collection aSSReservationResidence;
    
    
    
   @ManyToMany
  @JoinTable(
          name = "ASSReservationInvite",
          joinColumns = @JoinColumn(name = "idReservation"),
          inverseJoinColumns = @JoinColumn(name = "idInvite"))
      
      private Collection<Invite> invite;
       
      

  // public java.util.Collection aSSReservationInvite;
  
      
      
   @ManyToOne
   @JoinColumn(name="id_facture",referencedColumnName = "idFacture")
   private Facture facture;
    
   @ManyToOne
   @JoinColumn(name="id_NatureReservation",referencedColumnName = "idNatureReservation")
   private NatureReservation natureReservation;
    
 
   
   @ManyToOne 
   @JoinColumn(name="id_recu",referencedColumnName = "idRecu")
   public Recu recu;
  
   
   
   
   
   /** @pdGenerated default parent getter */
   public Facture getFacture() {
      return facture;
   }
   
   /** @pdGenerated default parent setter
     * @param newFacture */
   public void setFacture(Facture newFacture) {
      if (this.facture == null || !this.facture.equals(newFacture))
      {
         if (this.facture != null)
         {
            Facture oldFacture = this.facture;
            this.facture = null;
            oldFacture.removeReservation(this);
         }
         if (newFacture != null)
         {
            this.facture = newFacture;
            this.facture.addReservation(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public NatureReservation getNatureReservation() {
      return natureReservation;
   }
   
   /** @pdGenerated default parent setter
     * @param newNatureReservation */
   public void setNatureReservation(NatureReservation newNatureReservation) {
      if (this.natureReservation == null || !this.natureReservation.equals(newNatureReservation))
      {
         if (this.natureReservation != null)
         {
            NatureReservation oldNatureReservation = this.natureReservation;
            this.natureReservation = null;
            oldNatureReservation.removeReservation(this);
         }
         if (newNatureReservation != null)
         {
            this.natureReservation = newNatureReservation;
            this.natureReservation.addReservation(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public Periode getPeriode() {
      return periode;
   }
   
   /** @pdGenerated default parent setter
     * @param newPeriode */
   public void setPeriode(Periode newPeriode) {
      if (this.periode == null || !this.periode.equals(newPeriode))
      {
         if (this.periode != null)
         {
            Periode oldPeriode = this.periode;
            this.periode = null;
            oldPeriode.removeReservation(this);
         }
         if (newPeriode != null)
         {
            this.periode = newPeriode;
            this.periode.addReservation(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public Recu getRecu() {
      return recu;
   }
   
   /** @pdGenerated default parent setter
     * @param newRecu */
   public void setRecu(Recu newRecu) {
      if (this.recu == null || !this.recu.equals(newRecu))
      {
         if (this.recu != null)
         {
            Recu oldRecu = this.recu;
            this.recu = null;
            oldRecu.removeReservation(this);
         }
         if (newRecu != null)
         {
            this.recu = newRecu;
            this.recu.addReservation(this);
         }
      }
   }
   
   
   /** @pdGenerated default parent getter */
   public Utilisateur getUtilisateur() {
      return utilisateur;
      
      
   }
   /** @pdGenerated default parent setter
    * @param newUtilisateur */
  public void setUtilisateur(Utilisateur newUtilisateur) {
     if (this.utilisateur == null || !this.utilisateur.equals(newUtilisateur))
     {
        if (this.utilisateur != null)
        {
           Utilisateur oldUtilisateur = this.utilisateur;
           this.utilisateur = null;
           oldUtilisateur.removeReservation(this);
        }
        if (newUtilisateur != null)
        {
           this.utilisateur = newUtilisateur;
           this.utilisateur.addReservation(this);
        }
     }
  }

}