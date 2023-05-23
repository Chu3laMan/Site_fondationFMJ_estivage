package org.baeldung.persistence.dao.hebergement;

import java.util.List;

import org.baeldung.persistence.model.hebergement.ServiceBankTach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceBankTachRepositry extends JpaRepository<ServiceBankTach, Long> {
	List<ServiceBankTach> findByidBank(Long idBank);
	List<ServiceBankTach> findByidServiceBank(Long idServiceBank);
	List<ServiceBankTach> findAllBySupprimer(int supprimer);

}
