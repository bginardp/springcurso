package es.palmademallorca.factu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.palmademallorca.factu.dao.FactuDao;
import es.palmademallorca.factu.dto.ClienteDto;
import es.palmademallorca.factu.dto.FacImpuestoDto;
import es.palmademallorca.factu.dto.FacLinDto;
import es.palmademallorca.factu.dto.FacturaDto;
import es.palmademallorca.factu.model.Cliente;
import es.palmademallorca.factu.model.Ejercicio;
import es.palmademallorca.factu.model.Empresa;
import es.palmademallorca.factu.model.Factura;
import es.palmademallorca.factu.model.Facturalin;

@Service(value = "factuService")
public class FactuServiceImpl implements FactuService {
	@Autowired
	private FactuDao factuDao;
		
	@Override
	public String init(long ejercicio, long empresaId) {
		return "ok";

	}

	@Override
	public Ejercicio getEjercicio(long ejercicio) {
		return new Ejercicio(2016);

	}

	@Override
	public Page<ClienteDto> getClientes(String term, Pageable pageRequest) {
		Page<Cliente> page = factuDao.findClientesByTerm(term, pageRequest);
		List<ClienteDto> content = new ArrayList<>();
		for (Cliente cliente : page){
			content.add(new ClienteDto(cliente));
		}
		return new PageImpl<>(content, pageRequest, page.getTotalElements());
	}

	@Override
	public ClienteDto getCliente(Long clienteId) {
		Cliente cliente=factuDao.getCliente(clienteId);
		ClienteDto cliDto=new ClienteDto(cliente);
		return cliDto;
	}

	@Override
	public void saveCliente(ClienteDto clienteDto) {
		Cliente cliente=new Cliente(clienteDto);
		factuDao.saveCliente(cliente);

	}

	@Override
	public void removeCliente(Long clienteId) {
		factuDao.removeCliente(clienteId);
	}

	@Override
	public List<Empresa> getEmpresas() {
		return factuDao.findAllEmpresas();
	}

	@Override
	public List<Ejercicio> getEjercicios() {
		return factuDao.findAllEjercicios();
	}

	@Override
	public Page<FacturaDto> findFacturasByTerm(Long empresa, Long ejercicio,String term,Pageable pageRequest) {
		
		Page<Factura> page = factuDao.findFacturasByTerm(empresa,ejercicio,term, pageRequest);
		List<FacturaDto> content = new ArrayList<>();
		for (Factura factura : page){
			content.add(new FacturaDto(factura));
		}
		return new PageImpl<>(content, pageRequest, page.getTotalElements());
	
	}

	@Override
	public List<FacLinDto> findFaclinByFacturaId(Long facturaId) {
		// TODO Auto-generated method stub
		List<Facturalin> lineas = factuDao.findFaclinByFacturaId(facturaId);
		List<FacLinDto> content = new ArrayList<>();
		for (Facturalin faclin : lineas){
			content.add(new FacLinDto(faclin));
		}
		return content;
	}

	@Override
	public List<FacImpuestoDto> getImpuestosFactura(Long facturaId) {
		
		// TODO Auto-generated method stub
		return null;
//		return factuDao.getImpuestoFactura(facturaId);
	}

	@Override
	public FacturaDto getFactura(Long facturaId) {
		Factura factura=factuDao.getFactura(facturaId);
		FacturaDto facDto=new FacturaDto(factura);
		return facDto;
	}

	@Override
	public void saveFactura(FacturaDto facturaDto, List<FacLinDto> detalleDto) {
		Factura factura=new Factura(facturaDto);
		factuDao.saveFactura(factura);
		for (FacLinDto faclindto:detalleDto) {
			Facturalin faclin=new Facturalin(faclindto);
			factuDao.saveFacturalin(faclin);	
		}
	}

	@Override
	public void removeFactura(Long id) {
		// TODO Auto-generated method stub
		
	}

}
