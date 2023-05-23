/***********************************************************************
 * Module:  Ville.java
 * Author:  Loqman
 * Purpose: Defines the Class Ville
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
@Table(name = "Ville")
public class Ville {
	
	@Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
   public int idVille;
   public String libelle;
   public String code;
   public int idUserCreePar;
   public Date dateCreation;
   public int idUserModifierPar;
   public Date dateModification;
   public int supprime;

}