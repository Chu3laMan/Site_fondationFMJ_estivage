package org.baeldung.service.publication;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import org.baeldung.persistence.dao.publication.PublicationRepository;
import org.baeldung.persistence.model.publication.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PublicationService {
	@Autowired
	private PublicationRepository publicationRepo;
	@Value("${extern.resoures.path}")
	private String DirPath;
	@Value("${extern.resources.DocsTargetDir}")
	private String DocstargetDir;
	
	public Publication savePublication(MultipartFile file,
			String publication)
	{
		Publication pub = new Publication();
		if (file.isEmpty()) {
			throw new RuntimeException("Please load a doc file");
		}

		try {

			// Get the file and uploads it to "docs" dir
			byte[] bytes = file.getBytes();
			Path targetPath = Paths.get(DirPath + File.separator + DocstargetDir + 
					File.separator + file.getOriginalFilename());
			Files.write(targetPath, bytes);
			pub.setAtachmentURL(file.getOriginalFilename());
			pub.setPublication(publication);
			pub.setDate(LocalDate.now().toString());
			pub.setStatus(1);
			return publicationRepo.save(pub);

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public List<Publication> getActivePublication()
	{
		return publicationRepo.findByStatus(1);
	}
	public List<Publication> getAllPublication()
	{
		return publicationRepo.findAll();
	}
	public Publication changePublicationStatus(Long id, int newStatus)
	{
		Publication publication = publicationRepo.findById(id).get();
		publication.setStatus(newStatus);
		return publicationRepo.save(publication);
	}
	
	public Publication deletePublication(Long id) 
	{
		Publication publication = publicationRepo.findById(id).get();
		Path targetPath = Paths.get(DirPath + File.separator + DocstargetDir + 
				File.separator + publication.getAtachmentURL());
		File file = new File(targetPath.toString());
		try {
		    file.delete();
			publicationRepo.deleteById(id);
			return publication;
		 } catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Publication changeAttachmentf(Long id, MultipartFile file) {
		Publication pub = publicationRepo.findById(id).get();
		byte[] bytes = null;
		try {
			bytes = file.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		Path targetPath = Paths.get(DirPath + File.separator + DocstargetDir + 
				File.separator + pub.getAtachmentURL());
		File fileD = new File(targetPath.toString());
	    fileD.delete();
	    //write the new file
	    Path targetPathNew = Paths.get(DirPath + File.separator + DocstargetDir + 
				File.separator + file.getOriginalFilename());
	    try {
			Files.write(targetPathNew, bytes);
			pub.setAtachmentURL(file.getOriginalFilename());
			return publicationRepo.save(pub);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
