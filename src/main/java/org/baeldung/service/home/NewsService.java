package org.baeldung.service.home;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import org.baeldung.persistence.dao.home.NewsRepositry;
import org.baeldung.persistence.model.home.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class NewsService {
	@Autowired
    private NewsRepositry newsRepositry;
	@Value("${extern.resoures.path}")
	private String DirPath;
	@Value("${extern.resources.DocsTargetDir}")
	private String DocstargetDir;
	//fetch
	public List<News> getAllActiveNews(int status)
	{
		List<News> listOfNews = newsRepositry.findByStatus(status);
		return listOfNews;
	}
	public News getOneNews(Long id)
	{
		News singleNews = newsRepositry.findById(id).get();
		return singleNews;
	}
	
	public List<News> getAllNews()
	{
		return newsRepositry.findAll();
	}
	//save to dababase
	public News saveNews(Optional<MultipartFile> file, String description) throws IOException 
	{
		News news = new News();
		if(file.isPresent())
		{
			Path targetPath = Paths.get(DirPath + File.separator + DocstargetDir + 
					File.separator + file.get().getOriginalFilename());
			byte[] bytes = file.get().getBytes();
			Files.write(targetPath, bytes);
			news.setAttachmentURL(file.get().getOriginalFilename());
		}
		news.setDescription(description);
		news.setStatus(1);
		return newsRepositry.save(news);
	}
	//update
	public News updateNewsStatus(Long id , int status)
	{
		News news = new News();
		news =  getOneNews(id);
		news.setStatus(status);
		return newsRepositry.save(news);
	}
	 //delete
	public News deleteNews(Long id)
	{
	    
		News n = newsRepositry.findById(id).get();
	    newsRepositry.deleteById(id);
	    if(n.getAttachmentURL() != null)
	    {
	    	Path targetPath = Paths.get(DirPath + File.separator + DocstargetDir + 
					File.separator + n.getAttachmentURL());
	    	File file = new File(targetPath.toString());
	    	file.delete();
	    }
	    return n;
	}
	public void deleteMultipleNews(Iterable<News> news)
	{
		newsRepositry.deleteInBatch(news);
	}
	
}
