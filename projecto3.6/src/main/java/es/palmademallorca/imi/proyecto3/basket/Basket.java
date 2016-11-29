package es.palmademallorca.imi.proyecto3.basket;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import es.palmademallorca.imi.proyecto3.model.OrderItem;

@Component
@Scope("session")
// @Scope("singleton")
public class Basket {

	private List<OrderItem> items = new ArrayList<>();
	private Double total;

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public void removePosition(Integer pos) {
		if (pos != null && pos >= 0 && pos < items.size()) {
			this.items.remove((int)pos);
		}
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
}
