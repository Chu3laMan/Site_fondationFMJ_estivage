package org.baeldung.persistence.dao.estivage;


import org.baeldung.persistence.model.estivage.Centre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CentreRepository extends JpaRepository<Centre, Integer> {
 

}