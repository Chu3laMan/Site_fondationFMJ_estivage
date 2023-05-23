package org.baeldung.persistence.dao.publication;

import java.util.List;

import org.baeldung.persistence.model.publication.Manachir;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManachirRepository extends JpaRepository<Manachir, Long> {
	List<Manachir> findByStatus(int status , Sort sort);

}
