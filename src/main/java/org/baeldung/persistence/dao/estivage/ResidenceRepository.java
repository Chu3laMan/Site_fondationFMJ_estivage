package org.baeldung.persistence.dao.estivage;

 
import org.baeldung.persistence.model.estivage.Residence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 


@Repository

public interface ResidenceRepository extends JpaRepository<Residence, Integer> {
 
}
