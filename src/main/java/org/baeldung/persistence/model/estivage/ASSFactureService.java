/***********************************************************************
 * Module:  ASSFactureService.java
 * Author:  Loqman
 * Purpose: Defines the Class ASSFactureService
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
@Table(name = "ASSFactureService")
public class ASSFactureService {
	
	@Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
   public int idService;
   public String commentaire;
   public Date dateCreation;
   public Date dateModification;
   public int idUserCreePar;
   public int idUserModifierPar;
   public float montant;
   public int supprime;
   
   @ManyToOne  
   @JoinColumn(name="id_facture" ,referencedColumnName = "idFacture")
     
   public Facture facture;
   
   
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
            oldFacture.removeASSFactureService(this);
         }
         if (newFacture != null)
         {
            this.facture = newFacture;
            this.facture.addASSFactureService(this);
         }
      }
   }

}