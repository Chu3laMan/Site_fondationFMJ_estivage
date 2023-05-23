package org.baeldung.service.hebergement;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.baeldung.persistence.dao.hebergement.CodificationRepositry;
import org.baeldung.persistence.dao.hebergement.ServiceBankTachRepositry;
import org.baeldung.persistence.model.hebergement.ServiceBankTach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceBankTachService {
	@Autowired
	private ServiceBankTachRepositry seriveBankTachRepo;
	@Autowired 
	private CodificationRepositry codificationRepo;
	
	public ServiceBankTach saveServiceBankTach(String commentaire ,Optional<String> hamichRib7,
			Optional<String> moda,String libelleBank,String libelleServiceBank)
	{
		ServiceBankTach SBT = new ServiceBankTach();
		LocalDate date = LocalDate.now();
		SBT.setCommentaire(commentaire);
		SBT.setSupprimer(1);
		SBT.setDateCreation(date.toString());
		if(hamichRib7.isPresent())
		  SBT.setHamichRib7(hamichRib7.get());
		if(moda.isPresent())
		  SBT.setModa(moda.get());
		//SBT.setIdUsercreePar(idUsercreePar);
		SBT.setIdBank(codificationRepo.findByLibelle(libelleBank).getId());
		SBT.setIdServiceBank(codificationRepo.findByLibelle(libelleServiceBank).getId());
		return seriveBankTachRepo.save(SBT);
	}
	
	public ServiceBankTach getServiceBanktachById(Long id)
	{
		return seriveBankTachRepo.findById(id).get();
	}
	public List<ServiceBankTach> getAllServiceBankTach()
	{
		return seriveBankTachRepo.findAll();
	}
	
	public List<ServiceBankTach> getAllServiceBankByIdBank(Long idBank)
	{
		return seriveBankTachRepo.findByidBank(idBank);
	}
	public List<ServiceBankTach> getAllServiceBankByIdServiceBank(Long idServiceBank)
	{
		return seriveBankTachRepo.findByidServiceBank(idServiceBank);
	}
	
	//
	public ServiceBankTach changeServiceBankTachSatatus(Long id , int newStatus)
	{
		ServiceBankTach SBT = new ServiceBankTach();
		SBT = getServiceBanktachById(id);
		SBT.setSupprimer(newStatus);
		return seriveBankTachRepo.save(SBT);
	}

	public ServiceBankTach changeServiceBankTachCommet(Long id, String commentaire) {
	
		ServiceBankTach SBT = new ServiceBankTach();
		SBT = getServiceBanktachById(id);
		SBT.setCommentaire(commentaire);
		return seriveBankTachRepo.save(SBT);
	}

	public ServiceBankTach changeServiceBankTachModa(Long id, String moda) {
		ServiceBankTach SBT = new ServiceBankTach();
		SBT = getServiceBanktachById(id);
		SBT.setModa(moda);
		return seriveBankTachRepo.save(SBT);
	}

	public ServiceBankTach changeServiceBankTachRibh(Long id, String hamichRib7) {
		ServiceBankTach SBT = new ServiceBankTach();
		SBT = getServiceBanktachById(id);
		SBT.setHamichRib7(hamichRib7);
		return seriveBankTachRepo.save(SBT);	
	}

	public List<ServiceBankTach> getAllServiceBankTachByStatus(int i) {
		return seriveBankTachRepo.findAllBySupprimer(1);
	}
}
