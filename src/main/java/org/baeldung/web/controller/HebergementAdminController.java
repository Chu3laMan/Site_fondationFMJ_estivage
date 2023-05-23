package org.baeldung.web.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
/**
 * 
 * @author Halim Zaaim
 *
 */
@Controller
public class HebergementAdminController {
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
	
	@GetMapping("/hebergementAdmin")
	public String getHebergmentAdminView(Model model)
	{
		
		List<Codification> codification = codificationService.getAllCodification();
		
		List<String> BankNames = codificationService.getListOfBanks();
		List<String> credit = codificationService.getListOfCredit();
		List<String> serviceBankLibelle  = codificationService.getSeriveBanklibelle();
		List<String> serviceImmobLibelle = codificationService.getListServiceImmob();
		List<String> produitImmobLibelle = codificationService.getListProduitImmob();
		List<String> serviceBankTachLibelle = codificationService.getListServiceBankTach();
		List<String> serviceBankTachLibelle2 = codificationService.getserviceBankTachLibelle();
		List<TypeCredit> typeCredit = typeCreditService.getAllTypeCredit();
		List<ServiceBank> serviceBank = serviceBankService.getAllServiceBank();
		List<ServiceImmob> serviceImmob = serviceImmobService.getAllServiceImmob();
		List<ServiceBankTach> serviceBankTach = serviceBankTachService.getAllServiceBankTach();
		model.addAttribute("BankNames", BankNames);
		model.addAttribute("credit", credit);
		model.addAttribute("serviceBankLibelle", serviceBankLibelle);
		model.addAttribute("serviceImmobLibelle",serviceImmobLibelle );
		model.addAttribute("produitImmobLibelle",produitImmobLibelle);
		model.addAttribute("serviceBankTachLibelle",serviceBankTachLibelle);
		model.addAttribute("serviceBankTachLibelle2", serviceBankTachLibelle2);
		model.addAttribute("codification",codification );
		model.addAttribute("serviceBank",serviceBank);
		model.addAttribute("serviceImmob", serviceImmob);
		model.addAttribute("typeCredit", typeCredit);
		model.addAttribute("serviceBankTach", serviceBankTach);
		return "Admin/hebergementAdmin";
	}
	
	/****************************** handling codification table ************************/
	@RequestMapping( value = "/Admin/hebergementAdmin/saveCodification" , method = RequestMethod.POST)
	public String saveCodification(@RequestParam("file") MultipartFile file,
			 @RequestParam("commentaire") String commentaire,
			 @RequestParam("libelle") String libelle,
			 @RequestParam("nomTable") String nomTable)
	{
		codificationService.saveCodification(file, commentaire, libelle, nomTable);
		return "redirect:/hebergementAdmin";
	}
	
	@RequestMapping( value = "/Admin/hebergementAdmin/changeCodImage" , method = RequestMethod.POST
			,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Codification changeCodiImage(@RequestParam("file")  MultipartFile file
			,@RequestParam("id") Long id)
	{
		return codificationService.changeImage(file,id);
	}
	
	@RequestMapping( value = "/Admin/hebergementAdmin/changeCodStatus" , method = RequestMethod.POST
			,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Codification changeCodStatus(@RequestParam("status") int status
			,@RequestParam("id") Long id)
	{
		return codificationService.changeCodificationStatus(id, status);
	}
	
	@RequestMapping( value = "/Admin/hebergementAdmin/changeCodComment" , method = RequestMethod.POST
			,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Codification changeCodComment(@RequestParam("id") Long id,
			@RequestParam("comment") String comment)
	{
		return codificationService.changeComent(id,comment);
	}
	/***********************************************************************************/
	/****************************** handling serviceBank table *************************/
	
	@RequestMapping( value = "/Admin/hebergementAdmin/saveServiceBank" , method = RequestMethod.POST
			,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ServiceBank saveServiceBank(@RequestParam("commentaire") String comment,
			@RequestParam("moda") Optional<String> period, 
			@RequestParam("faida") Optional<String> faida,
			@RequestParam("sakf") Optional<String> sakf,
			@RequestParam("bank") String libelleBank,
			@RequestParam("serviceBank") String libelleServiceBank)
	       
	{
		return serviceBankService.saveServiceBank(comment, faida, period, sakf, libelleBank, 
				libelleServiceBank);
	}
	
	//change comment
	@RequestMapping( value = "/Admin/hebergementAdmin/changesBankComment" , method = RequestMethod.POST
			,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ServiceBank changesBankComment(@RequestParam("id") Long id,
			@RequestParam("comment") String commentaire)
	{
		return serviceBankService.changeserviceBankComment(id, commentaire);
	}
	
	//change Moda 
	@RequestMapping( value = "/Admin/hebergementAdmin/changeModasBank" , method = RequestMethod.POST
			,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ServiceBank changeModasBank(@RequestParam("id") Long id,
			@RequestParam("moda") String moda)
	{
		return serviceBankService.changeServiceBankModa(id,moda);
	}
	
	//
	@RequestMapping( value = "/Admin/hebergementAdmin/changesBankFaida" , method = RequestMethod.POST
			,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ServiceBank changesBankFaida(@RequestParam("id") Long id,
			@RequestParam("faida") String faida)
	{
		return serviceBankService.changeServiceBankFaida(id,faida);
	}
	
	//change sakf
	@RequestMapping( value = "/Admin/hebergementAdmin/changsBankSakf" , method = RequestMethod.POST
			,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ServiceBank changsBankSakf(@RequestParam("id") Long id,
			@RequestParam("sakf") String sakf)
	{
		return serviceBankService.changeServiceBankSakf(id,sakf);
	}
	
	//change status 
	@RequestMapping( value = "/Admin/hebergementAdmin/changesBankStatus" , method = RequestMethod.POST
			,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ServiceBank changesBankStatus(@RequestParam("id") Long id,
			@RequestParam("status") int newStatus)
	{
		return serviceBankService.changeServiceBankSatatus(id, newStatus);
	}
	/***********************************************************************************/
	/****************************** handling serviceBnkTach table **********************/
	
	@RequestMapping( value = "/Admin/hebergementAdmin/saveServiceBankTach" , method = RequestMethod.POST
			,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	
	public ServiceBankTach saveServiceBankTach(@RequestParam("commentaire") String commentaire,
			@RequestParam("moda") Optional<String> moda,
			@RequestParam("hamichRib7") Optional<String> hamichRib7,
			@RequestParam("serviceBanklibelle") String serviceBanklibelle,
			@RequestParam("serviceBanktachLibelle") String serviceBanktachLibelle)
	{
		return serviceBankTachService.saveServiceBankTach(commentaire, hamichRib7, moda,
				serviceBanktachLibelle, serviceBanklibelle);
	}
	
    // change Comment
	@RequestMapping( value = "/Admin/hebergementAdmin/changesBankTachComment" , method = RequestMethod.POST
			,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ServiceBankTach changesBankTachComment(@RequestParam("id") Long id,
			@RequestParam("comment") String commentaire)
	{
		return serviceBankTachService.changeServiceBankTachCommet(id,commentaire);
	}
	
	//change moda
	@RequestMapping( value = "/Admin/hebergementAdmin/changesBankTachModa" , method = RequestMethod.POST
			,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ServiceBankTach changesBankTachModa(@RequestParam("id") Long id,
			@RequestParam("moda") String moda)
	{
		return serviceBankTachService.changeServiceBankTachModa(id,moda);
	}
	
	//change hamichRib7
	@RequestMapping( value = "/Admin/hebergementAdmin/changesBankTachRibh" , method = RequestMethod.POST
			,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ServiceBankTach changesBankTachRibh(@RequestParam("id") Long id ,
			@RequestParam("ribh") String hamichRib7)
	{
		return serviceBankTachService.changeServiceBankTachRibh(id,hamichRib7); 
	}
	
	//change status 
	@RequestMapping( value = "/Admin/hebergementAdmin/changeServiceBankTachStatus" , method = RequestMethod.POST
			,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ServiceBankTach changeServiceBankTachStatus(@RequestParam("id") Long id,
			@RequestParam("status") int newStatus)
	{
		return serviceBankTachService.changeServiceBankTachSatatus(id, newStatus);
	}
	
	/***********************************************************************************/
	/****************************** handling serviceImmob table ************************/
	
	@RequestMapping( value = "/Admin/hebergementAdmin/saveServiceImmob" , method = RequestMethod.POST
			,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ServiceImmob saveServiceBankImmob(@RequestParam("commentaire") String commentaire,
			@RequestParam("localisation") String localisation,
			@RequestParam("promotion") Optional<String> promotion,
			@RequestParam("produitImmobLibelle") String produitImmobLibelle,
			@RequestParam("serviceImmobLibelle") String serviceImmobLibelle)
	{
		return serviceImmobService.saveServiceImmob(commentaire, serviceImmobLibelle,produitImmobLibelle, 
				localisation, promotion);
	}
	
	//change status
	@RequestMapping( value = "/Admin/hebergementAdmin/changesImmobStaus" , method = RequestMethod.POST
			,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ServiceImmob changesImmobStaus(@RequestParam("id") Long id,
			@RequestParam("status") int newStatus)
	{
		return serviceImmobService.changeServiceImmobStatus(id, newStatus);
	}
	
	//change comment
	@RequestMapping( value = "/Admin/hebergementAdmin/changesImmobCommet" , method = RequestMethod.POST
			,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ServiceImmob changesImmobCommet(@RequestParam("id") Long id,
			@RequestParam("comment") String commentaire)
	{
		return serviceImmobService.changeServiceImmobComment(id,commentaire);
	}
	
	//change promotion 
	@RequestMapping( value = "/Admin/hebergementAdmin/changesImmobPrommotion" , method = RequestMethod.POST
			,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ServiceImmob changesImmobPrommotion(@RequestParam("id") Long id,
			@RequestParam("promotion") String promotion)
	{
		return serviceImmobService.changeServiceImmobPromotion(id,promotion);
	}
	
	//change Localization
	@RequestMapping( value = "/Admin/hebergementAdmin/changsImmobLocalisation" , method = RequestMethod.POST
			,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ServiceImmob changsImmobLocalisation(@RequestParam("id") Long id,
			@RequestParam("localisation") String localisation)
	{
		return serviceImmobService.changeServiceImmobLocalisation(id,localisation);
	}
	
	//change status
	@RequestMapping( value = "/Admin/hebergementAdmin/changesImmobStatus" , method = RequestMethod.POST
			,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ServiceImmob changesImmobStatus(@RequestParam("id") Long id,
			@RequestParam("status") int newStatus)
	{
		return serviceImmobService.changeServiceImmobStatus(id, newStatus);
	}
	/***********************************************************************************/
	/****************************** handling typeCredit table **************************/
	
	@RequestMapping( value = "/Admin/hebergementAdmin/saveTypeCredit" , method = RequestMethod.POST
			,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public TypeCredit saveTypeCredit(@RequestParam("commentaire") String commentaire,
			@RequestParam("pFullCredit") Double pFullCredit, 
			@RequestParam("pPartCredit") Double pPartCredit,
			@RequestParam("typeCredit") String libelleServiceBank, 
			@RequestParam("bank") String libelleBank)
	{
		return typeCreditService.saveTypeCredit(commentaire, pFullCredit, pPartCredit, libelleBank, libelleServiceBank);
	}
	
	@RequestMapping( value = "/Admin/hebergementAdmin/changeTypeCreditpFullCredit" , method = RequestMethod.POST
			,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public TypeCredit changepFullCredit(@RequestParam("pFullCredit") Double pFullCredit,
			@RequestParam("id") Long id)
	{
		return typeCreditService.changeTypeCreditpFullc(id, pFullCredit);
	}
	
	@RequestMapping( value = "/Admin/hebergementAdmin/changeTypeCreditpPartCredit" , method = RequestMethod.POST
			,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public TypeCredit changepPartCredit(@RequestParam("pPartCredit") Double pPartCredit,
			@RequestParam("id") Long id)
	{
		return typeCreditService.changeTypeCreditpPartc(id, pPartCredit);
	}
	
	@RequestMapping( value = "/Admin/hebergementAdmin/changeTypeCreditComent" , method = RequestMethod.POST
			,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public TypeCredit changeTypeCreditComment(@RequestParam("comment") String comment,
			@RequestParam("id") Long id)
    {
			return typeCreditService.changeTypeCreditComment(id, comment);
	}
	
	@RequestMapping( value = "/Admin/hebergementAdmin/changeTypeCreditStatus" , method = RequestMethod.POST
			,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public TypeCredit changeTypeCreditstatus(@RequestParam("id") Long id,
			@RequestParam("status") int newStatus)
	{
		return typeCreditService.changeTypeCreditStatus(id, newStatus);
	}
	/***********************************************************************************/
	

}
