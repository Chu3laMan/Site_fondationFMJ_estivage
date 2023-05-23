package org.baeldung.service.publication;

import java.time.LocalDate;
import java.util.List;

import org.baeldung.persistence.dao.publication.AlbumRepository;
import org.baeldung.persistence.dao.publication.GalleryRepository;
import org.baeldung.persistence.model.publication.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {
	@Autowired
	private AlbumRepository albumRepo;
	@Autowired
	private GalleryRepository galleryRepo;
	
	public Album addAlbum(String name)
	{
		Album a = new Album(name,LocalDate.now().toString());
		return albumRepo.save(a);
	}
	
	public List<Album> getAllAlbums()
	{
		return albumRepo.findAll(Sort.by(Sort.Direction.DESC, "date"));
	}
	
	public Album getAlbumByname(String name)
	{
		return albumRepo.findByName(name);
	}
    public Album deleteAlbumAndAssociatedPicture(Long id) 
    {
    	Album album = albumRepo.findById(id).get();
    	galleryRepo.deleteInBatch(galleryRepo.findByAlbum(album));
    	Album a =  albumRepo.findById(id).get();
    	albumRepo.delete(a);
    	return a;
    }
}
