package es.palmademallorca.factu.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.palmademallorca.factu.dao.AdminDao;
import es.palmademallorca.factu.dao.FactuDao;
import es.palmademallorca.factu.dto.ClienteDto;
import es.palmademallorca.factu.dto.FacLinDto;
import es.palmademallorca.factu.dto.FacturaDto;
import es.palmademallorca.factu.dto.FormapagoDto;
import es.palmademallorca.factu.dto.ProductoDto;
import es.palmademallorca.factu.dto.SerieDto;
import es.palmademallorca.factu.dto.TipivaDetDto;
import es.palmademallorca.factu.dto.TipivaDto;
import es.palmademallorca.factu.model.Cliente;
import es.palmademallorca.factu.model.Factura;
import es.palmademallorca.factu.model.Facturalin;
import es.palmademallorca.factu.model.Formapago;
import es.palmademallorca.factu.model.Producto;
import es.palmademallorca.factu.model.Serie;
import es.palmademallorca.factu.model.Tipiva;
import es.palmademallorca.factu.model.TipivaDet;
import es.palmademallorca.factu.utils.Converter;

@Service(value = "factuService")
public class FactuServiceImpl implements FactuService {
	@Autowired
	private FactuDao factuDao;
	@Autowired
	private AdminDao adminDao;

	@PostConstruct
	private void init() {
		// this.empresa=new Empresa(new Long(1),"empresa A","empresa A","ce ciutadella
		// 25 2d","","palma","123456789","illes
		// balears","971123456","company@putmail.com","07003");
		// this.setEjercicio(new Ejercicio(2016));
		System.out.println("######################### Servei creat");
	}

	@Override
	public String init(long ejercicio, long empresaId) {
		return "ok";

	}

	
	@Override
	public List<FormapagoDto> findAllFormaspago() {
		List<Formapago> formaspago = adminDao.findAllForpag();
		List<FormapagoDto> content = new ArrayList<FormapagoDto>();
		for (Formapago formapago : formaspago) {
			content.add(new FormapagoDto(formapago));
		}
		return content;
	}

	@Override
	public List<ProductoDto> findAllProductos() {
		List<Producto> productos = adminDao.findAllProductos();
		List<ProductoDto> content = new ArrayList<ProductoDto>();
		for (Producto producto : productos) {
			TipivaDetDto detiva = getTipivaDetVigent(producto.getTipiva().getId(), null);
			if (detiva != null) {
				producto.setPoriva(detiva.getPoriva());
				producto.setRequiv(detiva.getRequiv());
			}
			content.add(Converter.toDto(producto));
		}
		return content;
	}
	
	@Override
	public List<SerieDto> findSeriesByEmpresaId(Long empresaId) {
		List<Serie> series = adminDao.findAllSeries(empresaId);
		List<SerieDto> content = new ArrayList<SerieDto>();
		for (Serie serie : series) {
			content.add(new SerieDto(serie));
		}
		return content;
	}

	@Override
	public List<SerieDto> findAllSeries() {
		List<Serie> series = adminDao.findAllSeries();
		List<SerieDto> content = new ArrayList<SerieDto>();
		for (Serie serie : series) {
			content.add(new SerieDto(serie));
		}
		return content;
	}



	@Override
	public List<TipivaDto> findAllTiposIva() {
		List<Tipiva> tiposiva = adminDao.findAllTipiva();
		List<TipivaDto> content = new ArrayList<TipivaDto>();
		for (Tipiva tipoiva : tiposiva) {
			content.add(new TipivaDto(tipoiva));
		}
		return content;
	}

	@Override
	public List<TipivaDetDto> findAllTiposIvaDet() {
		List<TipivaDet> tiposivadet = adminDao.findAllTipivaDet();
		List<TipivaDetDto> content = new ArrayList<TipivaDetDto>();
		tiposivadet.forEach(t -> content.add(Converter.toDto(t)));
		return content;
	}

	@Override
	public List<ClienteDto> findAllClientes() {
		List<Cliente> clientes = adminDao.findAllClientes();
		List<ClienteDto> content = new ArrayList<ClienteDto>();
		clientes.forEach(c -> content.add(Converter.toDto(c)));
		return content;

	}
	
	@Override
	public List<FacturaDto> findAllFacturas() {
		List<Factura> clientes = factuDao.findAllFacturas();
		List<FacturaDto> content = new ArrayList<FacturaDto>();
		clientes.forEach(c -> content.add(Converter.toDto(c)));
		return content;
	}


	@Override
	public FormapagoDto getFormapago(long formapagoId) {
		Formapago formapago = adminDao.getFormapago(formapagoId);
		FormapagoDto formapagoDto = new FormapagoDto(formapago);
		return formapagoDto;
	}

	@Override
	public ProductoDto getProducto(String productoId) {
		Producto producto = adminDao.getProducto(productoId);
		if (producto.getTipiva() != null) {
			TipivaDetDto detiva = getTipivaDetVigent(producto.getTipiva().getId(), null);
			if (detiva != null) {
				producto.setPoriva(detiva.getPoriva());
				producto.setRequiv(detiva.getRequiv());
			}
		}
		ProductoDto productoDto = new ProductoDto(producto);
		return productoDto;
	}

	@Override
	public SerieDto getSerie(String serieId) {
		SerieDto serieDto=null;
		if (StringUtils.isNotEmpty(serieId)) {
		   Serie serie = adminDao.getSerie(serieId);
		   serieDto = new SerieDto(serie);
		}
		else {
			serieDto=new SerieDto();
		}		
		return serieDto;
	}


	@Override
	public TipivaDto getTipIva(String id) {
		Tipiva tipiva = adminDao.getTipIva(id);
		TipivaDto tipoivaDto = new TipivaDto(tipiva);
		return tipoivaDto;
	}

	@Override
	public TipivaDetDto getTipivaDet(Long id) {
		TipivaDet tipivadet = adminDao.getTipIvaDet(id);
		TipivaDetDto tipivadetDto = new TipivaDetDto(tipivadet);
		return tipivadetDto;
	}

	@Override
	public ClienteDto getCliente(Long clienteId) {
		Cliente cliente = adminDao.getCliente(clienteId);
		ClienteDto cliDto = new ClienteDto(cliente);
		return cliDto;
	}

	@Override
	public FacturaDto getFactura(Long facturaId) {
		Factura factura = factuDao.getFactura(facturaId);
		FacturaDto facDto = Converter.toDto(factura);
		return facDto;
	}
	
	@Override
	public FacturaDto getFactura(Long clienteId, Long empresaId, Long forpagId, Date dat, BigDecimal totfac) {
		Factura factura = factuDao.getFactura(clienteId,  empresaId,  forpagId,  dat,  totfac);
		FacturaDto facDto = Converter.toDto(factura);
		return facDto;
	}

	@Override
	public void removeFormaPago(long formapagoId) {
		adminDao.removeFormaPago(formapagoId);

	}

	@Override
	public void removeProducto(String productoId) {
		adminDao.removeProducto(productoId);

	}

	@Override
	public void removeSerie(String serieId) {
		adminDao.removeSerie(serieId);

	}

	@Override
	public void removeTipiva(String id) {
		adminDao.removeTipiva(id);

	}

	@Override
	public void removeTipivaDet(long id) {
		adminDao.removeTipivaDet(id);

	}

	@Override
	public void removeCliente(Long clienteId) {
		adminDao.removeCliente(clienteId);
	}

	@Override
	public void removeFactura(Long facturaId) {
		// TODO Auto-generated method stub

	}

	

	@Override
	public Long saveFormapago(FormapagoDto formapagoDto) {
		Formapago formapago = new Formapago(formapagoDto);
		adminDao.saveFormapago(formapago);
		return formapago.getId();

	}

	@Override
	public void saveProducto(ProductoDto productoDto) {
		Producto producto = new Producto(productoDto);
		adminDao.saveProducto(producto);

	}

	@Override
	public void saveSerie(SerieDto serieDto) {
		Serie serie = new Serie(serieDto);
		adminDao.saveSerie(serie);

	}

	@Override
	public void saveTipiva(TipivaDto tipivaDto) {
		Tipiva tipiva = new Tipiva(tipivaDto);
		adminDao.saveTipiva(tipiva);
	}

	@Override
	public Long saveTipivaDet(TipivaDetDto tipivaDetDto) {
		TipivaDet tipoivadet = new TipivaDet(tipivaDetDto);
		adminDao.saveTipivaDet(tipoivadet);
		return tipoivadet.getId();
	}

	@Override
	public Long saveCliente(ClienteDto clienteDto) {
		Cliente cliente = new Cliente(clienteDto);
		adminDao.saveCliente(cliente);
		return cliente.getId();
	}

	@Override
	public Long saveFactura(FacturaDto facturaDto) {
		if (facturaDto.getId() != null) {
			// TODO modificació factura
			Factura factura = factuDao.getFactura(facturaDto.getId());
			
			factura.setDat(facturaDto.getDat());
			factura.setImpbru(facturaDto.getImpbru());
			factura.setFormaspago(Converter.toDao(facturaDto.getForpag()));
			factura.setPordto(facturaDto.getPordto());
			factura.setPorirpf(facturaDto.getPorirpf());

			factura.setSerie(Converter.toDao(facturaDto.getSerie()));
			factura.setEjercicio(Converter.toDao(facturaDto.getEjercicio()));
			factura.setTotfac(facturaDto.getTotfac());
			// TODO detall?
			// factura.setDetall(detall);
			factuDao.saveFactura(factura);
			
			// TODO MODIFICACION lineas?
			
			// for (FacLinDto faclindto : facturaDto.getDetall()) {
			// if (faclindto.getFacturaId() == null) {
			// faclindto.setFacturaId(factura.getId());
			// }
			// // TODO tractament modificacio linia
			// Facturalin faclin = new Facturalin(faclindto);
			//
			// factuDao.saveFacturalin(faclin);
			// }
			return factura.getId();
		} else {
			// ALTA
			// 1 guardem la factura. JPA s'encarrega de guardar el detall
			if (facturaDto.hasDetall()) {
				Factura factura = Converter.toDao(facturaDto);
				factuDao.saveFactura(factura);
				return factura.getId();
			}
		}
		return null;
	}

	@Override
	public Long saveFaclin(FacLinDto faclinDto) {
		Facturalin faclin = null;
		Long vRet = null;
		if (faclinDto != null) {
			if (faclinDto.getId() != null) {
				faclin = factuDao.getFacturaLin(faclinDto.getId());
				vRet = faclin.getId();
				faclin.setCantidad(faclinDto.getCantidad());
				faclin.setDem(faclinDto.getDem());
				faclin.setImporte(faclinDto.getImporte());
				faclin.setPordte(faclinDto.getPordte());
				faclin.setPoriva(faclinDto.getPoriva());
				faclin.setRequiv(faclinDto.getRequiv());
				faclin.setProductoId(faclinDto.getProducto().getId());
				faclin.setTipivaId(faclinDto.getTipiva().getId());
			} else {
				faclin = new Facturalin(faclinDto);
				factuDao.saveFacturalin(faclin);
				vRet = faclin.getId();
			}

		}

		return vRet;
	}

	@Override
	public Page<ClienteDto> getClientes(String term, Pageable pageRequest) {
		Page<Cliente> page = adminDao.findClientesByTerm(term, pageRequest);
		List<ClienteDto> content = new ArrayList<>();
		for (Cliente cliente : page) {
			content.add(new ClienteDto(cliente));
		}
		return new PageImpl<>(content, pageRequest, page.getTotalElements());
	}

	@Override
	public Page<ProductoDto> getProductos(String term, Pageable pageRequest) {
		Page<Producto> page = adminDao.findProductosByTerm(term, pageRequest);
		List<ProductoDto> content = new ArrayList<>();
		for (Producto producto : page) {
			TipivaDetDto detiva = getTipivaDetVigent(producto.getTipiva().getId(), null);
			if (detiva != null) {
				producto.setPoriva(detiva.getPoriva());
				producto.setRequiv(detiva.getRequiv());
			}
			content.add(Converter.toDto(producto));
		}
		return new PageImpl<>(content, pageRequest, page.getTotalElements());
	}

	@Override
	public Page<FacturaDto> getFacturas(Long empresa, Long ejercicio, String term, Pageable pageRequest) {

		Page<Factura> page = factuDao.findFacturasByTerm(empresa, ejercicio, term, pageRequest);
		List<FacturaDto> content = new ArrayList<>();
		for (Factura factura : page) {
			content.add(new FacturaDto(factura));
		}
		return new PageImpl<>(content, pageRequest, page.getTotalElements());
	}

	@Override
	public List<FacLinDto> getFaclinByFacturaId(Long facturaId) {
		List<Facturalin> lineas = factuDao.findFaclinByFacturaId(facturaId);
		List<FacLinDto> content = new ArrayList<>();
		for (Facturalin faclin : lineas) {
			content.add(new FacLinDto(faclin));
		}
		return content;
	}

	@Override
	public TipivaDetDto getTipivaDetVigent(String tipivaId, Date data) {
		TipivaDetDto vRet = null;
		TipivaDet aux = null;
		if (data == null) {
			data = new Date(System.currentTimeMillis());

		}
		List<TipivaDet> llista = adminDao.findAllTipivaDetByTipivaId(tipivaId);
		if (!llista.isEmpty()) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(data);
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH);
			int day = cal.get(Calendar.DAY_OF_MONTH);
			for (TipivaDet tipivaDet : llista) {
				if (tipivaDet.getAnyo().intValue() <= year) {
					if (tipivaDet.getMes().intValue() <= month) {
						aux = tipivaDet;
					}
				}
			}
		}
		if (aux != null) {
			vRet = new TipivaDetDto(aux);
		}
		return vRet;
	}

	@Override
	public FacLinDto getFaclin(Long faclinId) {
		Facturalin lin = factuDao.getFacturaLin(faclinId);
		FacLinDto lindto = new FacLinDto(lin);
		return lindto;
	}


	
	

	

}
