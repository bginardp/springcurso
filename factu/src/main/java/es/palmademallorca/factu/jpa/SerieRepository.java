package es.palmademallorca.factu.jpa;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import es.palmademallorca.factu.model.Serie;


public interface SerieRepository extends PagingAndSortingRepository<Serie, String> {

//	Page<City> findAll(Pageable pageable);

//	Page<City> findByNameContainingAndCountryContainingAllIgnoringCase(String name,
//			String country, Pageable pageable);
	List<Serie> findByEmpresaId(Long empresaId);
	List<Serie> findAllByOrderByEmpresaIdAscDecAsc();
//	City findByNameAndCountryAllIgnoringCase(String name, String country);

}