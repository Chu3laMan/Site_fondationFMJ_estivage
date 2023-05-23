/***********************************************************************
 * Module:  Entite.java
 * Author:  Loqman
 * Purpose: Defines the Class Entite
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
@Table(name = "Entite")

public class Entite {
	
	@Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
   public int idEntite;
   public int idTypeJuridiction;
   public int idParent;
   public int idVille;
   public String code;
   public String libelle;
   public int idUserCreePar;
   public Date dateCreation;
   public int idUserModifierPar;
   public Date dateModification;
   public int supprime;

}