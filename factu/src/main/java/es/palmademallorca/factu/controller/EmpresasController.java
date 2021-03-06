package es.palmademallorca.factu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.palmademallorca.factu.dto.EmpresaDto;
import es.palmademallorca.factu.service.AdminService;

@Controller
public class EmpresasController {

	@Autowired
	AdminService adminService;
	
	@ModelAttribute("page")
	public String module() {
	   return "altres";
	}
	
	@RequestMapping(value="/empresas", method=RequestMethod.GET)
	public String list(
		Model model){
		model.addAttribute("empresas", adminService.findAllEmpresas());
		return "empresa/list";
	}
	
	@RequestMapping(value ={"/empresa/{id}","/empresa/new"}, method=RequestMethod.GET)
	public String edit(
			Model model,
			@PathVariable(value="id",required=false) Long empresaId){
		EmpresaDto empresa=null;
		if (empresaId!=null) {
		  empresa = adminService.getEmpresa(empresaId);
		} else {
		  empresa = new EmpresaDto();	
		}
		return gotoEdit(model,empresa);
	}
	
	private String gotoEdit(Model model, EmpresaDto empresa) {
		model.addAttribute("empresa", empresa);
		return "empresa/edit";
	}
	
	@RequestMapping(value="empresa/save", method=RequestMethod.POST)
	public String save(
			Model model,
			@Valid @ModelAttribute("empresa") EmpresaDto empresa,
			BindingResult results){
		if (results.hasErrors()){
			return gotoEdit(model, empresa);
		} else {
			Long empresaId=adminService.saveEmpresa(empresa);
			return "redirect:/empresa/"+empresaId+"?msg=ok";
		}
	}
}
