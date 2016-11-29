package es.palmademallorca.imi.proyecto3.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.palmademallorca.imi.proyecto3.model.Product;
import es.palmademallorca.imi.proyecto3.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("")
	public String index(Model model){
		model.addAttribute("products",
				productService.getProducts(false));
		return "admin/list";
	}
	
	@RequestMapping(value = {"/product/{prodId}","/product"},method=RequestMethod.GET)
	public String getProduct(
			Model model,
			@PathVariable(value = "prodId", required=false) Long id){
		Product product = null;
		if (id!= null){
			product = productService.getProduct(id);
		} else {
			product = new Product();
		}
		model.addAttribute("product", product);
		return "admin/edit";
	}
	
	@RequestMapping(value="/product/remove",method=RequestMethod.POST)
	public String removeProduct(
			@RequestParam("id") Long id){
		productService.removeProduct(id);
		return "redirect:/product";
	}
	
	@RequestMapping(value="/product/save",method=RequestMethod.POST)
	public String saveProduct(
			Model model,
			@Valid @ModelAttribute("product") Product product,
			BindingResult result){
		if (!result.hasErrors()){
			productService.saveProduct(product);
			//model.addAttribute("mensaje", "Operación correcta");
			return "redirect:/admin/product/"+product.getId()+"?ok=true";
		} else {
			model.addAttribute("mensajeError", "Por favor revise los datos introducidos");
		}
		model.addAttribute("product", product);
		return "admin/edit";
	}
	
}
