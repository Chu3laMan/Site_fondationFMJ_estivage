package org.baeldung.service.hebergement;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.baeldung.persistence.dao.hebergement.CodificationRepositry;
import org.baeldung.persistence.dao.hebergement.ServiceBankRepositry;
import org.baeldung.persistence.model.hebergement.ServiceBank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceBankService {
	@Autowired
	private ServiceBankRepositry serviceBankRepo;
	@Autowired
	private CodificationRepositry codificationRepo;

	public ServiceBank saveServiceBank(String commentaire, Optional<String> faida,
			Optional<String> moda , Optional<String> sakf,String libelleBank,String libelleServiceBank)
	{
		ServiceBank SB = new ServiceBank();
		LocalDate date = LocalDate.now();
		SB.setCommentaire(commentaire);
		SB.setDateCreation(date.toString());
		//SB.setIdUsercreePar(idUsercreePar);
		if(faida.isPresent())
		  SB.setFaida(faida.get());
		if(moda.isPresent())
		  SB.setModa(moda.get());
		if(sakf.isPresent())
		  SB.setSakf(sakf.get());
		SB.setSupprimer(1);
		SB.setIdBank(codificationRepo.findByLibelle(libelleBank).getId());
		SB.setIdServiceBank(codificationRepo.findByLibelle(libelleServiceBank).getId());
		return serviceBankRepo.save(SB);
	}
	public List<ServiceBank> getAllServiceBank()
	{
		return serviceBankRepo.findAll();
	}
	public ServiceBank getServiceBank(Long id)
	{
		return serviceBankRepo.findById(id).get();
	}
	public List<ServiceBank> getAllServiceBankOfBank(Long idBank)
	{
		return serviceBankRepo.findByidBank(idBank);
	}
	
	public List<ServiceBank> getAllServiceBankByServiceBankId(Long idServiceBank)
	{
		return serviceBankRepo.findByidServiceBank(idServiceBank);
	}
	
	//change serviceBank Status
	public ServiceBank changeServiceBankSatatus(Long id , int newStatus)
	{
		ServiceBank SB = new ServiceBank();
		SB = serviceBankRepo.findById(id).get();
		SB.setSupprimer(newStatus);
		return serviceBankRepo.save(SB);
	}
	
	//change Comment
	public ServiceBank changeserviceBankComment(Long id, String commentaire)
	{
		ServiceBank SB = new ServiceBank();
		SB = serviceBankRepo.findById(id).get();
		SB.setCommentaire(commentaire);
		return serviceBankRepo.save(SB);
	}
	//change moda
	public ServiceBank changeServiceBankModa(Long id, String moda) {
	
		ServiceBank SB = new ServiceBank();
		SB = serviceBankRepo.findById(id).get();
		SB.setModa(moda);
		return serviceBankRepo.save(SB);
	}
	//change faida
	public ServiceBank changeServiceBankFaida(Long id, String faida) {
		ServiceBank SB = new ServiceBank();
		SB = serviceBankRepo.findById(id).get();
		SB.setFaida(faida);
		return serviceBankRepo.save(SB);
	}
	//change sakf
	public ServiceBank changeServiceBankSakf(Long id, String sakf) {
		ServiceBank SB = new ServiceBank();
		SB = serviceBankRepo.findById(id).get();
		SB.setSakf(sakf);
		return serviceBankRepo.save(SB);
	}
	public List<ServiceBank> getAllServiceBankByStatus(int i) {
		return serviceBankRepo.findAllBySupprimer(1);
	}

}
