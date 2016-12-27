package es.palmademallorca.factu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.palmademallorca.factu.dto.ClienteDto;
import es.palmademallorca.factu.dto.EntradaDto;
import es.palmademallorca.factu.service.FactuService;

@Controller
@RequestMapping("/clientes")
public class ClientesController {
	@Autowired 
	FactuService factuService;
	
	@ModelAttribute("page")
	public String module() {
	   return "clientes";
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String listClientes(
		Model model,
		@PageableDefault(size=5) Pageable pageRequest,
		@RequestParam(value="term",required=false) String term){
		model.addAttribute("term", term); // per no perdre el trme de recerca
		model.addAttribute("clientes", factuService.getClientes(term, pageRequest));
		return "cliente/list";
	}
	
	@RequestMapping(value ={"/{id}","/new"}, method=RequestMethod.GET)
	public String edit(
			Model model,
			@PathVariable(value="id",required=false) Long clienteId){
		ClienteDto cliente=null;
		if (clienteId!=null) {
		  cliente = factuService.getCliente(clienteId);
		} else {
		  cliente = new ClienteDto();	
		}
			
		return gotoEdit(model,cliente);
	}
	
	private String gotoEdit(Model model, ClienteDto cliente) {
		model.addAttribute("cliente", cliente);
		return "cliente/edit";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(
			Model model,
			@Valid @ModelAttribute("cliente") ClienteDto cliente,
			BindingResult results){
		if (results.hasErrors()){
			return gotoEdit(model, cliente);
		} else {
			Long clienteId=factuService.saveCliente(cliente);
			return "redirect:/clientes/"+clienteId+"?msg=ok";
		}
	}
}
