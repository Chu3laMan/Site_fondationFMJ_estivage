/***********************************************************************
 * Module:  Selection.java
 * Author:  Loqman
 * Purpose: Defines the Class Selection
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
@Table(name = "Selection")

public class Selection {
	
	@Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
   public int idSelection;
   public String commentaire;
   public Date dateCreation;
   public Date dateModification;
   public Date dateReservation;
   public int idEtatJury;
   public int idEtatSystem;
   public int idUserCreePar;
   public int idUserModifierPar;
   public float montantTotal;
   public int nbAccompagneAdlt;
   public int nbAccompagneEnfant;
   public float note;
   public String numReservation ;
   public int supprime;
   
   
   @ManyToOne
   @JoinColumn(name="id_centre",referencedColumnName = "idCentre")
    public Centre centre;
   
   
   @ManyToOne
   @JoinColumn (name="id_periode",referencedColumnName = "idPeriode")
   public Periode periode;
   
   
   @ManyToOne
   @JoinColumn (name="id_TypeResidence",referencedColumnName = "idTypeResidence")
   public TypeResidence typeResidence;
   
   @ManyToOne
   @JoinColumn (name="id_adresseUser",referencedColumnName = "adresse")
  
   public Utilisateur utilisateur;
   
   
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
            oldCentre.removeSelection(this);
         }
         if (newCentre != null)
         {
            this.centre = newCentre;
            this.centre.addSelection(this);
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
            oldPeriode.removeSelection(this);
         }
         if (newPeriode != null)
         {
            this.periode = newPeriode;
            this.periode.addSelection(this);
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
            oldTypeResidence.removeSelection(this);
         }
         if (newTypeResidence != null)
         {
            this.typeResidence = newTypeResidence;
            this.typeResidence.addSelection(this);
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
            oldUtilisateur.removeSelection(this);
         }
         if (newUtilisateur != null)
         {
            this.utilisateur = newUtilisateur;
            this.utilisateur.addSelection(this);
         }
      }
   }

}