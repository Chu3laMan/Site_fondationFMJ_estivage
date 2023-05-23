package org.baeldung.persistence.dao.estivage;

 


import org.baeldung.persistence.model.estivage.Selection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 


@Repository

public interface SelectionRepository extends JpaRepository<Selection, Integer> {
 
}