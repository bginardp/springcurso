package es.palma.democomboajax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.palma.democomboajax.service.GenAdrecaService;


@Controller
public class HomeController {
	@Autowired
	GenAdrecaService adrecaService;
	@RequestMapping("")
	public String welcome(Model model){
		model.addAttribute("provincies", adrecaService.getProvincies());
		return "index";
	}
	@RequestMapping(value="/refreshMunicipis", method=RequestMethod.GET) 
	public String refreshMunicipis(@RequestParam("idProvincia") Long idProvincia, Model model) {
		model.addAttribute("municipis", adrecaService.getMunicipis(idProvincia));
		return "index :: #municipi";
	}
	
	
	
	
}
