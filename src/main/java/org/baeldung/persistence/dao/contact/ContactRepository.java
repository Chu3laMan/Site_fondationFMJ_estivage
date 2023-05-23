package org.baeldung.persistence.dao.contact;

import java.util.List;

import org.baeldung.persistence.model.contact.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
	//list because one could contact us many times
	List<Contact> findByEmail(String email);

}
