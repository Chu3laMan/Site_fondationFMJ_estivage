/***********************************************************************
 * Module:  Token.java
 * Author:  Loqman
 * Purpose: Defines the Class Token
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
@Table(name = "Token")

public class Token {
	@Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
   public int id;
   public String tokenStr;
   public int idUtilisateur;
   public Date expiryDate;

}