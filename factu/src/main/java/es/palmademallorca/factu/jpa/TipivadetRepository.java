package es.palmademallorca.factu.jpa;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import es.palmademallorca.factu.model.TipivaDet;


public interface TipivadetRepository extends PagingAndSortingRepository<TipivaDet, Long> {

//	Page<City> findAll(Pageable pageable);

//	Page<City> findByNameContainingAndCountryContainingAllIgnoringCase(String name,
//			String country, Pageable pageable);

//	City findByNameAndCountryAllIgnoringCase(String name, String country);
	List<TipivaDet> findByTipivaIdOrderByAnyoAscMesAsc(String id);

}