package org.baeldung.web.controller;

import java.util.List;

import org.baeldung.persistence.model.hebergement.Codification;
import org.baeldung.persistence.model.hebergement.ServiceBank;
import org.baeldung.persistence.model.hebergement.ServiceBankTach;
import org.baeldung.persistence.model.hebergement.ServiceImmob;
import org.baeldung.persistence.model.hebergement.TypeCredit;
import org.baeldung.service.hebergement.CodificationService;
import org.baeldung.service.hebergement.ServiceBankService;
import org.baeldung.service.hebergement.ServiceBankTachService;
import org.baeldung.service.hebergement.ServiceImmobService;
import org.baeldung.service.hebergement.TypeCreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HebergementController {
	@Autowired
	private CodificationService codificationService;
	@Autowired
	private ServiceBankService serviceBankService;
	@Autowired
	private ServiceBankTachService serviceBankTachService;
	@Autowired 
	private ServiceImmobService serviceImmobService;
	@Autowired
	private TypeCreditService typeCreditService;
	
	@GetMapping("/hebergem.html")
	public String getHebergementView(Model model)
	{
		//return only the activated service ...
		List<Codification> codification = codificationService.getAllCodificationByStatus(1);
		List<ServiceBank> serviceBank = serviceBankService.getAllServiceBankByStatus(1);
		List<ServiceBankTach> serviceBanktach = serviceBankTachService.getAllServiceBankTachByStatus(1);
		List<ServiceImmob> serviceImmob = serviceImmobService.getAllServiceImmobByStatus(1);
		List<TypeCredit> typeCredit = typeCreditService.getAllTypeCreditByStatus(1);
		model.addAttribute("codification",codification );
		model.addAttribute("serviceBank", serviceBank);
		model.addAttribute("serviceBanktach",serviceBanktach);
		model.addAttribute("serviceImmob",serviceImmob);
		model.addAttribute("typeCredit",typeCredit);
		return "/hebergem.html";
	}

}
