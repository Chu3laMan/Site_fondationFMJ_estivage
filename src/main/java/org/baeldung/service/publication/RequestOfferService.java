package org.baeldung.service.publication;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import org.baeldung.persistence.dao.publication.RequestOfferRepository;
import org.baeldung.persistence.model.publication.RequestOffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class RequestOfferService {
	@Autowired
	private RequestOfferRepository requestOfferRepo;
	@Value("${extern.resoures.path}")
	private String DirPath;
	@Value("${extern.resources.DocsTargetDir}")
	private String DocstargetDir;
	public RequestOffer saveRequestOffer(MultipartFile file,String titre,String offer
			,String externLink) 
	{
		RequestOffer rf = new RequestOffer();
		if (file.isEmpty()) {
			throw new RuntimeException("Please load a doc file");
		}
		try {
			byte[] bytes = file.getBytes();
			Path targetPath = Paths.get(DirPath + File.separator + DocstargetDir + 
					File.separator + file.getOriginalFilename());
			Files.write(targetPath, bytes);
			rf.setAttachmentURL(file.getOriginalFilename());
			rf.setDate(LocalDate.now().toString());
			rf.setExternLink(externLink);
			rf.setOffer(offer);
			rf.setStatus(1);
			rf.setTitre(titre);
			return requestOfferRepo.saveAndFlush(rf);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
    
	public List<RequestOffer> getAllRequestOffer()
	{
		  return requestOfferRepo.findAll();
	}
	public List<RequestOffer> getAllActiveRequestOffer()
	{
		 return requestOfferRepo.findByStatus(1);
	}
	public RequestOffer changeOfferStatus(Long id , int status)
	{
		RequestOffer rf = requestOfferRepo.findById(id).get();
		rf.setStatus(status);
		return requestOfferRepo.save(rf);
	}
	
	public RequestOffer deleteRequestOffer(Long id)
	{
		RequestOffer rf = requestOfferRepo.findById(id).get();
	   requestOfferRepo.deleteById(id);
	   return rf;
	}
	
	public RequestOffer changeAttachmentFile(Long id , MultipartFile file)
	{
		RequestOffer rf = requestOfferRepo.findById(id).get();
		byte[] bytes = null;
		try {
			bytes = file.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		Path targetPath = Paths.get(DirPath + File.separator + DocstargetDir + 
				File.separator + rf.getAttachmentURL());
		File fileD = new File(targetPath.toString());
	    fileD.delete();
	    
	    Path targetPathNew = Paths.get(DirPath + File.separator + DocstargetDir + 
				File.separator + file.getOriginalFilename());
		try {
			Files.write(targetPathNew, bytes);
			rf.setAttachmentURL(file.getOriginalFilename());
			return requestOfferRepo.save(rf);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
