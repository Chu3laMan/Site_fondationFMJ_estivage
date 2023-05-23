package org.baeldung.web.controller;

import java.util.List;
import java.util.Optional;

import org.baeldung.persistence.model.transport.Transport;
import org.baeldung.service.transport.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class TransportAdminController {
	@Autowired
	private TransportService transportService;
	private final String TRANSPORT_W = "النقل الوظيفي";
	private final String TRANSPORT_S = "النقل السككي";
	private final String TRANSPORT_B = "النقل البحري";
	private final String TRANSPORT_T = "النقل الطرقي";
	
		
	@GetMapping("/transportAdmin")
	public String transportAdminView(Model model)
	{
		List<Transport> transportW = transportService.getTransportByType(TRANSPORT_W);
		List<Transport> transportB = transportService.getTransportByType(TRANSPORT_B);
		List<Transport> transportS = transportService.getTransportByType(TRANSPORT_S);
		List<Transport> transportT = transportService.getTransportByType(TRANSPORT_T);
		model.addAttribute("transportW", transportW);
		model.addAttribute("transportB", transportB);
		model.addAttribute("transportS", transportS);
		model.addAttribute("transportT", transportT);
		return "Admin/transportAdmin";
	}
	@PostMapping("/Admin/transportAdmin/saveTransport")
	public String saveTransport(@RequestParam("file") Optional<MultipartFile> file,
			@RequestParam("image") MultipartFile image, @RequestParam("commentaire") String commentaire, 
			@RequestParam("condition") Optional<String> condition,
			@RequestParam("libelle") String libelle,
			@RequestParam("type") String type)
	{
		transportService.addTransport(file, image, type, libelle, commentaire, condition);
		return "redirect:/transportAdmin";
	}
//change attachment file
	@RequestMapping(value = "/Admin/transportAdmin/changeTransportAttachmentFile",method = RequestMethod.POST
			,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Transport changeTransportAttachmentFile(@RequestParam("id") Long id,@RequestParam("file") MultipartFile file)
    {
		return transportService.addOrChangeAttachment(id, file);
    }
//change commentaire
	@RequestMapping(value = "/Admin/transportAdmin/changeTransportComment",method = RequestMethod.POST
			,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Transport changeTransportComment(@RequestParam("id") Long id,@RequestParam("commentaire") String commentaire)
    {
		return transportService.changeComment(id, commentaire);
    }
//change condition 
	@RequestMapping(value = "/Admin/transportAdmin/changeTransportCondition",method = RequestMethod.POST
			,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Transport changeTransportCondition(@RequestParam("id") Long id, @RequestParam("condition") String condition)
    {
		return transportService.changeCondition(id, condition);
    }
//change image
	@RequestMapping(value = "/Admin/transportAdmin/changeTransportImage",method = RequestMethod.POST
			,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Transport changeTransportImage(@RequestParam("id") Long id,@RequestParam("image") MultipartFile image)
    {
		return transportService.changeImage(id, image);
    }
//change status
	@RequestMapping(value = "/Admin/transportAdmin/changeTransportStatus",method = RequestMethod.POST
			,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Transport changeTransportStatus(@RequestParam("id") Long id, @RequestParam("status") int status)
    {
		return transportService.changeStatus(id, status);
    }
}
