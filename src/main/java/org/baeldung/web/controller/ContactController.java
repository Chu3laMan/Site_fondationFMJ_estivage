package org.baeldung.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.baeldung.persistence.model.contact.Contact;
import org.baeldung.persistence.model.contact.ContactResponse;
import org.baeldung.service.contact.ContactResponseService;
import org.baeldung.service.contact.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ContactController {
	@Autowired
	private ContactService contactService;
	@Autowired
	private ContactResponseService contactResponseService;
	private final String CONTACT_TYPE="CONTACT";
	private final String CHIKAYA_TYPE="CHIKAYA";
	private final String FONDATION_EMAIL_TYPE="FONDATION_EMAIL";
	private int unreadEmail;
	
	/************************************** handling contact ************************/
	@PostMapping("/addContact")
	public String addContact(@RequestParam("nom") String nom,final HttpServletRequest request,
			@RequestParam("email") String email,
			@RequestParam("sujet") String sujet,
			@RequestParam("contenu") String contenu)
	{
		contactService.saveContact(nom, email, sujet, contenu,CONTACT_TYPE,request.getLocale());
		return "redirect:/contact.html";
	}
	
	@RequestMapping(value = "/changeContactStatus" , method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Contact changeContactStatus(@RequestParam("id") Long id)
	{
		return contactService.changeContactStatus(id);
	}
	                               
    /************************************ handling chikaya(complaint)**************/
	@PostMapping("/addChikaya")
	public String addChikaya(@RequestParam("nom") String nom,final HttpServletRequest request,
			@RequestParam("email") String email,
			@RequestParam("sujet") String sujet,
			@RequestParam("contenu") String contenu)
	{
		contactService.saveContact(nom, email, sujet, contenu,CHIKAYA_TYPE,request.getLocale());
		return "redirect:/publication5.html";
	}
	/************************************* Response *******************************/
	@PostMapping("/Admin/mail_compose/saveResponse")
	@ResponseBody
	public ContactResponse saveResponse(@RequestParam("contact_id") Long contact_id,
			@RequestParam("email") String email,
			@RequestParam("sujet") String sujet,
			@RequestParam("reponse") String reponse)
	{
	
		return contactResponseService.saveContactResponse(reponse, 
				email,contactService.getContactById(contact_id).getType()
				, contact_id);
	}
	/******************************************************************************/
	
	/******************************** administration side ************************/
	@GetMapping("/mailbox")
	public String showMailBox(Model model)
	{
		List<Contact> contacts = contactService.getAllContacts();
		List<Contact> result = new ArrayList<Contact>();
		for(Contact contact: contacts)
		{
			if(contact.getLire() == 0)
			{
				result.add(contact);
			}
		}
		this.unreadEmail = result.size();
		model.addAttribute("contacts", contacts);
		model.addAttribute("unreadEmail",unreadEmail);
		return "Admin/mailbox.html";
	}
	
	@GetMapping("/Admin/mail_detail/view/{id}")
	public String showEmailDetail(@PathVariable("id") Long id,Model model)
	{
		
		Contact contact = new Contact();
		this.unreadEmail--;
		contact =  contactService.getContactById(id);
		contact.setLire(1);
		contactService.saveContact(contact);
		model.addAttribute("contact", contact);
		if(this.unreadEmail > 0)
		    model.addAttribute("unreadEmail",unreadEmail);
		  
		else {
			 model.addAttribute("unreadEmail",0);
		     this.unreadEmail = 0;
		}
		return "Admin/mail_detail.html";
	}
	
	@GetMapping("/Admin/mail_compose/replay/{id}")
	public String showMailCompose(@PathVariable("id") Long id,Model model)
	{
		Contact contact = new Contact();int var = 1;
		contact =  contactService.getContactById(id);
		model.addAttribute("contact", contact);
		model.addAttribute("var", var);
		return "Admin/mail_compose.html";
	}
	
	@GetMapping("/mail_compose")
	public String sendEmail(Model model)
	{
		int var = 0;
		model.addAttribute("var", var);
	  return "Admin/mail_compose.html";
	}
	@GetMapping("/Admin/mail_detail/delete/{id}")
	public String deleteContact(@PathVariable("id") Long id)
	{
		contactService.deteleContactById(id);
		return "redirect:/mailbox";
	}
	/****************************** Foundation email ********************************/
	@PostMapping("/Admin/mail_compose/saveFondationEmail")
	@ResponseBody
	public ContactResponse saveFondationEmail(@RequestParam("email") String email,
			@RequestParam("sujet") String sujet,
			@RequestParam("emailBody") String emailBody)
	{
		return contactResponseService.saveFondationEmail(email,sujet,emailBody,FONDATION_EMAIL_TYPE);
	}
}
