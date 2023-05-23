package org.baeldung.persistence.dao.estivage;

 
import org.baeldung.persistence.model.estivage.NatureReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface  NatureReservationRepository extends JpaRepository<NatureReservation, Integer> {
 
}
