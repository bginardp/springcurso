package es.palmademallorca.factu.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.palmademallorca.factu.beans.UserSession;
import es.palmademallorca.factu.dao.FactuDao;
import es.palmademallorca.factu.dto.ClienteDto;
import es.palmademallorca.factu.dto.EjercicioDto;
import es.palmademallorca.factu.dto.EmpresaDto;
import es.palmademallorca.factu.dto.FacImpuestoDto;
import es.palmademallorca.factu.dto.FacLinDto;
import es.palmademallorca.factu.dto.FacturaDto;
import es.palmademallorca.factu.dto.FormapagoDto;
import es.palmademallorca.factu.dto.ProductoDto;
import es.palmademallorca.factu.dto.SerieDto;
import es.palmademallorca.factu.dto.TipivaDto;
import es.palmademallorca.factu.model.Cliente;
import es.palmademallorca.factu.model.Ejercicio;
import es.palmademallorca.factu.model.Empresa;
import es.palmademallorca.factu.model.Factura;
import es.palmademallorca.factu.model.Facturalin;
import es.palmademallorca.factu.model.Formapago;
import es.palmademallorca.factu.model.Producto;
import es.palmademallorca.factu.model.Serie;
import es.palmademallorca.factu.model.Tipiva;

@Service(value = "factuService")
public class FactuServiceImpl implements FactuService {
	@Autowired
	private FactuDao factuDao;
	@Autowired 
	private HttpSession httpSession;
	
	@PostConstruct
	private void init () {
//		this.empresa=new Empresa(new Long(1),"empresa A","empresa A","ce ciutadella 25 2d","","palma","123456789","illes balears","971123456","company@putmail.com","07003");
//		this.setEjercicio(new Ejercicio(2016));
		System.out.println("######################### Servei creat");
	}
	
	@Override
	public String init(long ejercicio, long empresaId) {
		return "ok";

	}
	
	@Override
	public List<EjercicioDto> findAllEjercicios() {
		List<Ejercicio> ejercicios=factuDao.findAllEjercicios();
		List<EjercicioDto> content=new ArrayList<EjercicioDto>();
		for (Ejercicio ejercicio : ejercicios){
			content.add(new EjercicioDto(ejercicio));
		}
		return content;
	}
	
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
	public List<FormapagoDto> findAllFormaspago() {
		List<Formapago> formaspago=factuDao.findAllForpag();
		List<FormapagoDto> content=new ArrayList<FormapagoDto>();
		for (Formapago formapago: formaspago){
			content.add(new FormapagoDto(formapago));
		}
		return content;
	}
	
	@Override
	public List<ProductoDto> findAllProductos() {
		List<Producto> productos=factuDao.findAllProductos();
		List<ProductoDto> content=new ArrayList<ProductoDto>();
		for (Producto producto: productos){
			content.add(new ProductoDto(producto));
		}
		return content;
	}

	@Override
	public List<SerieDto> findAllSeries() {
		List<Serie> series=factuDao.findAllSeries();
		List<SerieDto> content=new ArrayList<SerieDto>();
		for (Serie serie: series){
			content.add(new SerieDto(serie));
		}
		return content;
	}

	@Override
	public List<TipivaDto> findAllTiposIva() {
		List<Tipiva> tiposiva=factuDao.findAllTipiva();
		List<TipivaDto> content=new ArrayList<TipivaDto>();
		for (Tipiva tipoiva: tiposiva){
			content.add(new TipivaDto(tipoiva));
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
	public FormapagoDto getFormapago(long formapagoId) {
		Formapago formapago=factuDao.getFormapago(formapagoId);
		FormapagoDto formapagoDto=new FormapagoDto(formapago);
		return formapagoDto;
	}

	@Override
	public ProductoDto getProducto(String productoId) {
		Producto producto=factuDao.getProducto(productoId);
		ProductoDto productoDto=new ProductoDto(producto);
		return productoDto;
	}

	@Override
	public SerieDto getSerie(String serieId) {
		Serie serie=factuDao.getSerie(serieId);
		SerieDto serieDto=new SerieDto(serie);
		return serieDto;
	}
	
	@Override
	public EjercicioDto getEjercicio(long ejercicio) {
		return new EjercicioDto(new Ejercicio(2016));

	}
	
	@Override
	public TipivaDto getTipoIva(long tipoivaId) {
		Tipiva tipoiva=factuDao.getTipoIva(tipoivaId);
		TipivaDto tipoivaDto=new TipivaDto(tipoiva);
		return tipoivaDto;
	}
	

	@Override
	public ClienteDto getCliente(Long clienteId) {
		Cliente cliente=factuDao.getCliente(clienteId);
		ClienteDto cliDto=new ClienteDto(cliente);
		return cliDto;
	}
	
	@Override
	public FacturaDto getFactura(Long facturaId) {
		Factura factura=factuDao.getFactura(facturaId);
		FacturaDto facDto=new FacturaDto(factura);
		return facDto;
	}


	@Override
	public void removeFormaPago(long formapagoId) {
		factuDao.removeFormaPago(formapagoId);
		
	}

	@Override
	public void removeProducto(String productoId) {
		factuDao.removeProducto(productoId);
		
	}

	@Override
	public void removeSerie(String serieId) {
		factuDao.removeSerie(serieId);
		
	}

	@Override
	public void removeTipoiva(long tipoivaId) {
		factuDao.removeTipoiva(tipoivaId);
		
	}
	
	@Override
	public void removeCliente(Long clienteId) {
		factuDao.removeCliente(clienteId);
	}
	
	@Override
	public void removeFactura(Long facturaId) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Long saveEmpresa(EmpresaDto empresaDto) {
		Empresa empresa=new Empresa(empresaDto);
		factuDao.saveEmpresa(empresa);
		return empresa.getId();
		
	}

	@Override
	public void saveEjercicio(EjercicioDto ejercicioDto) {
		Ejercicio ejercicio=new Ejercicio(ejercicioDto);
		factuDao.saveEjercicio(ejercicio);
		
	}

	@Override
	public Long saveFormapago(FormapagoDto formapagoDto) {
		Formapago formapago=new Formapago(formapagoDto);
		factuDao.saveFormapago(formapago);
		return formapago.getId();
		
	}

	@Override
	public void saveProducto(ProductoDto productoDto) {
		Producto producto=new Producto(productoDto);
		factuDao.saveProducto(producto);
		
	}

	@Override
	public void saveSerie(SerieDto serieDto) {
		Serie serie=new Serie(serieDto);
		factuDao.saveSerie(serie);
		
	}

	@Override
	public Long saveTipiva(TipivaDto tipivaDto) {
		Tipiva tipoiva=new Tipiva(tipivaDto);
		factuDao.saveTipoiva(tipoiva);
		return tipoiva.getId();
	}

	@Override
	public Long saveCliente(ClienteDto clienteDto) {
		Cliente cliente=new Cliente(clienteDto);
		factuDao.saveCliente(cliente);
		return cliente.getId();
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
	public Page<ClienteDto> getClientes(String term, Pageable pageRequest) {
		Page<Cliente> page = factuDao.findClientesByTerm(term, pageRequest);
		List<ClienteDto> content = new ArrayList<>();
		for (Cliente cliente : page){
			content.add(new ClienteDto(cliente));
		}
		return new PageImpl<>(content, pageRequest, page.getTotalElements());
	}

	@Override
	public Page<ProductoDto> getProductos(String term, Pageable pageRequest) {
		Page<Producto> page = factuDao.findProductosByTerm(term, pageRequest);
		List<ProductoDto> content = new ArrayList<>();
		for (Producto producto : page){
			content.add(new ProductoDto(producto));
		}
		return new PageImpl<>(content, pageRequest, page.getTotalElements());
	}
	

	@Override
	public Page<FacturaDto> getFacturas(Long empresa, Long ejercicio,String term,Pageable pageRequest) {
		
		Page<Factura> page = factuDao.findFacturasByTerm(empresa,ejercicio,term, pageRequest);
		List<FacturaDto> content = new ArrayList<>();
		for (Factura factura : page){
			content.add(new FacturaDto(factura));
		}
		return new PageImpl<>(content, pageRequest, page.getTotalElements());
	}

	@Override
	public List<FacLinDto> getFaclinByFacturaId(Long facturaId) {
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

	
	

	
	
	

	
	
	

}
