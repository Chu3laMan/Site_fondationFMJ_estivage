package org.baeldung.web.controller;

import java.util.List;
import org.baeldung.persistence.model.publication.Album;
import org.baeldung.persistence.model.publication.Gallery;
import org.baeldung.service.publication.AlbumService;
import org.baeldung.service.publication.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class GalleryAdminController {
	
	@Autowired
	private GalleryService galleryService;
	@Autowired
	private AlbumService albumService;
	
	@GetMapping("/galleryAdmin")
	public String showgalleryAdmin(Model model)
	{
		List<Gallery> images = galleryService.getAllImages();
		List<Album> albums = albumService.getAllAlbums();
		model.addAttribute("images",images);
		model.addAttribute("albums",albums);
		return "Admin/galleryAdmin";
	}
	//add album
	@PostMapping("/Admin/galleryAdmin/saveAlbum")
	public String saveAlbum(@RequestParam("name") String name)
	{
		albumService.addAlbum(name);
		return "redirect:/galleryAdmin";
	}
	@RequestMapping(value = "/Admin/galleryAdmin/saveImageToGallery" , method = RequestMethod.POST)
	public String saveImageToGallery(@RequestParam("file") MultipartFile file,
			@RequestParam("description") String description
			,@RequestParam("album") String album)
	{
		galleryService.addImageToGallery(file, description,album);
		return "redirect:/galleryAdmin";
	}
	
	@RequestMapping(value = "/galleryAdmin/deleteImageFormGallery/{id}" , method = RequestMethod.GET)
	@ResponseBody
	public Gallery deleteImageFormGallery(@PathVariable("id") Long id)
	{
		return galleryService.deleteImage(id);
	}
	
	@RequestMapping(value = "/Admin/galleryAdmin/changeImageGStatus" , method = RequestMethod.POST)
	@ResponseBody
	public Gallery changeImageGStatus(@RequestParam("id") Long id, 
			@RequestParam("status") int status)
	{
		return galleryService.changeImageStatus(id, status);
	}
	@RequestMapping(value = "/galleryAdmin/deleteAlbum/{id}" , method = RequestMethod.GET)
	@ResponseBody
    public Album deleteAlbum(@PathVariable("id") Long id)
    {
		return albumService.deleteAlbumAndAssociatedPicture(id);
    }
}