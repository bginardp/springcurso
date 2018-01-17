package es.palmademallorca.factu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.palmademallorca.factu.dao.FactuDao;
import es.palmademallorca.factu.dto.EmpresaDto;
import es.palmademallorca.factu.model.Empresa;

@Service(value = "adminService")
public class AdminServiceImpl implements AdminService {
	@Autowired
	private FactuDao factuDao;
	
	@Override
	public List<EmpresaDto> findAllEmpresas() {
		List<Empresa> empresas=factuDao.findAllEmpresas();
		List<EmpresaDto> content=new ArrayList<EmpresaDto>();
		for (Empresa empresa : empresas){
			content.add(new EmpresaDto(empresa));
		}
		return content;
	}
	@Override
	public EmpresaDto getEmpresa(long empresaId) {
		Empresa empresa=factuDao.getEmpresa(empresaId);
		EmpresaDto empDto=new EmpresaDto(empresa);
		return empDto;
	}
	
	@Override
	public Long saveEmpresa(EmpresaDto empresaDto) {
		Empresa empresa=new Empresa(empresaDto);
		factuDao.saveEmpresa(empresa);
		return empresa.getId();
		
	}

	@Override
	public Page<EmpresaDto> getEmpresas(String term, Pageable pageRequest) {
		Page<Empresa> page = factuDao.findEmpresasByTerm(term, pageRequest);
		List<EmpresaDto> content = new ArrayList<>();
		for (Empresa e : page){
			content.add(new EmpresaDto(e));
		}
		return new PageImpl<>(content, pageRequest, page.getTotalElements());
	}

}
