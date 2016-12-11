package es.palmademallorca.factu.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.palmademallorca.factu.dto.ClienteDto;
import es.palmademallorca.factu.dto.FacImpuestoDto;
import es.palmademallorca.factu.dto.FacLinDto;
import es.palmademallorca.factu.dto.FacturaDto;
import es.palmademallorca.factu.model.Ejercicio;
import es.palmademallorca.factu.model.Empresa;

public interface FactuService {
	public Ejercicio getEjercicio(long ejercicio);
	public Page<ClienteDto> getClientes(String term, Pageable pageRequest);
	ClienteDto getCliente(Long clienteId);
	void removeCliente(Long clienteId);
	void saveCliente(ClienteDto clienteDto);
	public List<Empresa> getEmpresas();
	public List<Ejercicio> getEjercicios();
    public String init (long ejercicio, long empresaId);
	
	public Page<FacturaDto> findFacturasByTerm(Long empresa, Long ejercicio,String term,Pageable pageRequest);
	public List<FacLinDto> findFaclinByFacturaId(Long facturaId);
	public List<FacImpuestoDto> getImpuestosFactura(Long facturaId);
	FacturaDto getFactura(Long facturaId);
	void saveFactura(FacturaDto facturaDto,List<FacLinDto> detalleDto);
	void removeFactura(Long facturaId);
	
}
