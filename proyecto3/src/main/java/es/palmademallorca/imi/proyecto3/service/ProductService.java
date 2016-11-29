package es.palmademallorca.imi.proyecto3.service;

import java.util.List;

import es.palmademallorca.imi.proyecto3.model.Order;
import es.palmademallorca.imi.proyecto3.model.OrderItem;
import es.palmademallorca.imi.proyecto3.model.Product;

public interface ProductService {
	//CRUD para la gestión de Productos
	public List<Product> getProducts();
	public List<Product> getProducts(boolean onlyVisibles);
	public Product getProduct(Long productId);
	public void saveProduct(Product product);
	public void removeProduct(Long productId);
	
	// Operación para hacer un checkout de un
	// carrito
	public Order createOrder(List<OrderItem> items);
}
