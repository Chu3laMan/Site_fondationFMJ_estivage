/***********************************************************************
 * Module:  Document.java
 * Author:  Loqman
 * Purpose: Defines the Class Document
 ***********************************************************************/
package org.baeldung.persistence.model.estivage;
import java.util.*;
import java.util.Iterator;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Document")

public class Document {
	
	@Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
   public int idDocument;
   public boolean image;
   public Date dateCreation;
   public Date dateModification;
   public int idUserCreePar;
   public int idUserModifierPar;
   public int supprime;
   
   
   @OneToMany(mappedBy="document", cascade=CascadeType.ALL)
   private Collection<Utilisateur> utilisateur ;
   //public java.util.Collection<Utilisateur> utilisateur;
   
   
   /** @pdGenerated default getter */
   public  Collection<Utilisateur> getUtilisateur() {
      if (utilisateur == null)
         utilisateur = new HashSet<Utilisateur>();
      return utilisateur;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator<Utilisateur> getIteratorUtilisateur() {
      if (utilisateur == null)
         utilisateur = new HashSet<Utilisateur>();
      return utilisateur.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newUtilisateur */
   public void setUtilisateur( Collection<Utilisateur> newUtilisateur) {
      removeAllUtilisateur();
      for (Iterator<Utilisateur> iter = newUtilisateur.iterator(); iter.hasNext();)
         addUtilisateur((Utilisateur)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newUtilisateur */
   public void addUtilisateur(Utilisateur newUtilisateur) {
      if (newUtilisateur == null)
         return;
      if (this.utilisateur == null)
         this.utilisateur = new  HashSet<Utilisateur>();
      if (!this.utilisateur.contains(newUtilisateur))
      {
         this.utilisateur.add(newUtilisateur);
         newUtilisateur.setDocument(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldUtilisateur */
   public void removeUtilisateur(Utilisateur oldUtilisateur) {
      if (oldUtilisateur == null)
         return;
      if (this.utilisateur != null)
         if (this.utilisateur.contains(oldUtilisateur))
         {
            this.utilisateur.remove(oldUtilisateur);
            oldUtilisateur.setDocument((Document)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllUtilisateur() {
      if (utilisateur != null)
      {
         Utilisateur oldUtilisateur;
         for (Iterator<Utilisateur> iter = getIteratorUtilisateur(); iter.hasNext();)
         {
            oldUtilisateur = (Utilisateur)iter.next();
            iter.remove();
            oldUtilisateur.setDocument((Document)null);
         }
      }
   }

}