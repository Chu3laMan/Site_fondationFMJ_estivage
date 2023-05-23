package org.baeldung.persistence.dao.estivage;

 
import org.baeldung.persistence.model.estivage.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 


@Repository

public interface VilleRepository extends JpaRepository<Ville, Integer> {
 
}