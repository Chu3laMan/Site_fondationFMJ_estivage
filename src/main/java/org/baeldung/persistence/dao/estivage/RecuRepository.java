package org.baeldung.persistence.dao.estivage;

 
import org.baeldung.persistence.model.estivage.Recu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 


@Repository

public interface RecuRepository extends JpaRepository<Recu, Integer> {
 
}