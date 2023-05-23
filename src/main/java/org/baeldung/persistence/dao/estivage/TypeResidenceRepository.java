package org.baeldung.persistence.dao.estivage;

 

import org.baeldung.persistence.model.estivage.TypeResidence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 


@Repository

public interface TypeResidenceRepository extends JpaRepository<TypeResidence, Integer> {
 
}