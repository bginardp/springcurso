package es.palmademallorca.factu.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.palmademallorca.factu.beans.UserSession;
import es.palmademallorca.factu.dto.EntradaDto;
import es.palmademallorca.factu.service.AdminService;
import es.palmademallorca.factu.service.FactuService;

@Controller
public class IndexController {
	@Autowired 
	FactuService factuService;
	@Autowired 
	AdminService adminService;
	
	@ModelAttribute("page")
	public String module() {
	   return "index";
	}
	
    @RequestMapping(value={"","/index"})
	public String index(HttpSession session, Model model, EntradaDto entrada,
			@RequestParam(value = "ejercicio", required = false) Long ejercicio,
			@RequestParam(value = "empresa", required = false) Long empresa){
		
	    if (entrada==null) {
	    	entrada=new EntradaDto(new Long(2016),new Long(1),"Empresa 1"); 
	    	}
		return gotoIndex(model,entrada);
	}
	
	private String gotoIndex(Model model, EntradaDto entrada) {
		model.addAttribute("entrada", entrada);
		model.addAttribute("empresas",adminService.findAllEmpresas());
		model.addAttribute("ejercicios",adminService.findAllEjercicios());
		return "index";
	}

	@RequestMapping(value = "/doEntrada", method=RequestMethod.POST)
	public String doEntrada(HttpSession session,
			Model model,
			@Valid @ModelAttribute("entrada") EntradaDto entrada,
			BindingResult results){
		if (results.hasErrors()){
			return gotoIndex(model, entrada);
		} else {
			// articleService.saveArticle(article);
			
				UserSession userSession=new UserSession();
				userSession.setEjercicioId(entrada.getEjercicioId());
				userSession.setEmpresaId(entrada.getEmpresaId());
				userSession.setEmpresaName(entrada.getEmpresaName());
				session.setAttribute("user", userSession);
//				return gotoIndex(model,entrada);
				
//				return URLEncoder.encode("redirect:/facturas/?empresa="+entrada.getEmpresaId()+"&ejercicio="+entrada.getEjercicioId(),"UTF-8");
//			    return "redirect:/facturas?empresa="+entrada.getEmpresaId()+"&ejercicio="+entrada.getEjercicioId();
			    return "redirect:/index?empresa="+entrada.getEmpresaId()+"&ejercicio="+entrada.getEjercicioId();
		
		}
	}
    
}
