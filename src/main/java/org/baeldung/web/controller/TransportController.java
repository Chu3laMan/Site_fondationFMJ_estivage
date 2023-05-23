package org.baeldung.web.controller;

import java.util.List;

import org.baeldung.persistence.model.transport.Transport;
import org.baeldung.service.transport.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TransportController {
	@Autowired
	private TransportService transportService;
	private final String TRANSPORT_W = "النقل الوظيفي";
	private final String TRANSPORT_S = "النقل السككي";
	private final String TRANSPORT_B = "النقل البحري";
	private final String TRANSPORT_T = "النقل الطرقي";
	
	@GetMapping("/transpot1.html")
	public String transportView(Model model)
	{

		List<Transport> tnsportW = transportService.getTransportByType(TRANSPORT_W);
		List<Transport> tnsportS = transportService.getTransportByType(TRANSPORT_S);
		List<Transport> tnsportB = transportService.getTransportByType(TRANSPORT_B);
		List<Transport> tnsportT = transportService.getTransportByType(TRANSPORT_T);
		model.addAttribute("tnsportW", tnsportW);
		model.addAttribute("tnsportS", tnsportS);
		model.addAttribute("tnsportB", tnsportB);
		model.addAttribute("tnsportT", tnsportT);
		return "transport.html";
	}


}
