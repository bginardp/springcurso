package es.palmademallorca.imi.proyecto3.controller;

import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.palmademallorca.imi.proyecto3.basket.Basket;
import es.palmademallorca.imi.proyecto3.model.Order;
import es.palmademallorca.imi.proyecto3.model.OrderItem;
import es.palmademallorca.imi.proyecto3.model.Product;
import es.palmademallorca.imi.proyecto3.service.ProductService;

@Controller
@RequestMapping("/shop")
public class ShopController {
	@Autowired
	private ProductService productService;
	@Autowired
	ApplicationContext appCtx;
	
	
	@PostConstruct
	public void init(){
		System.out.println("Creando Shop Controller");
		System.out.println("Valor de productService "+productService);
	}
	
	@RequestMapping("")
	public String producList(Model model){
		Basket basket = appCtx.getBean(Basket.class);
		List<Product> productList = productService.getProducts();
		model.addAttribute("products", productList);
      return "shop/list";
	}
	
	@RequestMapping("/product/{prodId}")
	public String viewProduct(
			Model model,
			@PathVariable("prodId") Long productId){
		Product product = productService.getProduct(productId);
		model.addAttribute("product", product);
		return "shop/view";
	}
	
	
	@RequestMapping(value = "/basket",method=RequestMethod.GET)
	public String getBasket(
			Model model){
		Basket basket = appCtx.getBean(Basket.class);
		model.addAttribute("basket", basket);
		return "shop/basket";
	}
	
	@RequestMapping(value = "/add",method=RequestMethod.GET)
	public String addProductToBasket(Model model,
			@RequestParam(value = "id") Long productId,
			@RequestParam(value = "qtt", required=false,defaultValue="1") Long qtt){
		Basket basket = appCtx.getBean(Basket.class);
		List<Product> productList = productService.getProducts();
		System.out.println("############################ id :"+productId);
		if (productId!=null) {
		   OrderItem item = new OrderItem();
		   Product p = productService.getProduct(productId);
		   item.setProduct(p);
		   item.setPrice(p.getPrice());
		   item.setTitle(p.getTitle());
		   item.setQuantity((qtt!=null && qtt>0)?qtt:1);
		   basket.getItems().add(item);
		   System.out.println("######## Afegit item"+item);
		   System.out.println("######## Basket"+basket);
		}
		
		model.addAttribute("products", productList);
		return "redirect:/shop/?ok=true";
		
		
	}
	
	@RequestMapping(value = "/remove",method=RequestMethod.GET)
	public String removeProductToBasket(Model model,
			@RequestParam(value = "pos") Integer pos){
		Basket basket = appCtx.getBean(Basket.class);
		List<OrderItem> items=basket.getItems();
		System.out.println("##########################???? pos :"+pos);
		if (pos >=0 && pos<items.size()) {
			System.out.println("######## Esborro");
			 items.remove((int) pos);
		}
		System.out.println("######## Basket"+basket);
		model.addAttribute("basket", basket);
		return "shop/basket";
	}
	
	@RequestMapping(value = "/removeBasket",method=RequestMethod.GET)
	public String removeBasket(Model model) {
		Basket basket = appCtx.getBean(Basket.class);
		List<OrderItem> items=basket.getItems();
	    items.clear();
     	basket.setItems(items);
		List<Product> productList = productService.getProducts();
		model.addAttribute("products", productList);
		return "shop/list";
	}
	
	@RequestMapping(value = "/createOrder",method=RequestMethod.GET)
	public String createOrder(Model model) {
		Basket basket = appCtx.getBean(Basket.class);
		List<OrderItem> items=basket.getItems();
	    Order order=productService.createOrder(items);
		model.addAttribute("order", order);
		items.clear();
		return "shop/order";
		
	}
	
}
