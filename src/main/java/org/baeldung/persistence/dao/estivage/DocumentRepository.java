package org.baeldung.persistence.dao.estivage;

 


 

import org.baeldung.persistence.model.estivage.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface  DocumentRepository extends JpaRepository<Document, Integer> {
 

}