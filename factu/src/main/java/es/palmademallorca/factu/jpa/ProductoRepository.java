package es.palmademallorca.factu.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import es.palmademallorca.factu.model.Facturalin;
import es.palmademallorca.factu.model.Producto;


public interface ProductoRepository extends PagingAndSortingRepository<Producto, String> {

//	Page<City> findAll(Pageable pageable);

//	Page<City> findByNameContainingAndCountryContainingAllIgnoringCase(String name,
//			String country, Pageable pageable);

//	City findByNameAndCountryAllIgnoringCase(String name, String country);

}