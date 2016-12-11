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
@RequestMapping("/factu")
public class FactuController {
	@Autowired 
	FactuService factuService;
	
	
	@RequestMapping("")
	public String index(Model model){
		System.out.println("######FactuController######### estic a index");
		EntradaDto entrada=new EntradaDto(new Long(2016),new Long(1));
		return gotoIndex(model,entrada);
	}
	
	private String gotoIndex(Model model, EntradaDto entrada) {
		model.addAttribute("entrada", entrada);
		model.addAttribute("empresas",factuService.findAllEmpresas());
		model.addAttribute("ejercicios",factuService.findAllEjercicios());
		return "factu/index";
	}

	@RequestMapping(value = "", method=RequestMethod.POST)
	public String doEntrada(
			Model model,
			@Valid @ModelAttribute("entrada") EntradaDto entrada,
			BindingResult results){
		if (results.hasErrors()){
			return gotoIndex(model, entrada);
		} else {
			// articleService.saveArticle(article);
			return "redirect:/factu/"+entrada.getEmpresaId()+"/"+entrada.getEjercicioId();
		}
	}

	@RequestMapping(value="/facturas", method=RequestMethod.GET)
	public String listFacturas(
		Model model,
		@PageableDefault(size=3) Pageable pageRequest,
		@RequestParam(value="ejercicio",required=true) Long ejercicio,
		@RequestParam(value="empresa",required=true) Long empresa,
		@RequestParam(value="term",required=false) String term){
		model.addAttribute("ejercicio", ejercicio);
		model.addAttribute("empresa", empresa);
		model.addAttribute("term", term);
		if (term!=null) {
			model.addAttribute("facturas",factuService.findFacturasByTerm(empresa,ejercicio,term,pageRequest));
		}
		
		return "factu/factura/main";
	}
	
	@RequestMapping(value="/clientes", method=RequestMethod.GET)
	public String listClientes(
		Model model,
		@PageableDefault(size=5) Pageable pageRequest,
		@RequestParam(value="term",required=false) String term){
		model.addAttribute("term", term); // per no perdre el trme de recerca
		model.addAttribute("clientes", factuService.getClientes(term, pageRequest));
		return "factu/cliente/list";
	}
	
	@RequestMapping(value ="/cliente/{id}", method=RequestMethod.GET)
	public String edit(
			Model model,
			@PathVariable("id") Long clienteId){
		ClienteDto cliente = factuService.getCliente(clienteId);
		return gotoEdit(model,cliente);
	}
	
	private String gotoEdit(Model model, ClienteDto cliente) {
		model.addAttribute("cliente", cliente);
		return "factu/cliente/edit";
	}
	
	@RequestMapping(value="/cliente/save", method=RequestMethod.POST)
	public String save(
			Model model,
			@Valid @ModelAttribute("cliente") ClienteDto cliente,
			BindingResult results){
		if (results.hasErrors()){
			return gotoEdit(model, cliente);
		} else {
			factuService.saveCliente(cliente);
			return "redirect:/factu/cliente/"+cliente.getId()+"?msg=ok";
		}
	}
}
