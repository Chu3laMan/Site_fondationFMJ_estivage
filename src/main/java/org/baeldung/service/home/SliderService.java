package org.baeldung.service.home;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.baeldung.events.OnSliderImageSavedEvent;
import org.baeldung.persistence.dao.home.SliderImageRepositry;
import org.baeldung.persistence.model.home.SliderImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service

public class SliderService {

	@Autowired
	private SliderImageRepositry sliderImageRepo;
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;
	
	public void saveSliderImage(MultipartFile file, String description, Date dateOfExpiration) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			if (fileName.contains("..")) {
				// this need a exception handling
				System.out.println("file name contains invalide path" + fileName);
			}
			SliderImage sliderImage = new SliderImage();
			sliderImage.setDescription(description);
			sliderImage.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
			sliderImage.setImageName(fileName);
			sliderImage.setStatus(1);
			// convertion
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
			String dateTopersite = dateFormat.format(dateOfExpiration);
			sliderImage.setDateOfExperation(dateTopersite);
			LocalDate date = LocalDate.now();
			sliderImage.setDateOfInsertion(date.toString());
			sliderImageRepo.save(sliderImage);

			// publish the event of onsliderImageSaved
			LocalDate expireDate = LocalDate.parse(sliderImage.getDateOfExperation());
			publishOnSliderImageSaved(sliderImage, date, expireDate);

		} catch (Exception e) {
			// this need a exception handling
			System.out.println("could not save the file : " + fileName + " Exception !! :" + e);
		}

	}

	public Optional<SliderImage> getSliderImage(Long id) {
		try {
			return sliderImageRepo.findById(id);
		} catch (Exception e) {
			System.out.println("file not found :" + e);
			return null;
		}

	}

	// fetching from database
	public List<SliderImage> findAllActiveSlider(int status) {
		return sliderImageRepo.findByStatus(status);
	}

	// updating an image slider " updating the status"
	public SliderImage findImageSliderByName(String imageName) {
		return sliderImageRepo.findByImageName(imageName);
	}

	public SliderImage updateSliderImageStatus(String imageName, int status) {
		SliderImage sliderImage = new SliderImage();
		sliderImage = findImageSliderByName(imageName);
		sliderImage.setStatus(status);
		return sliderImageRepo.save(sliderImage);
	}

	public List<SliderImage> findAllImages() {

		return sliderImageRepo.findAll(Sort.by(Sort.Direction.DESC, "dateOfInsertion"));
	}

	public SliderImage deleteImageById(Long id) {
		SliderImage img = new SliderImage();
		img = sliderImageRepo.findById(id).get();
		sliderImageRepo.deleteById(id);
		return img;
	}

	public SliderImage changeImageExpireDate(Long imageid, Date dateOfExperation) {

		SliderImage img = new SliderImage();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		String strdateOfExperation = dateFormat.format(dateOfExperation);
		img = sliderImageRepo.findById(imageid).get();
		img.setDateOfExperation(strdateOfExperation);
		// Persist the updated image to database
		return sliderImageRepo.save(img);
	}
	
	/**********************************************
	 * HELPER
	 **********************************************/
	public void publishOnSliderImageSaved(SliderImage img, LocalDate insertionDate, LocalDate dateOfExperation) {

		applicationEventPublisher.publishEvent(new OnSliderImageSavedEvent(this, insertionDate,
				dateOfExperation/* .toInstant().atZone(ZoneId.systemDefault()).toLocalDate() */, img.getImageName()));
      System.out.println("event published ....");
	}
	@Async
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public SliderImage findImageByName(String imgName) {
		try {
			return sliderImageRepo.findByImageName(imgName);
		} catch (Exception e) {
			System.out.println("service methose error : " + e);
			e.printStackTrace();
			return null;
		}
	}
	
	@Async
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void saveimg(SliderImage img) {
		try {
			sliderImageRepo.save(img);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
