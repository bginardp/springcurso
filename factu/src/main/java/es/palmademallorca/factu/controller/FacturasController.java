package es.palmademallorca.factu.controller;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.palmademallorca.factu.dto.CriteriosFacturasDto;
import es.palmademallorca.factu.dto.FacLinDto;
import es.palmademallorca.factu.dto.FacturaDto;
import es.palmademallorca.factu.service.FactuService;

@Controller
public class FacturasController {
	@Autowired
	FactuService factuService;

	@ModelAttribute("page")
	public String module() {
		return "facturas";
	}

	@PostConstruct
	private void init() {
		System.out.println("################ init FacturasController");
	}

	@RequestMapping(value = "/facturas", method = RequestMethod.GET)
	public String listFacturas(Model model, @PageableDefault(size = 10) Pageable pageRequest) {
		CriteriosFacturasDto criteris = new CriteriosFacturasDto();
		Page<FacturaDto> facturas=new PageImpl<>(new ArrayList<FacturaDto>(), pageRequest,0);
		model.addAttribute("facturas", facturas);
		model.addAttribute("criteris", criteris);
		 return gotoFacturasList(model);
			
	}
	
	private String gotoFacturasList(Model model) {
		model.addAttribute("empresas", factuService.findAllEmpresas());
		model.addAttribute("ejercicios", factuService.findAllEjercicios());
	return "factura/list";
		
	}

	@RequestMapping(value = "/facturas/search", method = RequestMethod.GET)
	public String findFacturas(HttpSession session, Model model, 
			@PageableDefault(size = 10) Pageable pageRequest, CriteriosFacturasDto criteris) {
		// begin
//		UserSession userSession = (UserSession) session.getAttribute("user");
//		if (userSession == null) {
//			model.addAttribute("msgErr",
//					"Es necesario seleccionar una empresa y ejercicio para poder ver las facturas");
//			return null;
//
//		} else {
			model.addAttribute("criteris", criteris);
			model.addAttribute("facturas", factuService.getFacturas(criteris.getEmpresaId(), criteris.getEjercicioId(), criteris.getTerm(), pageRequest));
//	}
		return gotoFacturasList(model);
	}
	
	@RequestMapping(value = "/factura/save", method = RequestMethod.POST)
	public String save(
			Model model,
			@Valid @ModelAttribute("factura") FacturaDto factura,
			BindingResult results){
		if (results.hasErrors()){
			return gotoEdit(model, factura);
		} else {
			Long facturaId=factuService.saveFactura(factura);
			return "redirect:/factura/"+facturaId+"?msg=ok";
		}
	}
	
	
	@RequestMapping(value ={"/factura/{id}","/factura/new"}, method=RequestMethod.GET)
	public String edit(
			Model model,
			@PathVariable(value="id",required=false) Long facturaId){
		FacturaDto factura=null;
		if (facturaId!=null) {
		  factura = factuService.getFactura(facturaId);
		} else {
		  factura = new FacturaDto();	
		}
		return gotoEdit(model,factura);
	}
	
	private String gotoEdit(Model model, FacturaDto factura) {
		model.addAttribute("factura", factura);
		model.addAttribute("formasPago",factuService.findAllFormaspago());
		return "factura/edit";
	}
	
	@RequestMapping(value ={"/faclin/{id}","/faclin/new"}, method=RequestMethod.GET)
	public String editLin(
			Model model,
			@PathVariable(value="id",required=false) Long faclinId, FacturaDto factura){
		FacLinDto faclin=null;
		if (faclinId!=null) {
		  faclin= factuService.getFaclin(faclinId);
		} else {
		  faclin = new FacLinDto();	
		}
		return gotoEditLin(model,factura, faclin);
	}
	
	@RequestMapping(value = "/faclin/save", method = RequestMethod.POST)
	public String save(
			Model model,FacturaDto factura,
			@Valid @ModelAttribute("faclin") FacLinDto faclin,
			BindingResult results){
		if (results.hasErrors()){
			return gotoEditLin(model, factura, faclin);
		} else {
			Long faclinId=factuService.saveFaclin(faclin);
			
			return "redirect:/clientes/"+faclinId+"?msg=ok";
		}
	}
	
	private String gotoEditLin(Model model, FacturaDto factura, FacLinDto faclin) {
		model.addAttribute("factura", faclin);
		model.addAttribute("faclin", faclin);
		return "factura/edit";
	}
}
