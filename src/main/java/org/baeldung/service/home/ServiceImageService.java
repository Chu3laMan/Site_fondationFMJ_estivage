package org.baeldung.service.home;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.baeldung.persistence.dao.home.ServiceImageRepositry;
import org.baeldung.persistence.model.home.ServiceImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ServiceImageService {

	@Autowired
	private ServiceImageRepositry  serviceImageRepo;
	
	public ServiceImage saveAserviceImage(MultipartFile file, String serviceName)
	{
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		try {
			if (fileName.contains("..")) {
				// this need a exception handling
				System.out.println("file name contains invalide path" + fileName);
			}
			ServiceImage serviceImage = new ServiceImage();
			serviceImage.setImageName(fileName);
			serviceImage.setService_image(Base64.getEncoder().encodeToString(file.getBytes()));
			serviceImage.setServiceName(serviceName);
			return serviceImageRepo.save(serviceImage);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public List<ServiceImage> getAllServiceImages()
	{
		return serviceImageRepo.findAll();
	}
	public Optional<ServiceImage> getserviceImageById(Long id)
	{
		return serviceImageRepo.findById(id);
	}
	public void deleteServiceImageById(Long id)
	{
		serviceImageRepo.deleteById(id);
	}
	public ServiceImage getServiceImageByImageName(String imageName)
	{
		return serviceImageRepo.findByImageName(imageName);
	}
	public ServiceImage updateServiceImage(Long id,MultipartFile newfile)
	{
		ServiceImage imageToUpdate = serviceImageRepo.findById(id).get();
		try {
			imageToUpdate.setImageName(StringUtils.cleanPath(newfile.getOriginalFilename()));
			imageToUpdate.setService_image(Base64.getEncoder().encodeToString(newfile.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*
		 * the save will only update the existent image because
		 * we keep the same id
		 */
		return serviceImageRepo.save(imageToUpdate);
		
	}

	public Long deleteServiceImage(Long id)
	{
		serviceImageRepo.deleteById(id);
		return id;
	}
}
