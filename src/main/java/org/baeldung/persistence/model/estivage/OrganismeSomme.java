/***********************************************************************
 * Module:  OrganismeSomme.java
 * Author:  Loqman
 * Purpose: Defines the Class OrganismeSomme
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
@Table(name = "OrganismeSomme")

public class OrganismeSomme {
	
	@Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
   public int idOrganismeSomme;
   public int annee;
   public String commentaire;
   public Date dateCreation;
   public Date dateModification;
   public int idUserCreePar;
   public int idUserModifierPar;
   public float montant;
   public int supprime;
   
    
   @ManyToOne
   @JoinColumn(name="id_utilisateur",referencedColumnName = "adresse")
    public Utilisateur utilisateur;
   
   
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
            oldUtilisateur.removeOrganismeSomme(this);
         }
         if (newUtilisateur != null)
         {
            this.utilisateur = newUtilisateur;
            this.utilisateur.addOrganismeSomme(this);
         }
      }
   }

}