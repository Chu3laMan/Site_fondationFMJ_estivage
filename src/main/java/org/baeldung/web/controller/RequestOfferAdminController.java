package org.baeldung.web.controller;

import java.util.List;

import org.baeldung.persistence.model.publication.RequestOffer;
import org.baeldung.service.publication.RequestOfferService;
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
public class RequestOfferAdminController {
	@Autowired
	private RequestOfferService requestOfferService;
	
	@GetMapping("/publicationAdmin")
	public String showpublicationAdmin(Model model)
	{
		List<RequestOffer> requestOffers = requestOfferService.getAllRequestOffer();
		model.addAttribute("requestOffers", requestOffers);
		return "Admin/publicationAdmin";
	}
	
	
	@PostMapping(value = "/Admin/publicationAdmin/saveRequestOffer")

	public String addRequestOfferr(@RequestParam("file") MultipartFile file
			,@RequestParam("titre") String titre
			,@RequestParam("offre") String offer
			,@RequestParam("externLink") String externLink) 
	{
		requestOfferService.saveRequestOffer(file, titre, offer, externLink);
	   return "redirect:/publicationAdmin";
	}
	
	@RequestMapping(value = "/Admin/publicationAdmin/changeRequestOfferAttachment",method = RequestMethod.POST
			,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public RequestOffer changeRequestOfferAttachment(@RequestParam("id") Long id
    		, @RequestParam("file") MultipartFile file)
    {
		return requestOfferService.changeAttachmentFile(id, file);
    }
	@RequestMapping(value = "/Admin/publicationAdmin/changeRequestOfferstatus",method = RequestMethod.POST
			,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
	public RequestOffer changeRequestOfferstatus(@RequestParam("id") Long id
			,@RequestParam("status") int status)
	{
		return requestOfferService.changeOfferStatus(id, status);
	}
	
	@RequestMapping(value = "/Admin/publicationAdmin/deleteRequestOffer/{id}",method = RequestMethod.GET)
    @ResponseBody
    public RequestOffer deleteRequestOffer(@PathVariable("id") Long id)
    {
		return requestOfferService.deleteRequestOffer(id);
    }
}
