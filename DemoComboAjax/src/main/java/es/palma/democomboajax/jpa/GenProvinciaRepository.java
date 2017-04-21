package es.palma.democomboajax.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import es.palma.democomboajax.model.GenProvincia;

public interface GenProvinciaRepository 
	extends PagingAndSortingRepository<GenProvincia, Long>{
}
