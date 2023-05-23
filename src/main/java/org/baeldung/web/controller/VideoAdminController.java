package org.baeldung.web.controller;

import java.util.List;

import org.baeldung.persistence.model.publication.Video;
import org.baeldung.service.publication.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class VideoAdminController {
	@Autowired
	private VideoService videoService;
	
	@GetMapping("/videoAdmin")
	public String showVideoAdministrationView(Model model)
	{
		List<Video> videos = videoService.getAllVideos();
		model.addAttribute("videos", videos);
		
		return "Admin/videoAdmin";
	}
	
	//administration side
	@RequestMapping(value = "/Admin/videoAdmin/saveVideo",method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	//@ResponseBody
	public String saveVideoo(@RequestParam("file") MultipartFile file,
			@RequestParam("description") String description)
	{
	   videoService.saveVideo(file, description); 
	   return "redirect:/videoAdmin";
	}
	
	@RequestMapping(value = "/Admin/videoAdmin/changeVideoStatus",method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Video changeVideoStatuss(@RequestParam("id") Long id,
			@RequestParam("status") int newStatus)
	{
		return videoService.changeVideoStatus(id, newStatus);
	}
	
	@RequestMapping(value = "/Admin/videoAdmin/deleteVideo/{id}",method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Video deleteVideoo(@PathVariable("id") Long id)
	{
		return videoService.deleteVideo(id);
	}
	

}
