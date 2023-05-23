package org.baeldung.persistence.dao.contact;

import java.util.List;

import org.baeldung.persistence.model.contact.ContactResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseRepository extends JpaRepository<ContactResponse, Long> {
	ContactResponse findByIdContact(Long idContact);
	//find contacts a particular Admin has replayed 
	List<ContactResponse> findByIdAdmin(Long idAdmin);

}
