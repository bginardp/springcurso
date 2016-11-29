package es.palmademallorca.imi.proyecto3.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.palmademallorca.imi.proyecto3.jpa.OrderItemRepository;
import es.palmademallorca.imi.proyecto3.jpa.OrderRepository;
import es.palmademallorca.imi.proyecto3.jpa.ProductRepository;
import es.palmademallorca.imi.proyecto3.model.Order;
import es.palmademallorca.imi.proyecto3.model.OrderItem;
import es.palmademallorca.imi.proyecto3.model.Product;

@Service(value="productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository itemRepository;
	
	
	@PostConstruct
	public void init(){
//		entityManager.find(Product.class, 1l);
//		productRepository.findOne(1l);
//		
//		entityManager.createNativeQuery("select i.* "
//				+ "from tbl_order_item i "
//				+ "inner join tbl_product p on i.product_id = p.id"
//				+ "where p.visible = 1");
//		entityManager.createQuery("from OrderItem i where i.product.visible = true");
//		
//		OrderItem item = itemRepository.findOne(1l);
//		
//		//> item.order != null, item.product==null;
//		
//		Product product = item.getProduct();
//		Order order = item.getOrder();
					
		
		//inicializar productos
		productRepository.save(new Product("Artículo 1",100.,true));
	}
	
	@Override
	public List<Product> getProducts() {
		return getProducts(false);
	}
	
	@Override
	public List<Product> getProducts(boolean onlyVisibles) {
		if (onlyVisibles){
			return productRepository.findByVisible(true);
		}
		return privateGetProducts();
	}

	private List<Product> privateGetProducts() {
		List<Product> result = new ArrayList<>();
		Iterator<Product> it = productRepository.findAll().iterator();
		while(it.hasNext()){
			result.add(it.next());
		}
		return result;
	}

	@Override
	public Product getProduct(Long productId) {
		if (productId != null) {
			return productRepository.findOne(productId);
		}
		return null;
	}
	

	@Override
	public void saveProduct(Product product) {
		if (product != null) {
//			if (product.getId()==null){
//				product.setId((long)productRepository.count());
//			}
			Product prodDB = getProduct(product.getId());
			if (prodDB != null) {
				prodDB.setTitle(product.getTitle());
				prodDB.setPrice(product.getPrice());
				prodDB.setVisible(product.isVisible());	
			}
			productRepository.save(product);
		}

	}

	@Override
	public void removeProduct(Long productId) {
		if (productId != null) {
			productRepository.delete(productId);
		}
	}

	@Override
	public Order createOrder(List<OrderItem> items) {
		Order result = null;
		if (items!=null && items.size()>0){
			result = new Order();
			result.setBuyDate(new Date());
			//result.setId((long)orders.size());
			result.setTotal(calcTotal(items));
			orderRepository.save(result);
			
			for(OrderItem item : items){
				item.setOrder(result);
				itemRepository.save(item);
			}
			
		}
		return result;
	}

	private Double calcTotal(List<OrderItem> items) {
		Double result = null;
		if (items!=null && items.size()>0){
			result = 0.;
			for (OrderItem item : items){
				Product product = item.getProduct();
				Double productPrice = product.getPrice();
				result += item.getQuantity() * productPrice;
			}
		}
		return result;
	}

}
