/***********************************************************************
 * Module:  Params.java
 * Author:  Loqman
 * Purpose: Defines the Class Params
 ***********************************************************************/
package org.baeldung.persistence.model.estivage;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Prams")
public class Params {
	
	
	@Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
   public int idParam;
   public String code;
   public String valeur;

}