/***********************************************************************
 * Module:  Nums.java
 * Author:  Loqman
 * Purpose: Defines the Class Nums
 ***********************************************************************/
package org.baeldung.persistence.model.estivage;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Nums")

public class Nums {
	
	@Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
   public int numadhesion;
   public String valide;
   public int id;

}