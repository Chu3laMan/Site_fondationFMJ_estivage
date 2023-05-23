package org.baeldung.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.baeldung.persistence.model.publication.Gallery;
import org.baeldung.service.publication.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class GalleryController {
	
	@Autowired
	private GalleryService galleryService;

	@GetMapping("/galerie_photos.html")
	public String showGalleryView(Model model)
	{
		List<Gallery> imagesList = galleryService.getActiveimages();
		List<Gallery> images = imagesList.stream().reduce(new ArrayList<>(),
				(List<Gallery> accumulator, Gallery gallery) -> {
					if (accumulator.stream().noneMatch(g -> g.getAlbum().equals(gallery.getAlbum()))) {
						accumulator.add(gallery);
					}
					return accumulator;
				}, (acc1, acc2) -> {
					acc1.addAll(acc2);
					return acc1;
				});
		model.addAttribute("images",images);
		return "/galerie_photos.html";
	}
	//get Images for carousel 
	@RequestMapping(value = "/galerie_photos/getImages/{id}" , method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<Gallery> getImagesForCarousel(@PathVariable("id") Long id)
	{
		return galleryService.getAllImagesOfAlbum(id);
	}

}
