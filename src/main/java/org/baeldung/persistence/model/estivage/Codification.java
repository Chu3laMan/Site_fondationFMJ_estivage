/***********************************************************************
 * Module:  Codification.java
 * Author:  Loqman
 * Purpose: Defines the Class Codification
 ***********************************************************************/
package org.baeldung.persistence.model.estivage;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Codification")
public class Codification {
	@Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	
   public int iDCodification;
   public String code;
   public String commentaire;
   public Date dateCreation;
   public Date dateoMdification;
   public int idUserCreePar;
   public int idUserModifierPar;
   public String libelle;
   public String nomTable;
   public int supprime;
   public int idParent;

}