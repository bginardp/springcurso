package es.palmademallorca.factu.jpa;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.repository.PagingAndSortingRepository;

import es.palmademallorca.factu.model.Factura;


public interface FacturaRepository extends PagingAndSortingRepository<Factura, Long> {

//	Page<City> findAll(Pageable pageable);

//	Page<City> findByNameContainingAndCountryContainingAllIgnoringCase(String name,
//			String country, Pageable pageable);

	Factura findByClienteIdAndEmpresaIdAndForpagIdAndDatAndTotfac(Long clienteId, Long empresaId, Long forpagId, Date dat,BigDecimal totfac);

}