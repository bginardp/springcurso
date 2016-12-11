package es.palmademallorca.factu.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

import es.palmademallorca.factu.model.Cliente;
import es.palmademallorca.factu.model.Ejercicio;


public interface EjercicioRepository extends PagingAndSortingRepository<Ejercicio, Long> {

//	Page<City> findAll(Pageable pageable);

//	Page<City> findByNameContainingAndCountryContainingAllIgnoringCase(String name,
//			String country, Pageable pageable);

//	City findByNameAndCountryAllIgnoringCase(String name, String country);

}