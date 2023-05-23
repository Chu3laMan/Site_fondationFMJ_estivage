package org.baeldung.persistence.dao.estivage;

 
import org.baeldung.persistence.model.estivage.ASSPrixCategorieCentreTypeResidence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ASSPrixCategorieCentreTypeResidenceRepository extends JpaRepository<ASSPrixCategorieCentreTypeResidence, Integer> {

}

	


