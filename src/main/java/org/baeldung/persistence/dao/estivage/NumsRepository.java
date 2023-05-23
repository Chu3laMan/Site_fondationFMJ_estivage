package org.baeldung.persistence.dao.estivage;

 
import org.baeldung.persistence.model.estivage.Nums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface  NumsRepository extends JpaRepository<Nums, Integer> {
 
}
