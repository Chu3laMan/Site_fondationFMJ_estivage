package org.baeldung.web.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.baeldung.persistence.model.home.News;
import org.baeldung.persistence.model.home.ServiceImage;
import org.baeldung.persistence.model.home.SliderImage;
import org.baeldung.service.home.NewsService;
import org.baeldung.service.home.ServiceImageService;
import org.baeldung.service.home.SliderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(method = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT})
public class HomeAdministrationController {
	
	@Autowired
	private NewsService newsService;
    @Autowired
    private SliderService sliderService;
    @Autowired 
    private ServiceImageService serviceImageService;
    
	@RequestMapping(value = "/Admin/index/uploadNews",method = RequestMethod.POST,
			 produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public News saveNews(@RequestParam("file") Optional<MultipartFile> file ,@RequestParam("description") String description) throws IOException
	{
		return newsService.saveNews(file,description);
		//return "redirect:/form_file_upload";
	}
	
	@RequestMapping(value = "/Admin/index/changeNewsStatus", method = RequestMethod.POST,
			 produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public News changeNewsStatus(@RequestParam("newsId") Long newsId
			,@RequestParam("status") int status)
	{
		return newsService.updateNewsStatus(newsId, status);
		//return "redirect:/form_file_upload";
	}
	
	@RequestMapping( value = "/Admin/index/deleteNews/{id}",method = RequestMethod.GET,
			 produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public News deleteNews(@PathVariable("id") Long id)
	{
		return newsService.deleteNews(id);
	}
	
	/*
	 * get all News to be diplayed in the view
	 */
	@GetMapping("/news")
	public ModelAndView getNews()
	{
		ModelAndView model = new ModelAndView();
		List<News> news = newsService.getAllActiveNews(1);
		model.setViewName("home.html");
		model.addObject("news", news);
		return model;
	}
 /************************************ SLIDER *****************************************/
	@PostMapping("/Admin/index/uploadImage")
    public String uploadImage(@RequestParam("imageDescriptoion") String description,@RequestParam("dateOfExpiration") 
    @DateTimeFormat(pattern = "yyyy-mm-dd") Date dateOfExpiration,
     @RequestParam("imagefile") MultipartFile imagefile) 
      throws IOException {
    	sliderService.saveSliderImage(imagefile,description,dateOfExpiration);
        return "redirect:/index";
    } 
	
	/*
	 * problem to fix !
	 * when there is miltiple image with the same name!
	 */
	@RequestMapping(value = "/Admin/index/changeSliderImageStatus", method = RequestMethod.POST,
			 produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public SliderImage changeSliderImageStatus(@RequestParam("imageName") String imageName
			,@RequestParam("status") int status)
	{
		return sliderService.updateSliderImageStatus(imageName, status);
		//return "redirect:/form_file_upload";
	}
	
	
	//change the image date of expire date
	@RequestMapping(value = "/Admin/index/changeSliderImageDateofExpireDate",method = RequestMethod.POST,
			 produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public SliderImage changeSliderImageDateofExpireDate(@RequestParam("imageid") Long imageid,
			@RequestParam("dateOfExperation") @DateTimeFormat(pattern = "yyyy-mm-dd") Date dateOfExperation)
	{
		return sliderService.changeImageExpireDate(imageid,dateOfExperation);
		//return "redirect:/form_file_upload";	
	}
	
	
  
	//deleting image by id 
	@RequestMapping( value = "/Admin/index/deleteImage/{id}",method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public SliderImage deleteImage(@PathVariable("id") Long id )
	{
		return sliderService.deleteImageById(id);
		//return "redirect:/form_file_upload";
	}
	
	/***************************** Service Images ******************************************/
	@RequestMapping( value = "/Admin/index/saveSeriveImage",method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ServiceImage saveSeriveImage(@RequestParam("file") MultipartFile file,
			@RequestParam("serviceName") String serviceName)
	{
		return serviceImageService.saveAserviceImage(file ,serviceName);
	}
	
	@RequestMapping( value = "/Admin/index/updateServiceImage",method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ServiceImage updateServiceImage(@RequestParam("id") Long id, 
			@RequestParam("newfile") MultipartFile newfile)
	{
		return serviceImageService.updateServiceImage(id, newfile);
	}
	
	@RequestMapping( value = "/Admin/index/deleteServiceImage/{id}",method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Long deleteServiceImage(@PathVariable("id") Long id)
	{
		return serviceImageService.deleteServiceImage(id);
	}
}
