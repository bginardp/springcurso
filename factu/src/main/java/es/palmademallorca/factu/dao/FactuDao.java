package es.palmademallorca.factu.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Component;

import com.querydsl.jpa.impl.JPAQuery;

import es.palmademallorca.factu.jpa.ClienteRepository;
import es.palmademallorca.factu.jpa.EjercicioRepository;
import es.palmademallorca.factu.jpa.EmpresaRepository;
import es.palmademallorca.factu.jpa.FaclinRepository;
import es.palmademallorca.factu.jpa.FacturaRepository;
import es.palmademallorca.factu.jpa.FormapagoRepository;
import es.palmademallorca.factu.jpa.ProductoRepository;
import es.palmademallorca.factu.jpa.SerieRepository;
import es.palmademallorca.factu.jpa.TipivaRepository;
import es.palmademallorca.factu.jpa.TipivadetRepository;
import es.palmademallorca.factu.model.Cliente;
import es.palmademallorca.factu.model.Ejercicio;
import es.palmademallorca.factu.model.Empresa;
import es.palmademallorca.factu.model.Factura;
import es.palmademallorca.factu.model.Facturalin;
import es.palmademallorca.factu.model.Formapago;
import es.palmademallorca.factu.model.Producto;
import es.palmademallorca.factu.model.QCliente;
import es.palmademallorca.factu.model.QEmpresa;
import es.palmademallorca.factu.model.QFactura;
import es.palmademallorca.factu.model.QFacturalin;
import es.palmademallorca.factu.model.QProducto;
import es.palmademallorca.factu.model.Serie;
import es.palmademallorca.factu.model.Tipiva;
import es.palmademallorca.factu.model.TipivaDet;

@Component
public class FactuDao {
	@Autowired
	private EjercicioRepository ejercicioRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EmpresaRepository empresaRepository;
	@Autowired
	private FacturaRepository facturaRepository;
	@Autowired
	private FaclinRepository faclinRepository;
	
	@Autowired
	private ProductoRepository productoRepository;
	@Autowired
	private FormapagoRepository formapagoRepository;
	@Autowired
	private SerieRepository serieRepository;
	@Autowired
	private TipivaRepository tipivaRepository;
	@Autowired
	private TipivadetRepository tipivadetRepository;
	@Autowired
	private EntityManager entityManager;
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@PostConstruct
	public void init() {
		
		Empresa empresa=empresaRepository.findOne(1L);
		if (empresa==null) {
			LOGGER.info("################ iniciant les dades #################");
			empresa=new Empresa(1L, "EMPRESA 1", "EMPRESA 1 AMPLIADA", "C/PRUEBAS NUM:14 BAJOS", "", "PALMA","B01234567", "MADRID", "911232342", "provae@dmaoin.com", "07008");
			empresaRepository.save(empresa);
			Serie serie = new Serie("A", "SA", "S", 1L);
			serieRepository.save(serie);
			Ejercicio ejercicio=new Ejercicio(2018L);
			ejercicioRepository.save(ejercicio);
			Formapago fp = new Formapago("transferencia", "S");
			formapagoRepository.save(fp);
			fp = new Formapago("talon", "S");
			formapagoRepository.save(fp);
		    Cliente cliente=new Cliente("432345678", "ZARDOYA S.A", "POLIGOCO CAN VALERO NAVE 34", "PALMA", "ILLES BALEARS", "08002",
					"917234123", "616232323", "zardoya@company.com", null, 1L);
		    clienteRepository.save(cliente);
		    cliente=new Cliente("A02345678", "LICOR 43 S.A", "POLIGOCO SON ROSSINYOL 23", "PALMA", "ILLES BALEARS", "02002",
					"937234123", "618232323", "licor43@company.com", null, 1L);
		    clienteRepository.save(cliente);
		    Tipiva tipiva = new Tipiva("1","ordinario");
		    tipivaRepository.save(tipiva);
		    TipivaDet tipivadet = new TipivaDet(tipiva, 2017L, 01L, new BigDecimal(21), BigDecimal.ZERO);
		    tipivadetRepository.save(tipivadet);
		    Producto producto = new Producto("P1", "PRODUCTO 01", new BigDecimal(10.5), "S", tipiva);
		    productoRepository.save(producto);
		    
		    tipiva = new Tipiva("2","reducido");
		    tipivaRepository.save(tipiva);
		    tipivadet = new TipivaDet(tipiva, 2017L, 01L, new BigDecimal(10), BigDecimal.ZERO);
		    tipivadetRepository.save(tipivadet);
		    producto = new Producto("P2", "PRODUCTO 02", new BigDecimal(100), "S", tipiva);
		    productoRepository.save(producto);
		    
		    LOGGER.info("################ finalitzada inicialització de les dades #################");
		}
		
		
	}

	public Page<Cliente> findClientesByTerm(String term, Pageable pageRequest) {
		// 1ª opción -> nombre de método complejo en el repositorio -> no
		// 2ª opción -> HQL -> consulta dentro de un string, no se compila!
		// List<Article> arts = entityManager.createQuery("from Articles where
		// ....");
		// 3ª opción -> QueryDSL -> permite que el compilador nos ayude a
		// escribir HQL.
		QCliente cliente = QCliente.cliente;
		// creación de consulta
		JPAQuery<Cliente> query = new JPAQuery<>(entityManager);
		query.from(cliente);
		if (term != null) {
			query.where(cliente.nom.likeIgnoreCase("%" + term + "%").or(cliente.cif.likeIgnoreCase("%" + term + "%")));
		}
		query.orderBy(cliente.nom.asc());
		// gestión de paginado
		long offset = pageRequest.getPageSize() * pageRequest.getPageNumber();
		query.limit(pageRequest.getPageSize());
		query.offset(offset);
		// preparación de resultado
		List<Cliente> list = query.fetch();
		Long total = query.fetchCount();
		PageImpl<Cliente> result = new PageImpl<>(list, pageRequest, total);
		return result;
	}
	
	public Page<Empresa> findEmpresasByTerm(String term, Pageable pageRequest) {
		// 1ª opción -> nombre de método complejo en el repositorio -> no
		// 2ª opción -> HQL -> consulta dentro de un string, no se compila!
		// List<Article> arts = entityManager.createQuery("from Articles where
		// ....");
		// 3ª opción -> QueryDSL -> permite que el compilador nos ayude a
		// escribir HQL.
		QEmpresa empresa = QEmpresa.empresa;
		// creación de consulta
		JPAQuery<Empresa> query = new JPAQuery<>(entityManager);
		query.from(empresa);
		if (term != null) {
			query.where(empresa.dem.likeIgnoreCase("%" + term + "%").or(empresa.nif.likeIgnoreCase("%" + term + "%")));
		}
		query.orderBy(empresa.dem.asc());
		// gestión de paginado
		long offset = pageRequest.getPageSize() * pageRequest.getPageNumber();
		query.limit(pageRequest.getPageSize());
		query.offset(offset);
		// preparación de resultado
		List<Empresa> list = query.fetch();
		Long total = query.fetchCount();
		PageImpl<Empresa> result = new PageImpl<>(list, pageRequest, total);
		return result;
	}

	public Cliente getCliente(Long clienteId) {
		if (clienteId != null) {
			return clienteRepository.findOne(clienteId);
		}
		return null;
	}

	public void removeCliente(Long clienteId) {
		if (clienteId != null) {
			clienteRepository.delete(clienteId);
		}
	}

	public List<Empresa> findAllEmpresas() {
		Iterable<Empresa> empresas = empresaRepository.findAll(new Sort(new Order(Direction.ASC, "dem")));
		return convertItToList(empresas);
	}

	public List<Producto> findAllProductos() {
		Iterable<Producto> productos = productoRepository.findAll(new Sort(new Order(Direction.ASC, "dem")));
		return convertItToList(productos);
	}

	public Page<Producto> findProductosByTerm(String term, Pageable pageRequest) {
		// 1ª opción -> nombre de método complejo en el repositorio -> no
		// 2ª opción -> HQL -> consulta dentro de un string, no se compila!
		// List<Article> arts = entityManager.createQuery("from Articles where
		// ....");
		// 3ª opción -> QueryDSL -> permite que el compilador nos ayude a
		// escribir HQL.
		QProducto producto = QProducto.producto;
		// creación de consulta
		JPAQuery<Producto> query = new JPAQuery<>(entityManager);
		query.from(producto);
		if (term != null) {
			query.where(producto.dem.likeIgnoreCase("%" + term + "%"));
		}
		query.orderBy(producto.dem.asc());
		// gestión de paginado
		long offset = pageRequest.getPageSize() * pageRequest.getPageNumber();
		query.limit(pageRequest.getPageSize());
		query.offset(offset);
		// preparación de resultado
		List<Producto> list = query.fetch();
		Long total = query.fetchCount();
		PageImpl<Producto> result = new PageImpl<>(list, pageRequest, total);
		return result;
	}

	public List<Ejercicio> findAllEjercicios() {
		Iterable<Ejercicio> ejercicios = ejercicioRepository.findAll(new Sort(new Order(Direction.DESC, "id")));
		return convertItToList(ejercicios);
	}

	public List<Formapago> findAllForpag() {
		Iterable<Formapago> formaspago = formapagoRepository.findAll(new Sort(new Order(Direction.ASC, "id")));
		return convertItToList(formaspago);
	}

	public List<Serie> findAllSeries(Long empresaId) {
		return serieRepository.findByEmpresaId(empresaId);
	}

	public List<Tipiva> findAllTipiva() {
		Iterable<Tipiva> tipiva = tipivaRepository.findAll(new Sort(new Order(Direction.ASC, "id")));
		return convertItToList(tipiva);
	}
	public List<TipivaDet> findAllTipivaDet() {
		Iterable<TipivaDet> tipivadet = tipivadetRepository.findAll(new Sort(new Order(Direction.ASC, "id")));
		return convertItToList(tipivadet);
	}

	public List<TipivaDet> findAllTipivaDetByTipivaId(String tipivaId) {
		Iterable<TipivaDet> tipivadet = tipivadetRepository.findByTipivaIdOrderByAnyoAscMesAsc(tipivaId);
		return convertItToList(tipivadet);
	}
	
	public Page<Factura> findFacturasByTerm(Long empresa, Long ejercicio, String term, Pageable pageRequest) {
		// 1ª opción -> nombre de método complejo en el repositorio -> no
		// 2ª opción -> HQL -> consulta dentro de un string, no se compila!
		// List<Article> arts = entityManager.createQuery("from Articles where
		// ....");
		// 3ª opción -> QueryDSL -> permite que el compilador nos ayude a
		// escribir HQL.
		QFactura factura = QFactura.factura;
		// creación de consulta
		JPAQuery<Factura> query = new JPAQuery<>(entityManager);
		query.from(factura);
		query.where(factura.ejercicioId.eq(ejercicio).and(factura.empresaId.eq(empresa)));
		if (StringUtils.isNotBlank(term)) {
			query.where(factura.cliente.nom.containsIgnoreCase(term).or(factura.cliente.cif.contains(term)));
		} 
		query.orderBy(factura.id.asc());
		// gestión de paginado
		long offset = pageRequest.getPageSize() * pageRequest.getPageNumber();
		query.limit(pageRequest.getPageSize());
		query.offset(offset);
		// preparación de resultado
		List<Factura> list = query.fetch();
		Long total = query.fetchCount();
		PageImpl<Factura> result = new PageImpl<>(list, pageRequest, total);
		return result;
	}

	public List<Facturalin> findFaclinByFacturaId(Long facturaId) {
		// TODO Auto-generated method stub
		QFacturalin faclin = QFacturalin.facturalin;
		JPAQuery<Facturalin> query = new JPAQuery<>(entityManager);
		query.from(faclin).where(faclin.facturaId.eq(facturaId)).orderBy(faclin.id.asc());
		List<Facturalin> result = query.fetch();
		return result;
	}

	public Factura getFactura(Long facturaId) {
		if (facturaId != null) {
			return facturaRepository.findOne(facturaId);
		}
		return null;
	}

	public Facturalin findOneFaclin(Long faclinId) {
		if (faclinId != null) {
			return faclinRepository.findOne(faclinId);
		}
		return null;
	}

	
	public void saveFactura(Factura factura) {
		if (factura != null) {
			// if (product.getId()==null){
			// product.setId((long)productRepository.count());
			// }
			Factura facDB = getFactura(factura.getId());
			if (facDB != null) {
				// TODO
				// facDB.setCif(cliente.getCif());
				// prodDB.setTitle(product.getTitle());
				// prodDB.setPrice(product.getPrice());
				// prodDB.setVisible(product.isVisible());
			}
			facturaRepository.save(factura);
		}

	}

	public void removeFactura(Long facturaId) {
		if (facturaId != null) {
			facturaRepository.delete(facturaId);
		}
	}

	
	public void saveFacturalin(Facturalin faclin) {
		faclinRepository.save(faclin);

	}
	
	
	public Empresa getEmpresa(Long empresaId) {
		if (empresaId != null) {
			return empresaRepository.findOne(empresaId);
		}
		return null;
	}
	
	public Ejercicio getEjercicio(long ejercicioId) {
		if (ejercicioId >0) {
			return ejercicioRepository.findOne(ejercicioId);
		}
		return null;
	}


	public Formapago getFormapago(Long formapagoId) {
		if (formapagoId != null) {
			return formapagoRepository.findOne(formapagoId);
		}
		return null;
	}

	public Producto getProducto(String productoId) {
		if (productoId != null) {
			return productoRepository.findOne(productoId);
		}
		return null;
	}

	public Serie getSerie(String serieId) {
		if (serieId != null) {
			return serieRepository.findOne(serieId);
		}
		return null;
	}

	public TipivaDet getTipIvaDet(Long id) {
		if (id != null) {
			return tipivadetRepository.findOne(id);
		}
		return null;
	}
	
	public Tipiva getTipIva(String id) {
		if (id != null) {
			return tipivaRepository.findOne(id);
		}
		return null;
	}
	
	public void removeFormaPago(Long formapagoId) {
		if (formapagoId != null) {
			formapagoRepository.delete(formapagoId);
		}

	}

	public void removeProducto(String productoId) {
		if (productoId != null) {
			productoRepository.delete(productoId);
		}

	}

	public void removeSerie(String serieId) {
		if (serieId != null) {
			serieRepository.delete(serieId);
		}
	}
	
	public void removeTipiva(String id) {
		if (id != null) {
			tipivaRepository.delete(id);
		}
	}

	public void removeTipivaDet(Long id) {
		if (id != null) {
			tipivadetRepository.delete(id);
		}
	}

	public void saveEmpresa(Empresa empresa) {
		if (empresa != null) {
			empresaRepository.save(empresa);
		}

	}

	public void saveCliente(Cliente cliente) {
		if (cliente != null) {
			clienteRepository.save(cliente);
		}

	}

	public void saveEjercicio(Ejercicio ejercicio) {
		if (ejercicio != null) {
			ejercicioRepository.save(ejercicio);
		}

	}

	public void saveFormapago(Formapago formapago) {
		if (formapago != null) {
			formapagoRepository.save(formapago);
		}
	}

	public void saveProducto(Producto producto) {
		if (producto != null) {
			productoRepository.save(producto);
		}

	}

	public void saveSerie(Serie serie) {
		if (serie != null) {
			serieRepository.save(serie);
		}
		
	}

	public void saveTipiva(Tipiva tipiva) {
		if (tipiva != null) {
			tipivaRepository.save(tipiva);
		}
		
	}

	public void saveTipivaDet(TipivaDet tipivadet) {
		if (tipivadet != null) {
			tipivadetRepository.save(tipivadet);
		}
		
	}

	private <T> List<T> convertItToList(Iterable<T> labels) {
		List<T> result = new ArrayList<>();
		for (T label : labels) {
			result.add(label);
		}
		return result;
	}

	public Ejercicio getDefaultEjercicio() {
		return ejercicioRepository.findFirstByOrderByIdDesc();
	}

	
	
	
}
