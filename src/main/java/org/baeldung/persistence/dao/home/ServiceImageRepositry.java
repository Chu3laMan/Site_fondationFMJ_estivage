package org.baeldung.persistence.dao.home;

import org.baeldung.persistence.model.home.ServiceImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceImageRepositry extends JpaRepository<ServiceImage, Long> {
	ServiceImage findByImageName(String imageName);
	void deleteByImageName(String imagName);
	/*@Modifying
	@Query("update ServiceImage simg set simg.imageName = ?1 , simg.service_image= ?2 where u.id = ?3")
	void updateServiceImage(String imageName, String service_image,Long id);*/
}
