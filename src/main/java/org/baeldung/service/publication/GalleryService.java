package org.baeldung.service.publication;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;

import org.baeldung.persistence.dao.publication.AlbumRepository;
import org.baeldung.persistence.dao.publication.GalleryRepository;
import org.baeldung.persistence.model.publication.Album;
import org.baeldung.persistence.model.publication.Gallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class GalleryService {
	@Autowired
	private GalleryRepository galleryRepo;
	@Autowired
	private AlbumRepository albumRepo;
	
	public Gallery addImageToGallery(MultipartFile file , String description, String album)
	{
		Gallery g = new Gallery();
		Album a = albumRepo.findByName(album);
		g.setStatus(1);
		g.setDescription(description);
		g.setName(file.getOriginalFilename());
		g.setAlbum(a);
		g.setDate(LocalDate.now().toString());
		try {
			g.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return galleryRepo.save(g);
	}
	
	public Gallery deleteImage(Long id)
	{
		
		Gallery g = galleryRepo.findById(id).get();
	    galleryRepo.deleteById(id);
		return g;
	}
	public Gallery changeImageStatus(Long id, int status)
	{
		Gallery g = galleryRepo.findById(id).get();
		g.setStatus(status);
		return galleryRepo.save(g);
	}
	
	public List<Gallery> getActiveimages()
	{
		return galleryRepo.findByStatus(1,Sort.by(Sort.Direction.DESC, "date"));
	}
	
	public List<Gallery> getAllImages()
	{
		return galleryRepo.findAll(Sort.by(Sort.Direction.DESC, "date"));
	}
	public List<Gallery> getAllImagesOfAlbum(Long id)
	{
		Album album = albumRepo.findById(id).get();
		return (List<Gallery>) galleryRepo.findByAlbum(album);			
	}
}
