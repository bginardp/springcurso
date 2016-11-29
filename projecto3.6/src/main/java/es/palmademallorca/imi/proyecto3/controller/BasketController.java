package es.palmademallorca.imi.proyecto3.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.palmademallorca.imi.proyecto3.basket.Basket;
import es.palmademallorca.imi.proyecto3.model.Order;
import es.palmademallorca.imi.proyecto3.model.OrderItem;
import es.palmademallorca.imi.proyecto3.model.Product;
import es.palmademallorca.imi.proyecto3.service.ProductService;

@Controller
@RequestMapping("/shop/basket")
public class BasketController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ApplicationContext appCtx;
	
	@RequestMapping("")
	public String viewBasket(Model model){
		Basket basket = appCtx.getBean(Basket.class);
		
		//calcular total
		//obtener el mapa de productos
		Double total = 0.;
		Map<Long,Product> products = new HashMap<>();
		for(OrderItem item : basket.getItems()){
			Product product = item.getProduct();
			if (product == null){
				product = productService.getProduct(item.getProduct().getId());
				products.put(product.getId(), product);
			}
			Double unitPrice = product.getPrice();
			total+= item.getQuantity() * unitPrice;
		}
		basket.setTotal(total);
		model.addAttribute("basket", basket);
		model.addAttribute("products",products);
		return "shop/basket";
	}
	
	@RequestMapping("/add")
	public String addProduct(Model model,
			@RequestParam("id") Long productId,
			@RequestParam(value = "qtt", required = false, defaultValue="1") Integer qtt){
		Basket basket = appCtx.getBean(Basket.class);
		Product product = productService.getProduct(productId);
		if (product!=null){
			basket.getItems().add(new OrderItem(product, qtt));
		}
		return "redirect:/shop/product/"+productId+"?ok=true";
	}
	
	@RequestMapping("/remove")
	public String removeProduct(Model model,
			@RequestParam("pos") Integer pos){
		Basket basket = appCtx.getBean(Basket.class);
		basket.removePosition(pos);
		return "redirect:/shop/basket";
	}
	
	@RequestMapping("/clear")
	public String clearBasket(){
		Basket basket = appCtx.getBean(Basket.class);
		basket.getItems().clear();
		return "redirect:/shop/basket";
	}
	
	@RequestMapping("/checkout")
	public String checkout(Model model){
		Basket basket = appCtx.getBean(Basket.class);
		Order order = productService.createOrder(basket.getItems());
		if(order!=null){
			basket.getItems().clear();
			model.addAttribute("order", order);
			return "shop/checkout";
		}
		return "redirect:/shop/basket";
	}
}
