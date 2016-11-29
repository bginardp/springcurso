package es.palmademallorca.imi.proyecto3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import es.palmademallorca.imi.proyecto3.model.Product;
import es.palmademallorca.imi.proyecto3.service.ProductService;

@Controller
@RequestMapping("/shop")
public class ShopController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("")
	public String productList(Model model){
		List<Product> products = productService.getProducts(true);
		model.addAttribute("products", products);
		return "shop/list";
	}
	
	@RequestMapping("/product/{prodId}")
	public String viewProduct(
			Model model,
			@PathVariable("prodId") Long productId){
		Product product = productService.getProduct(productId);
		//TODO: comprobar que el producto es visible
		model.addAttribute("product", product);
		return "shop/view";
	}
}
