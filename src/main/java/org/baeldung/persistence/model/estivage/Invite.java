/***********************************************************************
 * Module:  Invite.java
 * Author:  Loqman
 * Purpose: Defines the Class Invite
 ***********************************************************************/
package org.baeldung.persistence.model.estivage;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name = "Invite")
public class Invite {
	@Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
   public int idInvite;
   public String cin;
   public String commentaire;
   public Date dateCreation;
   public Date dateModification;
   public int idUserCreePar;
   public int idUserModifierPar;
   public String nom;
   public String prenom;
   public int supprime;
    
   
   @ManyToMany
  @JoinTable(
          name = "ASSReservationInvite",
          joinColumns = @JoinColumn(name = "idInvite"),
          inverseJoinColumns = @JoinColumn(name = "idReservation"))
      
      private Collection<Reservation> reservation;

}