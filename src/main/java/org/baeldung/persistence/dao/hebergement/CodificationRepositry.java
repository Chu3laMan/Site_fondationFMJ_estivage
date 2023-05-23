package org.baeldung.persistence.dao.hebergement;

import java.util.List;

import org.baeldung.persistence.model.hebergement.Codification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CodificationRepositry extends JpaRepository<Codification, Long> {
	Codification findByLibelle(String libelle);
	List<Codification> findByNomTable(String nomTable);
	
	@Query(value = "SELECT DISTINCT c.nomTable FROM codification c", nativeQuery = true)
	List<String> findAllTableName();
	
	@Query(value = "SELECT DISTINCT c.libelle FROM codification c", nativeQuery = true)
	List<String> findAllCodificationLebille();
	
	@Query(value = "SELECT c.libelle FROM codification c where c.nomTable='BANK'", nativeQuery = true)
	List<String> findAllCodificationBanks();
	
	@Query(value = "SELECT c.libelle FROM codification c where c.nomTable='TypeCredit'", nativeQuery = true)
	List<String> findAllCodificationCredit();
	@Query(value = "SELECT c.libelle FROM codification c where c.nomTable='ServiceBank'", nativeQuery = true)
	List<String> findAllCodificationServiceBank();
	
	//for serviceImmob view
	@Query(value = "SELECT c.libelle FROM codification c where c.nomTable='SocietImmob'", nativeQuery = true)
	List<String> findAllCodificationServiceImmob();
	@Query(value = "SELECT c.libelle FROM codification c where c.nomTable='ProduitImmob'", nativeQuery = true)
	List<String> findAllCodificationProduitImmob();
	
	//for serviceBankTach view
	@Query(value = "SELECT c.libelle FROM codification c where c.nomTable='BankTachroki'", nativeQuery = true)
	List<String> findAllCodificationServiceBankTach();
	// the secone is equivqlent to "serviceBank" one 
	
	List<Codification> findAllBySupprimer(int supprimer);
	
	@Query(value = "SELECT c.libelle FROM codification c where c.nomTable='ServiceBankTach'", nativeQuery = true)
	List<String> findserviceBankTachLibelle();
}
