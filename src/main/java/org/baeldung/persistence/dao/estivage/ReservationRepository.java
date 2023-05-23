package org.baeldung.persistence.dao.estivage;

 

import org.baeldung.persistence.model.estivage.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 


@Repository

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
 
}