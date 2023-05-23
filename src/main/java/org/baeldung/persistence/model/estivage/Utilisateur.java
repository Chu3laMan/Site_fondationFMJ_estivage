/***********************************************************************
 * Module:  Utilisateur.java
 * Author:  Loqman
 * Purpose: Defines the Class Utilisateur
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Iterator;


@Entity
@Table(name = "Utilisateur")
public class Utilisateur {
	
	@Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
   public String adresse;
   public String cin;
   public Date dateEmbauche;
   public Date dateNaissance;
   public Date datedernierRes;
   public int idFonction;
   public int idLieuxDeTravail;
   public int idSituationFam;
   public int nbrEnfant;
   public String nom;
   public int numAdhesion;
   public String numSomme;
   public String prenom;
   public String tel;
   public String organismeAdresse;
   public String libelle;
   public String organismeTel;
   public int idUtilisateur;
   public String commentaire;
   public Date dateCreation;
   public Date dateModification;
   public String discriminator;
   public String email;
   public int idCategorie;
   public int idEtatUtilisateur;
   public int idRole;
   public int idUserCreePar;
   public int idUserModifierPar;
   public String login;
   public boolean passwordHash;
   public boolean passwordSalt;
   public int supprime;
   public String nomAr;
   public String prenomAr;
   public int idAdministration;
   public Date log;
   public Date logOut;
   public double poid;
   public Date datedernierResAdmin;
   
   
   
   @OneToMany(mappedBy = "utilisateur")
   private Collection<OrganismeSomme> organismeSomme;
  // public java.util.Collection<OrganismeSomme> organismeSomme;
   

   @OneToMany(mappedBy = "utilisateur")
   private Collection<Reservation> reservation;
 
  // public java.util.Collection<Reservation> reservation;
   
   
   
   @OneToMany(mappedBy = "utilisateur")
   private Collection<Selection> selection;
  // public java.util.Collection<Selection> selection;
   
   
   @OneToMany
   private Collection<Utilisateur> utilisateurB;
  // public java.util.Collection<Utilisateur> utilisateurB;
   
   
   @ManyToOne
   @JoinColumn(name="id_document",referencedColumnName = "idDocument")
   public Document document;
   
   
   @ManyToOne
   @JoinColumn(name="Adresse" ,referencedColumnName = "adresse")
   public Utilisateur utilisateurA;
   
   
   /** @pdGenerated default getter */
   public  Collection<OrganismeSomme> getOrganismeSomme() {
      if (organismeSomme == null)
         organismeSomme = new  HashSet<OrganismeSomme>();
      return organismeSomme;
   }
   
   /** @pdGenerated default iterator getter */
   public  Iterator<OrganismeSomme> getIteratorOrganismeSomme() {
      if (organismeSomme == null)
         organismeSomme = new  HashSet<OrganismeSomme>();
      return organismeSomme.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newOrganismeSomme */
   public void setOrganismeSomme( Collection<OrganismeSomme> newOrganismeSomme) {
      removeAllOrganismeSomme();
      for (Iterator<OrganismeSomme> iter = newOrganismeSomme.iterator(); iter.hasNext();)
         addOrganismeSomme((OrganismeSomme)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newOrganismeSomme */
   public void addOrganismeSomme(OrganismeSomme newOrganismeSomme) {
      if (newOrganismeSomme == null)
         return;
      if (this.organismeSomme == null)
         this.organismeSomme = new  HashSet<OrganismeSomme>();
      if (!this.organismeSomme.contains(newOrganismeSomme))
      {
         this.organismeSomme.add(newOrganismeSomme);
         newOrganismeSomme.setUtilisateur(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldOrganismeSomme */
   public void removeOrganismeSomme(OrganismeSomme oldOrganismeSomme) {
      if (oldOrganismeSomme == null)
         return;
      if (this.organismeSomme != null)
         if (this.organismeSomme.contains(oldOrganismeSomme))
         {
            this.organismeSomme.remove(oldOrganismeSomme);
            oldOrganismeSomme.setUtilisateur((Utilisateur)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllOrganismeSomme() {
      if (organismeSomme != null)
      {
         OrganismeSomme oldOrganismeSomme;
         for (Iterator<OrganismeSomme> iter = getIteratorOrganismeSomme(); iter.hasNext();)
         {
            oldOrganismeSomme = (OrganismeSomme)iter.next();
            iter.remove();
            oldOrganismeSomme.setUtilisateur((Utilisateur)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public  Collection<Reservation> getReservation() {
      if (reservation == null)
         reservation = new HashSet<Reservation>();
      return reservation;
   }
   
   /** @pdGenerated default iterator getter */
   public  Iterator<Reservation> getIteratorReservation() {
      if (reservation == null)
         reservation = new   HashSet<Reservation>();
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
         newReservation.setUtilisateur(this);      
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
            oldReservation.setUtilisateur((Utilisateur)null);
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
            oldReservation.setUtilisateur((Utilisateur)null);
         }
      }
   }
   
   /** @pdGenerated default getter */
   public  Collection<Selection> getSelection() {
      if (selection == null)
         selection = new  HashSet<Selection>();
      return selection;
   }
   
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator<Selection> getIteratorSelection() {
      if (selection == null)
         selection = new  HashSet<Selection>();
      return selection.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newSelection */
   public void setSelection( Collection<Selection> newSelection) {
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
         this.selection = new  HashSet<Selection>();
      if (!this.selection.contains(newSelection))
      {
         this.selection.add(newSelection);
         newSelection.setUtilisateur(this);      
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
            oldSelection.setUtilisateur((Utilisateur)null);
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
            oldSelection.setUtilisateur((Utilisateur)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public  Collection<Utilisateur> getUtilisateurB() {
      if (utilisateurB == null)
         utilisateurB = new HashSet<Utilisateur>();
      return utilisateurB;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorUtilisateurB() {
      if (utilisateurB == null)
         utilisateurB = new  HashSet<Utilisateur>();
      return utilisateurB.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newUtilisateurB */
   public void setUtilisateurB(Collection<Utilisateur> newUtilisateurB) {
      removeAllUtilisateurB();
      for (Iterator<Utilisateur> iter = newUtilisateurB.iterator(); iter.hasNext();)
         addUtilisateurB((Utilisateur)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newUtilisateur */
   public void addUtilisateurB(Utilisateur newUtilisateur) {
      if (newUtilisateur == null)
         return;
      if (this.utilisateurB == null)
         this.utilisateurB = new  HashSet<Utilisateur>();
      if (!this.utilisateurB.contains(newUtilisateur))
      {
         this.utilisateurB.add(newUtilisateur);
         newUtilisateur.setUtilisateurA(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldUtilisateur */
   public void removeUtilisateurB(Utilisateur oldUtilisateur) {
      if (oldUtilisateur == null)
         return;
      if (this.utilisateurB != null)
         if (this.utilisateurB.contains(oldUtilisateur))
         {
            this.utilisateurB.remove(oldUtilisateur);
            oldUtilisateur.setUtilisateurA((Utilisateur)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllUtilisateurB() {
      if (utilisateurB != null)
      {
         Utilisateur oldUtilisateur;
         for ( java.util.Iterator  iter = getIteratorUtilisateurB(); iter.hasNext();)
         {
            oldUtilisateur = (Utilisateur)iter.next();
            iter.remove();
            oldUtilisateur.setUtilisateurA((Utilisateur)null);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public Document getDocument() {
      return document;
   }
   
   /** @pdGenerated default parent setter
     * @param newDocument */
   public void setDocument(Document newDocument) {
      if (this.document == null || !this.document.equals(newDocument))
      {
         if (this.document != null)
         {
            Document oldDocument = this.document;
            this.document = null;
            oldDocument.removeUtilisateur(this);
         }
         if (newDocument != null)
         {
            this.document = newDocument;
            this.document.addUtilisateur(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public Utilisateur getUtilisateurA() {
      return utilisateurA;
   }
   
   /** @pdGenerated default parent setter
     * @param newUtilisateur */
   public void setUtilisateurA(Utilisateur newUtilisateur) {
      if (this.utilisateurA == null || !this.utilisateurA.equals(newUtilisateur))
      {
         if (this.utilisateurA != null)
         {
            Utilisateur oldUtilisateur = this.utilisateurA;
            this.utilisateurA = null;
            oldUtilisateur.removeUtilisateurB(this);
         }
         if (newUtilisateur != null)
         {
            this.utilisateurA = newUtilisateur;
            this.utilisateurA.addUtilisateurB(this);
         }
      }
   }

}