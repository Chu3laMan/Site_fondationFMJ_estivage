package org.baeldung.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.baeldung.persistence.model.home.News;
import org.baeldung.persistence.model.home.ServiceImage;
import org.baeldung.persistence.model.home.SliderImage;
import org.baeldung.service.home.NewsService;
import org.baeldung.service.home.ServiceImageService;
import org.baeldung.service.home.SliderService;
import org.baeldung.web.util.imageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class AdminIndex {
	@Autowired
	private NewsService newsService;
	@Autowired
	private SliderService sliderService;
	@Autowired
	private ServiceImageService serviceImageService;

	// for the administration side
	/**
	 * @param model
	 * @return
	 */
	@GetMapping("/index")
	public String getSliderImagesForAdminitrationSide(Model model) {

		List<imageHelper> divHelper = new ArrayList<>();
		List<ServiceImage> imageService = serviceImageService.getAllServiceImages();

		List<SliderImage> images = sliderService.findAllImages();
		int counter = 0;
		for (int i = 0; i <= images.size(); i++) {
			imageHelper nb = new imageHelper();
			nb.setCounter1(counter);
			nb.setCounter2(nb.getCounter1() + 1000);
			divHelper.add(nb);
			counter++;
		}
		// News
		List<News> news = newsService.getAllNews();
		model.addAttribute("images", images);
		model.addAttribute("divHelper", divHelper);
		model.addAttribute("news", news);
		model.addAttribute("imageService", imageService);
		return "Admin/index";
	}

}
