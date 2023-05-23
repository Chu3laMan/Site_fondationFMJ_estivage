package org.baeldung.persistence.dao.publication;

import java.util.List;

import org.baeldung.persistence.model.publication.Album;
import org.baeldung.persistence.model.publication.Gallery;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GalleryRepository extends JpaRepository<Gallery, Long> {
	List<Gallery> findByStatus(int status, Sort sort);
	Iterable<Gallery> findByAlbum(Album album);


}
