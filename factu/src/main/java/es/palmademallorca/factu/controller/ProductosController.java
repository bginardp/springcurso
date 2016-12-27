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
import es.palmademallorca.factu.dto.ProductoDto;
import es.palmademallorca.factu.service.FactuService;

@Controller
public class ProductosController {
	@Autowired 
	FactuService factuService;
	
	@ModelAttribute("page")
	public String module() {
	   return "productos";
	}
	
	@RequestMapping(value="/productos", method=RequestMethod.GET)
	public String list(
		Model model,
		@PageableDefault(size=5) Pageable pageRequest,
		@RequestParam(value="term",required=false) String term){
		model.addAttribute("term", term); // per no perdre el trme de recerca
		model.addAttribute("productos", factuService.getProductos(term, pageRequest));
		return "producto/list";
	}
	
	@RequestMapping(value ={"/producto/{id}","/producto/new"}, method=RequestMethod.GET)
	public String edit(
			Model model,
			@PathVariable(value="id",required=false) String productoId){
		ProductoDto producto=null;
		if (productoId!=null) {
		  producto = factuService.getProducto(productoId);
		} else {
		  producto = new ProductoDto();	
		}
			
		return gotoEdit(model,producto);
	}
	
	private String gotoEdit(Model model, ProductoDto producto) {
		model.addAttribute("producto", producto);
		return "producto/edit";
	}
	
	@RequestMapping(value="/producto/save", method=RequestMethod.POST)
	public String save(
			Model model,
			@Valid @ModelAttribute("producto") ProductoDto producto,
			BindingResult results){
		if (results.hasErrors()){
			return gotoEdit(model, producto);
		} else {
			factuService.saveProducto(producto);
			return "redirect:/producto/"+producto.getId()+"?msg=ok";
		}
	}
}
