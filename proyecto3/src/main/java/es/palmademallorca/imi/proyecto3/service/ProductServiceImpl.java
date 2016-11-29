package es.palmademallorca.imi.proyecto3.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.palmademallorca.imi.proyecto3.jpa.OrderItemRepository;
import es.palmademallorca.imi.proyecto3.jpa.OrderRepository;
import es.palmademallorca.imi.proyecto3.jpa.ProductRepository;
import es.palmademallorca.imi.proyecto3.model.Order;
import es.palmademallorca.imi.proyecto3.model.OrderItem;
import es.palmademallorca.imi.proyecto3.model.Product;

@Service(value = "productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public ProductServiceImpl() {

	}

	@PostConstruct
	public void init() {
		// inicialitzar la llista
		productRepository.save(new Product("Product description... Lorem ipsum dolor sit", new Double(105),
				true));
		productRepository.save(new Product("Product description... Lorem ipsum dolor sit", new Double(10),
				true));
		productRepository.save(new Product("Product description... Lorem ipsum dolor sit", new Double(1105),
				true));
		productRepository.save(new Product("Product description... Lorem ipsum dolor sit", new Double(2105),
				true));
	}

	@Override
	public List<Product> getProducts() {
		return getProducts(false);
	}

	@Override
	public List<Product> getProducts(boolean onlyVisibles) {
		List<Product> result = null;
		if (onlyVisibles) {
			Iterator<Product> it = productRepository.findAll().iterator();
			while (it.hasNext()) {
				Product p = it.next();
				if (p.isVisible()) {
					result.add(p);
				}
			}

		} else {
			Iterator<Product> it = productRepository.findAll().iterator();
			while (it.hasNext()) {
				result.add(it.next());
			}
		}
		return result;

	}

	@Override
	public Product getProduct(Long productId) {
		return productRepository.findOne(productId);

	}

	@Override
	public void saveProduct(Product product) {
		if (product != null) {
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
		if (items != null && items.size() > 0) {
			result = new Order();
			result.setBuyDate(new Date());
			// result.setId((long) orders.size());
			result.setTotal(calcTotal(items));
			orderRepository.save(result);
			for (OrderItem item : items) {
				item.setOrder(result);
			}
		}
		return result;
	}

	private Double calcTotal(List<OrderItem> items) {
		Double result = null;
		if (items != null && items.size() > 0) {
			result = 0.;
			for (OrderItem item : items) {
				
				Double productPrice = item.getPrice();
				result += item.getQuantity() * productPrice;
			}
		}
		return result;
	}

}