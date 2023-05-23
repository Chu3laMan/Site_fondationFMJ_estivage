package org.baeldung.web.controller;

import java.util.List;

import org.baeldung.persistence.model.publication.RequestOffer;
import org.baeldung.service.publication.RequestOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RequestOfferController {
	@Autowired
	private RequestOfferService requestOfferService;
	
	@GetMapping("/publication1.html")
	public String showRequestOfferView(Model model)
	{
		List<RequestOffer> requestOffers = requestOfferService.getAllActiveRequestOffer();
		model.addAttribute("requestOffers", requestOffers);
		return "publication1.html";
	}

}
