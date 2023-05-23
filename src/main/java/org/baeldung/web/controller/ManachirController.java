package org.baeldung.web.controller;

import java.util.List;

import org.baeldung.persistence.model.publication.Manachir;
import org.baeldung.service.publication.ManachirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManachirController {
	
	@Autowired
	private ManachirService manachirService;
	
	@GetMapping("/publication2.html")
	public String showPublication(Model model)
	{
		List<Manachir> manachirs =  manachirService.getAllActiveM();
		model.addAttribute("manachirs",  manachirs);
		return "/publication2.html";
	}

}
