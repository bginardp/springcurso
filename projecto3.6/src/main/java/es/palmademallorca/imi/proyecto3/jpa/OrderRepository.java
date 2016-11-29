package es.palmademallorca.imi.proyecto3.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import es.palmademallorca.imi.proyecto3.model.Order;

public interface OrderRepository 
	extends PagingAndSortingRepository<Order, Long>{

}
