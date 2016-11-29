package es.palmademallorca.imi.proyecto4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String index(){
		return "redirect:/blog";
	}
	
	@RequestMapping("/ajax")
	public String ajax(){
		return "ajax";
	}
}
