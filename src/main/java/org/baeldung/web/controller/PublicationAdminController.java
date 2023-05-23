package org.baeldung.web.controller;

import java.util.List;

import org.baeldung.persistence.model.publication.Publication;
import org.baeldung.service.publication.PublicationService;
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
public class PublicationAdminController {
	@Autowired
	private PublicationService publicationService;
	
	@GetMapping("/publication3Admin")
	public String showPublication3f(Model model)
	{
		List<Publication> publications = publicationService.getAllPublication();
		model.addAttribute("publications", publications);
		return "Admin/publication3Admin";
	}
	@RequestMapping(value = "/Admin/publication3Admin/savePublication",method = RequestMethod.POST)
	
	public String savePublication(@RequestParam("file") MultipartFile file
			,@RequestParam("publication") String publication)
	{
		 publicationService.savePublication(file, publication);
		 return "redirect:/publication3Admin";
	}
	
	@RequestMapping(value = "/Admin/publication3Admin/changePublicationStatus",method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Publication changePublicationStatus(@RequestParam("id") Long id,
			@RequestParam("status") int newStatus)
	{
		return publicationService.changePublicationStatus(id, newStatus);
	}
	
	@RequestMapping(value = "/Admin/publication3Admin/deletePublication/{id}",method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Publication deletePublication(@PathVariable("id") Long id) 
	{
		return publicationService.deletePublication(id);
	}
	
	
	@RequestMapping(value = "/Admin/publication3Admin/changeAtachmentFile",method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Publication changeAtachmentFile(@RequestParam("file") MultipartFile file,
			@RequestParam("id") Long id)
	{
		return  publicationService.changeAttachmentf(id, file);
	}
}
