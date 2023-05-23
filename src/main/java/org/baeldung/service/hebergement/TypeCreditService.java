package org.baeldung.service.hebergement;

import java.time.LocalDate;
import java.util.List;
import org.baeldung.persistence.dao.hebergement.CodificationRepositry;
import org.baeldung.persistence.dao.hebergement.TypeCreditRepositry;
import org.baeldung.persistence.model.hebergement.TypeCredit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeCreditService {
	
	@Autowired
	private TypeCreditRepositry typeCreditRepo;
	@Autowired
	private CodificationRepositry codificationRepo;
	
	public TypeCredit saveTypeCredit(String commentaire,Double pFullCredit,Double pPartCredit
			,String libelleBank,String libelleServiceBank)
	{
		TypeCredit tc = new TypeCredit();
		LocalDate date = LocalDate.now();
		tc.setCommentaire(commentaire);
		tc.setIdServiceBank(codificationRepo.findByLibelle(libelleServiceBank).getId());
		System.out.println("still working");
		tc.setIdBank(codificationRepo.findByLibelle(libelleBank).getId());
		System.out.println("yeeeesss still working !!!!");
		tc.setDateCreation(date.toString());
		tc.setSupprimer(1);
		 tc.setpFullCredit(pFullCredit);
		 tc.setpPartCredit(pPartCredit);
		//tc.setIdUsercreePar(idUsercreePar);
		return typeCreditRepo.save(tc);
	}
	
	public List<TypeCredit> getAllTypeCredit()
	{
		return typeCreditRepo.findAll();
	}
	
	public TypeCredit getTypeCreditById(Long id)
	{
	    return 	typeCreditRepo.findById(id).get();
	}
	
	public List<TypeCredit> GetAllTypeCreditByIdBank(Long id)
	{
		return  typeCreditRepo.findByidBank(id);
	}
	public List<TypeCredit> GetAllTypeCreditByIdServiceBank(Long id)
	{
		return typeCreditRepo.findByidServiceBank(id);
	}
	
	//change TypeCredit Status
	public TypeCredit changeTypeCreditStatus(Long id,int newStatus)
	{
		TypeCredit tc = new TypeCredit();
		tc = getTypeCreditById(id);
		tc.setSupprimer(newStatus);
		return typeCreditRepo.save(tc);
	}
	public TypeCredit changeTypeCreditComment(Long id , String comment)
	{
		TypeCredit tc = new TypeCredit();
		tc = getTypeCreditById(id);
		tc.setCommentaire(comment);
		return typeCreditRepo.save(tc);
	}
	
	public TypeCredit changeTypeCreditpFullc(Long id , Double pFullCredit)
	{
		TypeCredit tc = new TypeCredit();
		tc = getTypeCreditById(id);
		tc.setpFullCredit(pFullCredit);
		return typeCreditRepo.save(tc);

	}
	public TypeCredit changeTypeCreditpPartc(Long id, Double pPartCredit)
	{
		TypeCredit tc = new TypeCredit();
		tc = getTypeCreditById(id);
		tc.setpPartCredit(pPartCredit);
		return typeCreditRepo.save(tc);

	}

	public List<TypeCredit> getAllTypeCreditByStatus(int i) {
		return typeCreditRepo.findAllBySupprimer(1);
	}

}
