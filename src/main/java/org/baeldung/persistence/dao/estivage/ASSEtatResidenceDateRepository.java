package org.baeldung.persistence.dao.estivage;



import org.baeldung.persistence.model.estivage.ASSEtatResidenceDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ASSEtatResidenceDateRepository extends JpaRepository<ASSEtatResidenceDate, Long> {

     

}