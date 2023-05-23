/***********************************************************************
 * Module:  ASSServiceCentre.java
 * Author:  Loqman
 * Purpose: Defines the Class ASSServiceCentre
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
@Table(name = "ASSServiceCentre")

public class ASSServiceCentre {
	@Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
   public int idService;
   public String commentaire;
   public Date dateCreation;
   public Date dateModification;
   public int idUserCreePar;
   public int idUserModifierPar;
   public int supprime;
   public float tarif;
   
   @ManyToOne
   @JoinColumn(name="id_centre" ,referencedColumnName = "idCentre")
   public Centre centre;
    
   
   
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
            oldCentre.removeASSServiceCentre(this);
         }
         if (newCentre != null)
         {
            this.centre = newCentre;
            this.centre.addASSServiceCentre(this);
         }
      }
   }

}