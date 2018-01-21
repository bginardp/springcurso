package es.palma.factu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import es.palmademallorca.factu.FactuApp;
import es.palmademallorca.factu.dto.ClienteDto;
import es.palmademallorca.factu.dto.EjercicioDto;
import es.palmademallorca.factu.dto.EmpresaDto;
import es.palmademallorca.factu.dto.FacLinDto;
import es.palmademallorca.factu.dto.FacturaBasesDto;
import es.palmademallorca.factu.dto.FacturaDto;
import es.palmademallorca.factu.dto.FormapagoDto;
import es.palmademallorca.factu.dto.SerieDto;
import es.palmademallorca.factu.dto.TipivaDto;
import es.palmademallorca.factu.service.AdminService;
import es.palmademallorca.factu.service.FactuService;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes=FactuApp.class)
public class FacturaTest {
	@Autowired
	FactuService factuService;
	@Autowired
	AdminService adminService;
	
	
	@Test
	public void findFacturasByTerm() {
		EmpresaDto empresa=adminService.getEmpresa(1L);
		EjercicioDto ejercicio =factuService.getEjercicio(2018L);
		String term="01";
		System.out.println("############# inici findFacturasByTerm(): ");
		Pageable pageRequest = new PageRequest(0,10);
		Page<FacturaDto> clientes = factuService.getFacturas(empresa.getId(), ejercicio.getId(), term, pageRequest);
		System.out.println("############# resultat findFacturasByTerm(): "); 
		clientes.forEach(item-> System.out.println(item.getId() + " " + item.getCliente() + " " + item.getDat()));
		assert (clientes != null);
	}
	
	@Test
	public void altaFactura() {
		System.out.println("############# inici altaFactura(): ");
		// 1 preparem els paramatres que has d'intervenir amb l'alta
		
		EmpresaDto empresa=adminService.getEmpresa(1L);
		EjercicioDto ejercicio =factuService.getEjercicio(2018L);
		FormapagoDto forpag=factuService.getFormapago(1L); // talon
		ClienteDto cliente=factuService.getCliente(1L);
		SerieDto serie=factuService.getSerie("A");
		
		List<FacLinDto> detall = new ArrayList<FacLinDto>();
		// 2 preparem una línia de detall
		TipivaDto ivaordinario = factuService.getTipIva("1");
		BigDecimal cantidad=new BigDecimal(10);
		BigDecimal poriva=new BigDecimal(21);		
		BigDecimal precio = new BigDecimal(1000);
		BigDecimal importe= cantidad.multiply(precio);
		BigDecimal pordte = BigDecimal.ZERO;
		String descripcio="Material caro";
		String producteId="01";
		Date dat=new Date(System.currentTimeMillis());
		
		detall.add(new FacLinDto(null, null, cantidad, descripcio, importe, pordte,
				ivaordinario, poriva, precio, producteId, null));
		
		// 3 preparem el total
		List<FacturaBasesDto> bases = new ArrayList<FacturaBasesDto>();
		bases.add(new FacturaBasesDto(ivaordinario,poriva, null, importe));
//		
		BigDecimal impbru=detall.stream().map(FacLinDto::getImporte).reduce(BigDecimal.ZERO,BigDecimal::add);
		BigDecimal totfac=impbru.multiply(poriva.divide(new BigDecimal(100)));
		
		FacturaDto factura=new FacturaDto(null, null, dat, serie,
				cliente, ejercicio, empresa, forpag,  detall, bases, null, impbru, BigDecimal.ZERO, BigDecimal.ZERO,
				totfac);
		
		
		Long id=factuService.saveFactura(factura);
		
		System.out.println("############# resultat altaFactura(): "); 
		assert (id != null);
	}
	
	

}
