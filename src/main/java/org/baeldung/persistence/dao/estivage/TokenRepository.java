package org.baeldung.persistence.dao.estivage;
 

import org.baeldung.persistence.model.estivage.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 


@Repository

public interface TokenRepository extends JpaRepository<Token, Integer> {
 
}
