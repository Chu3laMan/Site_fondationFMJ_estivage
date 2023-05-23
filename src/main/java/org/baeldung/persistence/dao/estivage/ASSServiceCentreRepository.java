package org.baeldung.persistence.dao.estivage;

 

import org.baeldung.persistence.model.estivage.ASSServiceCentre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ASSServiceCentreRepository extends JpaRepository<ASSServiceCentre, Integer> {
 

}