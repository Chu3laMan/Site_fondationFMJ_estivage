package org.baeldung.service.contact;

import java.time.LocalDate;

import org.baeldung.persistence.dao.contact.ResponseRepository;
import org.baeldung.persistence.model.contact.ContactResponse;
import org.baeldung.service.MailClient;
import org.baeldung.web.util.MailContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ContactResponseService {
	@Autowired
	private ResponseRepository responseRepo;
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private Environment env;
	@Autowired
    private MailClient mailClient;

	public ContactResponse saveContactResponse(String reponse, String emailClient, String type, Long idContact) {
		ContactResponse cr = new ContactResponse();
		LocalDate reponseDate = LocalDate.now();
		// cr.setIdAdmin(idAdmin);
		cr.setIdContact(idContact);
		cr.setReponse(reponse);
		cr.setReponseDate(reponseDate.toString());
		cr.setType(type);
		// send email here
		sendEmail(emailClient, reponse, "الإجابة عن طلبكم");
		return responseRepo.save(cr);
	}

	public ContactResponse saveFondationEmail(String email, String sujet, String emailBody, String type) {

		ContactResponse cr = new ContactResponse();
		LocalDate reponseDate = LocalDate.now();
		// cr.setIdAdmin(idAdmin);
		// cr.setIdContact(idContact);
		cr.setReponse(emailBody);
		cr.setReponseDate(reponseDate.toString());
		cr.setType(type);
		cr.setDistinataire(email);
		sendEmail(email, emailBody, sujet);
		return responseRepo.save(cr);
	}

	private void sendEmail(String email, String text, String sujet) {
		MailContent mailContent = new MailContent(null, sujet,null, "https://lh3.googleusercontent.com/Y5C3-CSoyp6UDu9KDSW93G1tsNgeEe75VvsZbdtLax6hIb8GKbqYbIJ-_tsasyVHI1odZXJ0QJiVisWVMQ2_u0KxwkrXiMNX-5ivedXRQcLr_VjJe9lh-3rDfAqWnp-n-Vi21vI2=w2400");
		String[] bodyMessages = {text};
		mailContent.buildListOfBodyContent(bodyMessages);
		mailContent.defaultFootter();
		mailClient.prepareAndSendCustom(email, mailContent);

	}
}
