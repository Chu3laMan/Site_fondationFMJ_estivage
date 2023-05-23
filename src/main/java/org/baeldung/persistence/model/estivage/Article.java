/***********************************************************************
 * Module:  Article.java
 * Author:  Loqman
 * Purpose: Defines the Class Article
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
@Table(name = "Article")

public class Article {
	
	@Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
   public int idArticle;
	 public String titre;
	 public String contenu;
	  public boolean photo;
	  public int idUserCreePar;
	    public Date dateCreation;
	    
	    public int idUserModifierPar;
	    public Date dateModification;
	    public int supprime;
	    public String commentaire;
	    
	    public int accueil;
	    
	   // public String desc;
   

}