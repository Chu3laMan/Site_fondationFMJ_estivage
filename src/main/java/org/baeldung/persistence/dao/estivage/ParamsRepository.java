package org.baeldung.persistence.dao.estivage;

 


import org.baeldung.persistence.model.estivage.Params;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 


@Repository
public interface ParamsRepository extends JpaRepository<Params, Integer> {
 
}
