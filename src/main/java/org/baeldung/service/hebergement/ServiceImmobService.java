package org.baeldung.service.hebergement;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.baeldung.persistence.dao.hebergement.CodificationRepositry;
import org.baeldung.persistence.dao.hebergement.ServiceImmobRepositry;
import org.baeldung.persistence.model.hebergement.ServiceImmob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImmobService {
	@Autowired
	private ServiceImmobRepositry serviceImmobRepo;
	@Autowired
	private CodificationRepositry codificationRepo;

	public ServiceImmob saveServiceImmob(String commentaire, String societImob_libelle,
			String prodImob_libelle,
			String localisation, Optional<String> promotion) {
		
		ServiceImmob Smb = new ServiceImmob();
		LocalDate date = LocalDate.now();
		Smb.setCommentaire(commentaire);
		Smb.setDateCreation(date.toString());
		Smb.setIdProdImob(codificationRepo.findByLibelle(prodImob_libelle).getId());
		Smb.setIdSocietImob(codificationRepo.findByLibelle(societImob_libelle).getId());
		// Smb.setIdUsercreePar(idUsercreePar);
		if (promotion.isPresent()) {
			Smb.setPromotion(promotion.get());
		}
		Smb.setSupprimer(1);
		Smb.setLocalisation(localisation);
		return serviceImmobRepo.save(Smb);
	}

	public List<ServiceImmob> getServiceImmobByIdSocietImob(Long idSocietImob) {
		return serviceImmobRepo.findByidSocietImob(idSocietImob);
	}

	public List<ServiceImmob> getServiceImmmobByIdProdImob(Long idProdImob) {
		return serviceImmobRepo.findByidProdImob(idProdImob);
	}

	public List<ServiceImmob> getAllServiceImmob() {
		return serviceImmobRepo.findAll();
	}

	public ServiceImmob changeServiceImmobStatus(Long id, int newStatus) {
		ServiceImmob Smb = new ServiceImmob();
		Smb = serviceImmobRepo.findById(id).get();
		Smb.setSupprimer(newStatus);
		return serviceImmobRepo.save(Smb);
	}
	//in case we wanted to delete some service
	public void deleteServiceImmob(Long id )
	{
		serviceImmobRepo.deleteById(id);
	}

	public ServiceImmob changeServiceImmobComment(Long id, String commentaire) {
		ServiceImmob Smb = new ServiceImmob();
		Smb = serviceImmobRepo.findById(id).get();
		Smb.setCommentaire(commentaire);
		return serviceImmobRepo.save(Smb);
	}

	public ServiceImmob changeServiceImmobPromotion(Long id, String promotion) {
		ServiceImmob Smb = new ServiceImmob();
		Smb = serviceImmobRepo.findById(id).get();
		Smb.setPromotion(promotion);
		return serviceImmobRepo.save(Smb);
	}

	public ServiceImmob changeServiceImmobLocalisation(Long id, String localisation) {
		ServiceImmob Smb = new ServiceImmob();
		Smb = serviceImmobRepo.findById(id).get();
		Smb.setLocalisation(localisation);
		return serviceImmobRepo.save(Smb);
	}

	public List<ServiceImmob> getAllServiceImmobByStatus(int i) {
		return serviceImmobRepo.findAllBySupprimer(1);
	}

}
