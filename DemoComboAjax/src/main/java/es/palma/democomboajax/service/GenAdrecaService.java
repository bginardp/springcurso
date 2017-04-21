package es.palma.democomboajax.service;

import java.util.List;

import es.palma.democomboajax.model.GenMunicipi;
import es.palma.democomboajax.model.GenProvincia;
import es.palma.democomboajax.model.MunicipiId;

public interface GenAdrecaService {
	GenProvincia getProvincia(Long id);
	List<GenProvincia> getProvincies();
	GenMunicipi getMunicipi(MunicipiId id);
	List<GenMunicipi> getMunicipis(Long idProvincia);
}