/***********************************************************************
 * Module:  Users.java
 * Author:  Loqman
 * Purpose: Defines the Class Users
 ***********************************************************************/
package org.baeldung.persistence.model.estivage;
 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "USERS")

public class Users {
	@Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
   public String cin;
   public int dateReservation;
   public byte applique;
   public String numadhesion;

}