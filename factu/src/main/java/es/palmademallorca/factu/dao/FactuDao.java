package es.palmademallorca.factu.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.querydsl.jpa.impl.JPAQuery;

import es.palmademallorca.factu.jpa.FaclinRepository;
import es.palmademallorca.factu.jpa.FacturaRepository;
import es.palmademallorca.factu.model.Cliente;
import es.palmademallorca.factu.model.Empresa;
import es.palmademallorca.factu.model.Factura;
import es.palmademallorca.factu.model.Facturalin;
import es.palmademallorca.factu.model.Producto;
import es.palmademallorca.factu.model.QCliente;
import es.palmademallorca.factu.model.QEmpresa;
import es.palmademallorca.factu.model.QFactura;
import es.palmademallorca.factu.model.QFacturalin;
import es.palmademallorca.factu.model.QProducto;

@Component
public class FactuDao {
	
	@Autowired
	private FacturaRepository facturaRepository;
	@Autowired
	private FaclinRepository faclinRepository;
	@Autowired
	private EntityManager entityManager;
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

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
		QFacturalin faclin = QFacturalin.facturalin;
		JPAQuery<Facturalin> query = new JPAQuery<>(entityManager);
		query.from(faclin).where(faclin.factura.id.eq(facturaId)).orderBy(faclin.id.asc());
		List<Facturalin> result = query.fetch();
		return result;
	}

	
	public void saveFactura(Factura factura) {
		if (factura != null) {
			// if (product.getId()==null){
			// product.setId((long)productRepository.count());
			// }
			if (factura.getId()!=null) {
				Factura facDB = getFactura(factura.getId());
				if (facDB != null) {
					// TODO
					// facDB.setCif(cliente.getCif());
					// prodDB.setTitle(product.getTitle());
					// prodDB.setPrice(product.getPrice());
					// prodDB.setVisible(product.isVisible());
				}
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
	
			
	public Factura getFactura(Long facturaId) {
		if (facturaId != null) {
			return facturaRepository.findOne(facturaId);
		}
		return null;
	}

	public Factura getFactura(Long clienteId, Long empresaId, Long forpagId, Date dat, BigDecimal totfac) {
		if (clienteId != null) {
			return facturaRepository.findByClienteIdAndEmpresaIdAndForpagIdAndDatAndTotfac(clienteId, empresaId, forpagId, dat, totfac);
		}
		return null;
	}
	
	public Facturalin getFacturaLin(Long faclinId) {
		if (faclinId != null) {
			return faclinRepository.findOne(faclinId);
		}
		return null;
	}


	private <T> List<T> convertItToList(Iterable<T> labels) {
		List<T> result = new ArrayList<>();
		for (T label : labels) {
			result.add(label);
		}
		return result;
	}

		

	
	
	
}
