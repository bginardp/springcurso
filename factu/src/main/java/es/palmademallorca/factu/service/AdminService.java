package es.palmademallorca.factu.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.palmademallorca.factu.dto.EjercicioDto;
import es.palmademallorca.factu.dto.EmpresaDto;

public interface AdminService {
	
	public List<EmpresaDto> findAllEmpresas();
	EmpresaDto getEmpresa(long empresaId);
	Long saveEmpresa(EmpresaDto empresaDto);
	public Page<EmpresaDto> getEmpresas(String term, Pageable pageRequest);
	
	public List<EjercicioDto> findAllEjercicios();
	EjercicioDto getEjercicio(long ejercicioId);
	void saveEjercicio(EjercicioDto ejercicioDto);
	EjercicioDto getDefaultEjercicio();
	
}
