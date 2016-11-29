package es.palmademallorca.imi.proyecto3.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.palmademallorca.imi.proyecto3.model.Order;
import es.palmademallorca.imi.proyecto3.model.OrderItem;
import es.palmademallorca.imi.proyecto3.model.Product;

public class ProductServiceTestImpl implements ProductService{

	private List<Product> products = new ArrayList<>();
	private List<Order> orders = new ArrayList<>();
	private List<OrderItem> orderItems = new ArrayList<>();
	
	@Override
	public List<Product> getProducts() {
		return products;
	}

	@Override
	public List<Product> getProducts(boolean onlyVisibles) {
		if (onlyVisibles){
			List<Product> visibleProducts = new ArrayList<>();
			for (Product product : products){
				if (product.isVisible()){
					visibleProducts.add(product);
				}
			}
			return visibleProducts;
		}
		return products;
	}

	@Override
	public Product getProduct(Long productId) {
		if (productId != null) {
			for (Product p : products) {
				if (productId.equals(p.getId())) {
					return p;
				}
			}
		}
		return null;
	}

	@Override
	public void saveProduct(Product product) {
		if (product != null) {
			if (product.getId()==null){
				product.setId((long)products.size());
			}
			Product prodDB = getProduct(product.getId());
			if (prodDB != null) {
				prodDB.setTitle(product.getTitle());
				prodDB.setPrice(product.getPrice());
				prodDB.setVisible(product.isVisible());
			} else {
				products.add(product);
			}
		}

	}

	@Override
	public void removeProduct(Long productId) {
		Product prodDB = getProduct(productId);
		if (prodDB != null) {
			products.remove(prodDB);
		}
	}

	@Override
	public Order createOrder(List<OrderItem> items) {
		Order result = null;
		if (items!=null && items.size()>0){
			result = new Order();
			result.setBuyDate(new Date());
			result.setId((long)orders.size());
			result.setTotal(calcTotal(items));
			for(OrderItem item : items){
				item.setOrder(result);
				orderItems.add(item);
			}
			orders.add(result);
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
