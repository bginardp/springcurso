package org.imi.curso.proyecto1.controller;

import org.imi.curso.proyecto1.service.BusinessLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
	
	@Autowired
	private BusinessLogicService businessLogic;
	
	@RequestMapping("/hello")
	public String hello(Model model){
		model.addAttribute("mensaje", businessLogic.hello());
		model.addAttribute("people", businessLogic.getPeople());
		return "hello";
	}
}
