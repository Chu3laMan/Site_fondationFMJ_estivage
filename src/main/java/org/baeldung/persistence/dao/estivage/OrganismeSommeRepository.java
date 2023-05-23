package org.baeldung.persistence.dao.estivage;

 
import org.baeldung.persistence.model.estivage.OrganismeSomme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrganismeSommeRepository extends JpaRepository<OrganismeSomme, Integer> {
 
}
