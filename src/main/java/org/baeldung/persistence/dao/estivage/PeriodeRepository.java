package org.baeldung.persistence.dao.estivage;
 
import org.baeldung.persistence.model.estivage.Periode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 


@Repository

public interface PeriodeRepository extends JpaRepository<Periode, Integer> {
 
}
