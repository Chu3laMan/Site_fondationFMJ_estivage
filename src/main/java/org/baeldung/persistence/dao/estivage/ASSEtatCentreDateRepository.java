package org.baeldung.persistence.dao.estivage;


import org.baeldung.persistence.model.estivage.ASSEtatCentreDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ASSEtatCentreDateRepository extends JpaRepository<ASSEtatCentreDate, Integer> {
	
	
 
}
