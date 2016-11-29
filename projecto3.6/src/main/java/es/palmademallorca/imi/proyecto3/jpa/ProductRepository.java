package es.palmademallorca.imi.proyecto3.jpa;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import es.palmademallorca.imi.proyecto3.model.Product;

public interface ProductRepository 
	extends PagingAndSortingRepository<Product, Long>{

	List<Product> findByVisible(boolean b);

}
