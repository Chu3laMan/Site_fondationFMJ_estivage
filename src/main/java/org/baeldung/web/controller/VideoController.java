package org.baeldung.web.controller;

import java.util.List;

import org.baeldung.persistence.model.publication.Video;
import org.baeldung.service.publication.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VideoController {
	@Autowired
	private VideoService videoService;
	
	@GetMapping("/videos.html")
	public String showVideoView(Model model)
	{
		 List<Video> videos = videoService.getActiveVideos();
		 model.addAttribute("videos", videos);
		return "videos.html";
	}

}
