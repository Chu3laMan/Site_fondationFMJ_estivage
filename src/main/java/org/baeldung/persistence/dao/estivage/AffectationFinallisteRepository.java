package org.baeldung.persistence.dao.estivage;

import org.baeldung.persistence.model.estivage.AffectationFinalliste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AffectationFinallisteRepository extends JpaRepository<AffectationFinalliste, Integer> {
}