package es.palmademallorca.imi.proyecto3.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import es.palmademallorca.imi.proyecto3.model.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product,Long> {

}
