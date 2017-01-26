package es.palmademallorca.factu.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
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

import es.palmademallorca.factu.beans.UserSession;
import es.palmademallorca.factu.dto.FacturaDto;
import es.palmademallorca.factu.service.FactuService;

@Controller
public class FacturasController {
	// @Autowired
	// UserSession userSession;
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
	public String listFacturas(HttpSession session, Model model, 
			@PageableDefault(size = 10) Pageable pageRequest,
			@RequestParam(value = "empresa", required = true) Long empresa,
			@RequestParam(value = "ejercicio", required = true) Long ejercicio,
			@RequestParam(value = "term", required = false) String term) {
		// begin
		UserSession userSession = (UserSession) session.getAttribute("user");
		if (userSession == null) {
			model.addAttribute("msgErr",
					"Es necesario seleccionar una empresa y ejercicio para poder ver las facturas");
			return null;

		} else {
			model.addAttribute("ejercicio", ejercicio);
			model.addAttribute("empresa", empresa);
			model.addAttribute("term", term);
			model.addAttribute("user",userSession);
			model.addAttribute("facturas", factuService.getFacturas(empresa, ejercicio, term, pageRequest));
		}
		return "factura/list";
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
			return "redirect:/clientes/"+facturaId+"?msg=ok";
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
	

}
