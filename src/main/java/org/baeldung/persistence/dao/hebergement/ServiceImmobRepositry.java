package org.baeldung.persistence.dao.hebergement;
import java.util.List;

import org.baeldung.persistence.model.hebergement.ServiceImmob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceImmobRepositry extends JpaRepository<ServiceImmob, Long> {
	
	List<ServiceImmob> findByidProdImob(Long idProdImob);
	List<ServiceImmob> findByidSocietImob(Long idSocietImob);
	List<ServiceImmob> findAllBySupprimer(int supprimer);

}
