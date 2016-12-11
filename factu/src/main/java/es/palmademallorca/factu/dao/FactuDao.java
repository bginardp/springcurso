package es.palmademallorca.factu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

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
import es.palmademallorca.factu.model.Cliente;
import es.palmademallorca.factu.model.Ejercicio;
import es.palmademallorca.factu.model.Empresa;
import es.palmademallorca.factu.model.Factura;
import es.palmademallorca.factu.model.Facturalin;
import es.palmademallorca.factu.model.Formapago;
import es.palmademallorca.factu.model.Producto;
import es.palmademallorca.factu.model.QCliente;
import es.palmademallorca.factu.model.QFactura;
import es.palmademallorca.factu.model.QFacturalin;
import es.palmademallorca.factu.model.QProducto;
import es.palmademallorca.factu.model.Serie;
import es.palmademallorca.factu.model.Tipiva;

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
	private EntityManager entityManager;

	@PostConstruct
	public void init() {
		System.out.println("########### dao post construct");
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
		if (term != null ) {
			query.where(cliente.nom.likeIgnoreCase("%" + term + "%")
					.or(cliente.cif.likeIgnoreCase("%" + term + "%")));
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
	
	public Cliente getCliente(Long clienteId) {
		if (clienteId != null) {
			return clienteRepository.findOne(clienteId);
		}
		return null;
	}
	

	public void saveCliente(Cliente cliente) {
		if (cliente != null) {
			// if (product.getId()==null){
			// product.setId((long)productRepository.count());
			// }
			Cliente cliDB = getCliente(cliente.getId());
			if (cliDB != null) {
				// TODO
				cliDB.setCif(cliente.getCif());
				// prodDB.setTitle(product.getTitle());
				// prodDB.setPrice(product.getPrice());
				// prodDB.setVisible(product.isVisible());
			}
			clienteRepository.save(cliente);
		}

	}

	public void removeCliente(Long clienteId) {
		if (clienteId != null) {
			clienteRepository.delete(clienteId);
		}
	}

	public List<Empresa> findAllEmpresas() {
		Iterable<Empresa> empresas = empresaRepository.findAll(
				new Sort(new Order(Direction.ASC,"dem")));
		return convertItToList(empresas);
	}
	
	public List<Producto> findAllProductos() {
		Iterable<Producto> productos = productoRepository.findAll(
				new Sort(new Order(Direction.ASC,"dem")));
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
		if (term != null ) {
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
		Iterable<Ejercicio> ejercicios = ejercicioRepository.findAll(
				new Sort(new Order(Direction.DESC,"id")));
		return convertItToList(ejercicios);
	}
	
	public List<Formapago> findAllForpag() {
		Iterable<Formapago> formaspago= formapagoRepository.findAll(
				new Sort(new Order(Direction.ASC,"dem")));
		return convertItToList(formaspago);
	}

	public List<Serie> findAllSeries() {
		Iterable<Serie> series= serieRepository.findAll(
				new Sort(new Order(Direction.ASC,"dec")));
		return convertItToList(series);
	}
	
	public List<Tipiva> findAllTipiva() {
		Iterable<Tipiva> tiposiva= tipivaRepository.findAll(
				new Sort(new Order(Direction.ASC,"dem")));
		return convertItToList(tiposiva);
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
				if (term != null ) {
					query.where(factura.ejercicioId.eq(ejercicio)
						.and(factura.empresaId.eq(empresa)));

//					query.where(factura..nom.likeIgnoreCase("%" + term + "%")
//							.or(factura.cif.likeIgnoreCase("%" + term + "%")));
				}
				else {
					query.where(factura.ejercicioId.eq(ejercicio)
							.and(factura.empresaId.eq(empresa)));
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
	

	public void saveFactura(Factura factura) {
		if (factura != null) {
			// if (product.getId()==null){
			// product.setId((long)productRepository.count());
			// }
			Factura facDB = getFactura(factura.getId());
			if (facDB != null) {
				// TODO
//				facDB.setCif(cliente.getCif());
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
	
	
	
	private <T> List<T> convertItToList(Iterable<T> labels) {
		List<T> result = new ArrayList<>();
		for (T label : labels){
			result.add(label);
		}
		return result;
	}

	public void saveFacturalin(Facturalin faclin) {
		faclinRepository.save(faclin);
		
	}
	
}
