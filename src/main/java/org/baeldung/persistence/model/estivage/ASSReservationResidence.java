/***********************************************************************
 * Module:  ASSReservationResidence.java
 * Author:  Loqman
 * Purpose: Defines the Class ASSReservationResidence
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
@Table(name = "ASSReservationResidence")
public class ASSReservationResidence {
	
	@Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
   public String commentaire;
   public Date dateCreation;
   public Date dateDebut;
   public Date dateFin;
   public Date dateModification;
   public int idUserCreePar;
   public int idUserModifierPar;
   public float montant;
   public int supprime;
   public String typeReservation;
   
   
   
   @ManyToOne
   @JoinColumn(name = "id_reservation")
   private Reservation FK_ASSReservationResidence_Reservation_IdReservation;;
   
   @ManyToOne
   @JoinColumn(name = "id_residence")
   private Residence FK_ASSReservationResidence_Residence_IdResidence;
   
   //public Reservation FK_ASSReservationResidence_Reservation_IdReservation;
  // public Residence FK_ASSReservationResidence_Residence_IdResidence;

}