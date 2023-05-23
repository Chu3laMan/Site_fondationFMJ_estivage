package org.baeldung.persistence.dao.publication;

import java.util.List;

import org.baeldung.persistence.model.publication.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {
	List<Publication> findByStatus(int status);

}
