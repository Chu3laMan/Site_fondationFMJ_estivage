package org.baeldung.web.controller;

import java.util.List;

import org.baeldung.persistence.model.publication.Manachir;
import org.baeldung.service.publication.ManachirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
public class ManachirAdminController {
	@Autowired
	private ManachirService manachirService;
	
	@GetMapping("/manachirAdmin")
	public String showManachirAdmin(Model model)
	{
		List<Manachir> manachirs =  manachirService.getAllManachir();
		model.addAttribute("manachirs",  manachirs);
		return "Admin/manachirAdmin";
	}
    
	@PostMapping("/Admin/manachirAdmin/saveMenchor")
	public String saveMenchor(@RequestParam("file") MultipartFile file,
			@RequestParam("menchor") String menchor)
	{
		manachirService.addManchor(file, menchor);
		return "redirect:/manachirAdmin";
	}

	@RequestMapping( value = "/Admin/manachirAdmin/changemenchorStatus" , method = RequestMethod.POST
			,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Manachir changeStatus(@RequestParam("id") Long id ,
			@RequestParam("status") int status)
	{
		return manachirService.changeMenchorStatus(id, status);
	}
	
	@RequestMapping( value = "/Admin/manachirAdmin/deleteMenchor/{id}" , method = RequestMethod.GET
			,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Manachir deleteMenchor(@PathVariable("id") Long id)
	{
		return manachirService.deleteMenchor(id);
	}
	
	@RequestMapping( value = "/Admin/manachirAdmin/changeMenchorAttachment" , method = RequestMethod.POST
			,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	
	public Manachir changeMenchorAttachment(@RequestParam("file") MultipartFile file
			,@RequestParam("id") Long id)
	{
		return manachirService.changeAttachmentFile(file,id);
	}
}
