package org.baeldung.persistence.dao.estivage;

 
import org.baeldung.persistence.model.estivage.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



 




public interface UsersRepository extends JpaRepository<Users, String> {
 
}