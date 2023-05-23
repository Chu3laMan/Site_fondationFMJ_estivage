package org.baeldung.persistence.dao.publication;

import java.util.List;

import org.baeldung.persistence.model.publication.RequestOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestOfferRepository extends JpaRepository<RequestOffer,Long> {
	List<RequestOffer> findByStatus(int status);

}
