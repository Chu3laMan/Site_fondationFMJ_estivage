package org.baeldung.persistence.dao.publication;

import java.util.List;

import org.baeldung.persistence.model.publication.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
	List<Video> findByStatus(int status);

}
