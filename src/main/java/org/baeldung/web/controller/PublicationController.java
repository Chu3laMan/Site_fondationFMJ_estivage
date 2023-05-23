package org.baeldung.web.controller;

import java.util.List;

import org.baeldung.persistence.model.publication.Publication;
import org.baeldung.service.publication.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicationController {
	@Autowired
	private PublicationService publicationService;
	
	@GetMapping("/publication3.html")
	public String showPublicationView(Model model)
	{
		List<Publication> publications = publicationService.getActivePublication();
		model.addAttribute("publications", publications);
		return "publication3.html";
	}

}
