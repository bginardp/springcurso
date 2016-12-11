package es.palmademallorca.factu.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import es.palmademallorca.factu.model.Cliente;


public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long> {

//	Page<City> findAll(Pageable pageable);

//	Page<City> findByNameContainingAndCountryContainingAllIgnoringCase(String name,
//			String country, Pageable pageable);

//	City findByNameAndCountryAllIgnoringCase(String name, String country);

}