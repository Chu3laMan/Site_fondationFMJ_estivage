package org.baeldung.service.transport;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.baeldung.persistence.dao.transport.TransportRepository;
import org.baeldung.persistence.model.transport.Transport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class TransportService {
	@Autowired
	private TransportRepository transportRepo;
	@Value("${extern.resoures.path}")
	private String DirPath;
	@Value("${extern.resources.DocsTargetDir}")
	private String DocstargetDir;
	
	public Transport addTransport(Optional<MultipartFile> file,MultipartFile image, 
			String type, String libelle,String commentaire,Optional<String> condition)
	{
		Transport t = new Transport();
		if(file.isPresent())
		{
			try {
				byte[] bytes = file.get().getBytes();
				Path targetPath = Paths.get(DirPath + File.separator + DocstargetDir + 
						File.separator + file.get().getOriginalFilename());
				Files.write(targetPath, bytes);
				t.setAttachmentURL(file.get().getOriginalFilename());
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
		t.setCommentaire(commentaire);
		if(condition.isPresent())
		  t.setCondition(condition.get());
		t.setDate(LocalDate.now().toString());
		try {
			t.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
		} catch (IOException e) {
		  e.printStackTrace();
		}
		t.setLibelle(libelle);
		t.setStatus(1);
		t.setType(type);
		return transportRepo.save(t);
	}
	
	public List<Transport> getAllTransport()
	{
		return transportRepo.findAll();
	}
	public List<Transport> getTransportByType(String type)
	{
		return transportRepo.findByType(type);
	}
	public List<Transport> getTransportByLibbelle(String libelle)
	{
		return transportRepo.findByLibelle(libelle);
	}
	
	public Transport changeImage(Long id ,MultipartFile image)
	{
		Transport t = transportRepo.findById(id).get();
		try {
			t.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
			return transportRepo.save(t);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Transport addOrChangeAttachment(Long id , MultipartFile file)
	{
		Transport t = transportRepo.findById(id).get();
		if (t.getAttachmentURL() == null) // we add the attachment file
		{

			try {
				byte[] bytes = file.getBytes();
				Path targetPath = Paths
						.get(DirPath + File.separator + DocstargetDir + File.separator + file.getOriginalFilename());
				Files.write(targetPath, bytes);
				t.setAttachmentURL(file.getOriginalFilename());
				return transportRepo.save(t);
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
		else { // we change the attachment file
			
			try {
				Path targetPathToDelete = Paths
						.get(DirPath + File.separator + DocstargetDir + File.separator + t.getAttachmentURL());
				File fileToDelete = new File(targetPathToDelete.toString());
				fileToDelete.delete();
				//save the new file
				byte[] bytes = file.getBytes();
				Path targetPathToSave = Paths
						.get(DirPath + File.separator + DocstargetDir + File.separator + file.getOriginalFilename());
				Files.write(targetPathToSave, bytes);
				t.setAttachmentURL(file.getOriginalFilename());
				return transportRepo.save(t);
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
	}
	
	public Transport changeComment(Long id,String commentaire)
	{
		Transport t = transportRepo.findById(id).get();
		t.setCommentaire(commentaire);
		return transportRepo.save(t);
		
	}
	public Transport changeStatus(Long id,int status)
	{
		Transport t = transportRepo.findById(id).get();
		t.setStatus(status);
		return transportRepo.save(t);
	}
	public Transport changeCondition(Long id , String condition)
	{
		Transport t = transportRepo.findById(id).get();
		t.setCondition(condition);
		return transportRepo.save(t);
	}
}
