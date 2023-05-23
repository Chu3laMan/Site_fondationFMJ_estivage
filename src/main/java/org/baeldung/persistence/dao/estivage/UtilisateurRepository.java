package org.baeldung.persistence.dao.estivage;

 
import org.baeldung.persistence.model.estivage.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 


@Repository

public interface UtilisateurRepository extends JpaRepository<Utilisateur, String> {
 
}
