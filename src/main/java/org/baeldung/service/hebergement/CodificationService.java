package org.baeldung.service.hebergement;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;
import org.baeldung.persistence.dao.hebergement.CodificationRepositry;
import org.baeldung.persistence.model.hebergement.Codification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CodificationService {
	@Autowired
	private CodificationRepositry codificationRepo;
	
	public Codification saveCodification(MultipartFile file,String commentaire,
			String libelle,String nomeTable)
	{
		Codification c = new Codification();
		LocalDate date = LocalDate.now();
		try {
			c.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		c.setCommentaire(commentaire);
		c.setLibelle(libelle);
		c.setDateCreation(date.toString());
		c.setSupprimer(1);
		c.setNomTable(nomeTable);
		//c.setIdUserCreePar(idUserCreePar);
		return codificationRepo.save(c);
	}
	
	public List<Codification> getCodificationByTableName(String nomTable)
	{
		return codificationRepo.findByNomTable(nomTable);
	}
	
	public Codification getCodificationByLibelle(String libelle)
	{
		return codificationRepo.findByLibelle(libelle);
	}
	
	public Codification getCodificationById(Long id)
	{
		return codificationRepo.findById(id).get();
	}
	
	public List<Codification> getAllCodification()
	{
		return codificationRepo.findAll();
	}
	
	public Codification changeCodificationStatus(Long id ,int newStatus)
	{
		Codification c = new Codification();
		c = codificationRepo.findById(id).get();
		c.setSupprimer(newStatus);
		return codificationRepo.save(c);
	}
	
	//in case we wanted to delete somme service
	public void deleteCodidication(Long id)
	{
		codificationRepo.deleteById(id);
	}

	public Codification changeImage(MultipartFile imagefile, Long codiId) {
		
		Codification c = new Codification();
		c = codificationRepo.findById(codiId).get();
		try {
			c.setImage(Base64.getEncoder().encodeToString(imagefile.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return codificationRepo.save(c);
	}

	public Codification changeComent(Long id, String comment) {
		Codification c = new  Codification();
		c = codificationRepo.findById(id).get();
		c.setCommentaire(comment);
		return codificationRepo.save(c);
	}
	
	public List<String> findAllCodificationNamesOfTables()
	{
		return codificationRepo.findAllTableName();
	}
	
	public List<String> findAllCodificationLibelle()
	{
		return codificationRepo.findAllCodificationLebille();
		
	}
	public List<String> getListOfBanks()
	{
		return codificationRepo.findAllCodificationBanks();
	}
	public List<String> getListOfCredit()
	{
		return codificationRepo.findAllCodificationCredit();
	}
	public List<String> getSeriveBanklibelle()
	{
		return codificationRepo.findAllCodificationServiceBank();
	}
	
	//for ServiceImmob
	public List<String> getListServiceImmob()
	{
		return codificationRepo.findAllCodificationServiceImmob();
	}
	public List<String> getListProduitImmob()
	{
		return codificationRepo.findAllCodificationProduitImmob();
	}
    // for serviceBankTach
	public List<String> getListServiceBankTach()
	{
		return codificationRepo.findAllCodificationServiceBankTach();
	}

	public List<Codification> getAllCodificationByStatus(int i) {
		return codificationRepo.findAllBySupprimer(1);
	}

	public List<String> getserviceBankTachLibelle() {
		return codificationRepo.findserviceBankTachLibelle();
	}
}
