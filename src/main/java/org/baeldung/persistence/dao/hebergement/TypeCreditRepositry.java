package org.baeldung.persistence.dao.hebergement;

import java.util.List;

import org.baeldung.persistence.model.hebergement.TypeCredit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeCreditRepositry extends JpaRepository<TypeCredit, Long> {
	
	List<TypeCredit> findByidBank(Long idBank);
	List<TypeCredit> findByidServiceBank(Long idServiceBank);
	List<TypeCredit> findAllBySupprimer(int supprimer);

}
