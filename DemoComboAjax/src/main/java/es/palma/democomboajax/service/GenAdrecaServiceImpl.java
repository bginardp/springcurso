package es.palma.democomboajax.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.palma.democomboajax.jpa.GenMunicipiRepository;
import es.palma.democomboajax.jpa.GenProvinciaRepository;
import es.palma.democomboajax.model.GenMunicipi;
import es.palma.democomboajax.model.GenProvincia;
import es.palma.democomboajax.model.MunicipiId;

@Service("genAdrecaService")
public class GenAdrecaServiceImpl implements GenAdrecaService{
	@Autowired
	private GenProvinciaRepository provinciaRepository;
	@Autowired
	private GenMunicipiRepository municipiRepository;
	
	@Override
	public GenProvincia getProvincia(Long id) {
		return provinciaRepository.findOne(id);
	}
	@Override
	public List<GenProvincia> getProvincies() {
		List<GenProvincia> result=new ArrayList<GenProvincia>();
		Iterator<GenProvincia> it=provinciaRepository.findAll().iterator();
		while(it.hasNext()){
			result.add(it.next());
		}
		return result;
	}
	@Override
	public List<GenMunicipi> getMunicipis(Long idProvincia) {
		
		List<GenMunicipi> list = municipiRepository.findByMunicipiIdProCon(idProvincia);
		return list;
	}
	@Override
	public GenMunicipi getMunicipi(MunicipiId id) {
		// TODO Auto-generated method stub
		return null;
	}
}