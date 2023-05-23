package org.baeldung.persistence.dao.estivage;

 
import org.baeldung.persistence.model.estivage.Entite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface  EntiteRepository extends JpaRepository<Entite, Integer> {
 

}