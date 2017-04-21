package es.palma.democomboajax.jpa;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import es.palma.democomboajax.model.GenMunicipi;
import es.palma.democomboajax.model.MunicipiId;

public interface GenMunicipiRepository 
	extends PagingAndSortingRepository<GenMunicipi, MunicipiId>{
	List<GenMunicipi> findByMunicipiIdProCon(Long id);
}
