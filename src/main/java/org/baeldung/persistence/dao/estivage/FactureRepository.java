package org.baeldung.persistence.dao.estivage;

 
import org.baeldung.persistence.model.estivage.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface  FactureRepository extends JpaRepository<Facture, Integer> {
 

}