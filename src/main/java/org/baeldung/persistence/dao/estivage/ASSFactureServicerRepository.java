package org.baeldung.persistence.dao.estivage;

 

import org.baeldung.persistence.model.estivage.ASSFactureService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ASSFactureServicerRepository extends JpaRepository<ASSFactureService, Integer> {

}

