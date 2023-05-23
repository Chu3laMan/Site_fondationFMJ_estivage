package org.baeldung.persistence.dao.estivage;

 
import org.baeldung.persistence.model.estivage.Codification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CodificationRepository extends JpaRepository<Codification, Integer> {
 

}