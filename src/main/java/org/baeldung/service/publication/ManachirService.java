package org.baeldung.service.publication;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import org.baeldung.persistence.dao.publication.ManachirRepository;
import org.baeldung.persistence.model.publication.Manachir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ManachirService {
	@Autowired
	private ManachirRepository manachirRepo;
	@Value("${extern.resoures.path}")
	private String DirPath;
	@Value("${extern.resources.DocsTargetDir}")
	private String DocstargetDir;
	public Manachir addManchor(MultipartFile file , String menchor)
	{
		Path targetPath = Paths.get(DirPath + File.separator + DocstargetDir + 
				File.separator + file.getOriginalFilename());
		Manachir mn = new Manachir();
		
		try {
			byte[] bytes = file.getBytes();
			Files.write(targetPath, bytes);
			mn.setAttachmentURL(file.getOriginalFilename());
			mn.setDate(LocalDate.now().toString());
			mn.setMenchor(menchor);
			mn.setStatus(1);
			return manachirRepo.save(mn);
		} catch (IOException e) {
			System.out.println("failed !!");
			e.printStackTrace();
			return null;
		}
	}
    
	public Manachir changeMenchorStatus(Long id, int status)
	{
		Manachir mn = manachirRepo.findById(id).get();
		mn.setStatus(status);
		return manachirRepo.save(mn);
	}
	
	public Manachir deleteMenchor(Long id)
	{
		Manachir mn = manachirRepo.findById(id).get();
		Path targetPath = Paths.get(DirPath + File.separator + DocstargetDir + 
				File.separator + mn.getAttachmentURL());
		File file = new File(targetPath.toString());
		try {
			file.delete();
			manachirRepo.deleteById(id);
			return mn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Manachir> getAllActiveM()
	{
		return manachirRepo.findByStatus(1,Sort.by(Sort.Direction.DESC, "date"));
	}
	public List<Manachir> getAllManachir()
	{
		return manachirRepo.findAll(Sort.by(Sort.Direction.DESC, "date"));
	}

	public Manachir changeAttachmentFile(MultipartFile file, Long id) {
		Manachir mn = manachirRepo.findById(id).get();
		Path targetPath = Paths.get(DirPath + File.separator + DocstargetDir + 
				File.separator + mn.getAttachmentURL());
		File fileD = new File(targetPath.toString());
		try {
			fileD.delete();
			manachirRepo.deleteById(id);
			
			Path targetPathTosave = Paths.get(DirPath + File.separator + DocstargetDir + 
					File.separator + file.getOriginalFilename());
			byte[] bytes = file.getBytes();
			Files.write(targetPathTosave, bytes);
			mn.setAttachmentURL(file.getOriginalFilename());
			return mn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
