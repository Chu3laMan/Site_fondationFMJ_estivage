package org.baeldung.persistence.dao.transport;

import java.util.List;

import org.baeldung.persistence.model.transport.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportRepository extends JpaRepository<Transport, Long> {
	List<Transport> findByType(String type);
	List<Transport> findByLibelle(String libelle);

}
