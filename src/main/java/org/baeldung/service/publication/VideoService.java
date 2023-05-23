package org.baeldung.service.publication;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.baeldung.persistence.dao.publication.VideoRepository;
import org.baeldung.persistence.model.publication.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class VideoService {
	@Autowired
	private VideoRepository videoRepo;
	@Value("${extern.resoures.path}")
	private String DirPath;
	@Value("${extern.resources.videoTargetDir}")
	private String VideostargetDir;
	public Video saveVideo(MultipartFile file, String description) {
		Video video = new Video();
		if (file.isEmpty()) {
			throw new RuntimeException("Please load a video file");
		}

		try {

			// Get the file and save it uploads to "videos" dir
			byte[] bytes = file.getBytes();
			Path targetPath = Paths.get(DirPath + File.separator + VideostargetDir + 
					File.separator + file.getOriginalFilename());
			Files.write(targetPath, bytes);
			LocalDate date = LocalDate.now();
			video.setDate(date.toString());
			video.setVideoURL(file.getOriginalFilename());
			video.setDescription(description);
			video.setStatus(1);
			video.setType(getFileExtension(file.getOriginalFilename()).get());
		    return videoRepo.save(video);

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public Video deleteVideo(Long id)
	{
		Video video = videoRepo.findById(id).get();
		Path targetPath = Paths.get(DirPath + File.separator + VideostargetDir + 
				File.separator + video.getVideoURL());
		File file = new File(targetPath.toString());
		try {
			file.delete();
			videoRepo.delete(video);
			return video;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Video> getActiveVideos()
	{
	  return videoRepo.findByStatus(1);	
	}
	public List<Video> getAllVideos()
	{
		return videoRepo.findAll();
	}
   public Video changeVideoStatus(Long id , int newStatus)
   {
	   Video video = videoRepo.findById(id).get();
	   video.setStatus(newStatus);
	   return videoRepo.save(video);
   }
   
   //get the file extension 
   public Optional<String> getFileExtension(String filename) {
	    return Optional.ofNullable(filename)
	      .filter(f -> f.contains("."))
	      .map(f -> f.substring(filename.lastIndexOf(".") + 1));
	}
}
