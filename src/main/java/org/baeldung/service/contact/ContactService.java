package org.baeldung.service.contact;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import org.baeldung.persistence.dao.contact.ContactRepository;
import org.baeldung.persistence.model.contact.Contact;
import org.baeldung.service.MailClient;
import org.baeldung.web.util.MailContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
	@Autowired
	private ContactRepository contactRepo;
	@Autowired
	private MessageSource messages;
	@Autowired
    private MailClient mailClient;

	public Contact saveContact(String nom, String email, String sujet, 
			String contenu, String type,Locale locale) {
		Contact c = new Contact();
		LocalDate date = LocalDate.now();
		c.setContenu(contenu);
		c.setDate(date.toString());
		c.setEmail(email);
		c.setSujet(sujet);
		c.setNom(nom);
		c.setLire(0); // 0 not read yet : 1 read
		c.setType(type);
		System.out.println(messages.getMessage("user.contact.demand.message", null, locale));
		final String message = messages.getMessage("user.contact.demand.message", null, locale);
		final String subject = messages.getMessage("user.contact.demand.subject", null,locale);
		sendEmail(email, message, subject);
		return contactRepo.save(c);
	}

	public Contact changeContactStatus(Long id) {
		Contact c = new Contact();
		c = contactRepo.findById(id).get();
		c.setLire(0);
		return contactRepo.save(c);
	}

	public Contact getContactById(Long id) {
		return contactRepo.findById(id).get();
	}

	public List<Contact> getAllContacts() {
		return contactRepo.findAll(Sort.by(Sort.Direction.DESC, "date"));
	}

	public void saveContact(Contact contact) {

		contactRepo.save(contact);
	}

	public void deteleContactById(Long id) {
		contactRepo.deleteById(id);

	}

	private void sendEmail(String email, String text, String sujet) {

		MailContent mailContent = new MailContent(null, sujet,null, "https://lh3.googleusercontent.com/Y5C3-CSoyp6UDu9KDSW93G1tsNgeEe75VvsZbdtLax6hIb8GKbqYbIJ-_tsasyVHI1odZXJ0QJiVisWVMQ2_u0KxwkrXiMNX-5ivedXRQcLr_VjJe9lh-3rDfAqWnp-n-Vi21vI2=w2400");
		String[] bodyMessages = {text};
		mailContent.buildListOfBodyContent(bodyMessages);
		mailContent.defaultFootter();
		mailClient.prepareAndSendCustom(email, mailContent);
	}
}
