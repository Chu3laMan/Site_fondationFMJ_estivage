package org.baeldung.persistence.dao.home;

import java.util.List;

import org.baeldung.persistence.model.home.SliderImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SliderImageRepositry extends JpaRepository<SliderImage, Long> {

	List<SliderImage> findByStatus(int status);
    SliderImage findByImageName(String imageName);
    void deleteByImageName(String imagName);
}
