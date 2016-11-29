package es.palmademallorca.imi.proyecto3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderItem {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	@ManyToOne
	Order order;
	@ManyToOne
	Product product;
	
	
	public Long getId() {
		return id;
	}

	public Order getOrder() {
		return order;
	}

	public Product getProduct() {
		return product;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	private String title;
	private Double price;

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	private Long quantity;

	public Long getQuantity() {
		return quantity;
	}

	public Double getTotal() {
		return (quantity * price);
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


}
