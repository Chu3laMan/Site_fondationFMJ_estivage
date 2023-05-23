package org.baeldung.persistence.dao.hebergement;

import java.util.List;

import org.baeldung.persistence.model.hebergement.ServiceBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceBankRepositry extends JpaRepository<ServiceBank, Long> {
	List<ServiceBank> findByidBank(Long idBank);
	List<ServiceBank> findByidServiceBank(Long idServiceBank);
	List<ServiceBank> findAllBySupprimer(int supprimer);

}
