package org.baeldung.persistence.dao.estivage;
 
import org.baeldung.persistence.model.estivage.Invite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface  InviteRepository extends JpaRepository<Invite, Integer> {
 
}
