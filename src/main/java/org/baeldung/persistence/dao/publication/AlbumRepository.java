package org.baeldung.persistence.dao.publication;

import org.baeldung.persistence.model.publication.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long>{
	
	Album findByName(String name);

}
