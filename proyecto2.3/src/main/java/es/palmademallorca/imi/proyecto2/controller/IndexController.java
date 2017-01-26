package es.palmademallorca.imi.proyecto2.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.palmademallorca.imi.proyecto2.component.ComponentOne;

@Controller
public class IndexController {
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	ComponentOne componentOne;
	
	@RequestMapping("/")
	public String index(Model model, Locale locale){
		String traduccion = 
				messageSource
				.getMessage("mensajeIndex", null, locale);
		model.addAttribute("msgI18n", traduccion);
		componentOne.hello();
		return "index";
	}
}
