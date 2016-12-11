package es.palmademallorca.factu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.palmademallorca.factu.service.FactuService;

@Controller
@RequestMapping("/admin")
public class MaestrosController {
	
	@Autowired
	FactuService factuService;
	
	@RequestMapping("empresa")
	public String empresas(Model model){
		model.addAttribute("empresas",
				factuService.getEmpresas());
		return "admin/list";
	}
	
//	@RequestMapping(value = {"/product/{prodId}","/product"},method=RequestMethod.GET)
//	public String getProduct(
//			Model model,
//			@PathVariable(value = "prodId", required=false) Long id){
//		Product product = null;
//		if (id!= null){
//			product = productService.getProduct(id);
//		} else {
//			product = new Product();
//		}
//		model.addAttribute("product", product);
//		return "admin/edit";
//	}
//	
//	@RequestMapping(value="/product/remove",method=RequestMethod.POST)
//	public String removeProduct(
//			@RequestParam("id") Long id){
//		productService.removeProduct(id);
//		return "redirect:/product";
//	}
//	
//	@RequestMapping(value="/product/save",method=RequestMethod.POST)
//	public String saveProduct(
//			Model model,
//			@Valid @ModelAttribute("product") Product product,
//			BindingResult result){
//		if (!result.hasErrors()){
//			productService.saveProduct(product);
//			//model.addAttribute("mensaje", "Operación correcta");
//			return "redirect:/admin/product/"+product.getId()+"?ok=true";
//		} else {
//			model.addAttribute("mensajeError", "Por favor revise los datos introducidos");
//		}
//		model.addAttribute("product", product);
//		return "admin/edit";
//	}
	
}
