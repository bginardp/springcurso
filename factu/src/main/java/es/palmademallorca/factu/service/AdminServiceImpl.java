package es.palmademallorca.factu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.palmademallorca.factu.dao.AdminDao;
import es.palmademallorca.factu.dto.EjercicioDto;
import es.palmademallorca.factu.dto.EmpresaDto;
import es.palmademallorca.factu.model.Ejercicio;
import es.palmademallorca.factu.model.Empresa;
import es.palmademallorca.factu.utils.Converter;

@Service(value = "adminService")
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;
	
	@Override
	public List<EmpresaDto> findAllEmpresas() {
		List<Empresa> empresas=adminDao.findAllEmpresas();
		List<EmpresaDto> content=new ArrayList<EmpresaDto>();
		for (Empresa empresa : empresas){
			content.add(new EmpresaDto(empresa));
		}
		return content;
	}
	@Override
	public EmpresaDto getEmpresa(long empresaId) {
		Empresa empresa=adminDao.getEmpresa(empresaId);
		EmpresaDto empDto=new EmpresaDto(empresa);
		return empDto;
	}
	
	@Override
	public Long saveEmpresa(EmpresaDto empresaDto) {
		Empresa empresa=new Empresa(empresaDto);
		adminDao.saveEmpresa(empresa);
		return empresa.getId();
		
	}

	@Override
	public Page<EmpresaDto> getEmpresas(String term, Pageable pageRequest) {
		Page<Empresa> page = adminDao.findEmpresasByTerm(term, pageRequest);
		List<EmpresaDto> content = new ArrayList<>();
		for (Empresa e : page){
			content.add(new EmpresaDto(e));
		}
		return new PageImpl<>(content, pageRequest, page.getTotalElements());
	}
	
	@Override
	public List<EjercicioDto> findAllEjercicios() {
		List<Ejercicio> ejercicios = adminDao.findAllEjercicios();
		List<EjercicioDto> content = new ArrayList<EjercicioDto>();
		for (Ejercicio ejercicio : ejercicios) {
			content.add(new EjercicioDto(ejercicio));
		}
		return content;
	}

	
	@Override
	public EjercicioDto getEjercicio(long ejercicioId) {
		Ejercicio ejercicio = adminDao.getEjercicio(ejercicioId);
		if (ejercicio == null) {
			ejercicio = new Ejercicio(ejercicioId);
			adminDao.saveEjercicio(ejercicio);
		}
		return Converter.toDto(ejercicio);
	}
	
	@Override
	public void saveEjercicio(EjercicioDto ejercicioDto) {
		Ejercicio ejercicio = new Ejercicio(ejercicioDto);
		adminDao.saveEjercicio(ejercicio);

	}
	
	@Override
	public EjercicioDto getDefaultEjercicio() {
		Ejercicio ejercicio = adminDao.getDefaultEjercicio();
		EjercicioDto dto = new EjercicioDto(ejercicio);
		return dto;
	}
	
	

}
