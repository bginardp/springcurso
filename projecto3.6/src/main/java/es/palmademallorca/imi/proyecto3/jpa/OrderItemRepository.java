package es.palmademallorca.imi.proyecto3.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import es.palmademallorca.imi.proyecto3.model.OrderItem;

public interface OrderItemRepository 
	extends PagingAndSortingRepository<OrderItem, Long>{

}
