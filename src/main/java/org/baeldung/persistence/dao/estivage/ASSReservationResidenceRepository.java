package org.baeldung.persistence.dao.estivage;

import org.baeldung.persistence.model.estivage.ASSReservationResidence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ASSReservationResidenceRepository extends JpaRepository<ASSReservationResidence, Integer> {
 

}