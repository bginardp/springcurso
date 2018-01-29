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
import es.palmademallorca.factu.dto.ProductoDto;
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
		
		Date dat=new Date(System.currentTimeMillis());
		List<FacturaBasesDto> bases = new ArrayList<FacturaBasesDto>();
		BigDecimal impbru=null;
		BigDecimal totfac=null;
		
		FacturaDto factura=new FacturaDto(null, null, dat, serie,
				cliente, ejercicio, empresa, forpag,  detall, bases, null, impbru, BigDecimal.ZERO, BigDecimal.ZERO,
				totfac);
		// 2 afegim linia 1
		
		
				//TipivaDto ivaordinario = factuService.getTipIva("1");
				//TipivaDto ivareducido = factuService.getTipIva("2");
				BigDecimal cantidad=new BigDecimal(10);
				BigDecimal poriva=new BigDecimal(21);		
				BigDecimal precio = new BigDecimal(1000);
				BigDecimal importe= cantidad.multiply(precio);
				BigDecimal pordte = BigDecimal.ZERO;
				String descripcio="Material caro";
				ProductoDto producto=factuService.getProducto("01");
		
		 factura.addLinea(new FacLinDto(null, null, cantidad, descripcio, importe, pordte,
				producto.getTipiva(), poriva, precio, producto, null));
		
		 // 3 afegim linia 2
		 
		 cantidad=new BigDecimal(20);
		 poriva=new BigDecimal(11);		
		 precio = new BigDecimal(1000);
		 importe= cantidad.multiply(precio);
		 pordte = BigDecimal.ZERO;
		 descripcio="Servicios diversos ";
		 producto=factuService.getProducto("02");
		 factura.addLinea(new FacLinDto(null, null, cantidad, descripcio, importe, pordte,
				 producto.getTipiva(), poriva, precio, producto, null));
	
		
		// 4 acumulem les bases imponibles  i el total
		
		bases.add(new FacturaBasesDto(producto.getTipiva(),poriva, null, importe));
	
		impbru=detall.stream().map(FacLinDto::getImporte).reduce(BigDecimal.ZERO,BigDecimal::add);
		
		totfac=impbru.multiply(poriva.divide(new BigDecimal(100)));

		// 5 guardem a bd els canvis
		
		Long id=factuService.saveFactura(factura);
		
		System.out.println("############# resultat altaFactura(): "); 
		assert (id != null);
	}
	
	@Test
	public void getFactura() {
		System.out.println("############# inici getFactura(): ");
		Long facturaId=15L;
		FacturaDto factura = factuService.getFactura(facturaId);
		System.out.println("############# resultat getFactura(): "); 
		System.out.println("### identificador:"+factura.getId());
		System.out.println("############ data:"+factura.getDat());
		System.out.println("########## empresa:"+factura.getEmpresa());
		System.out.println("########### client:"+factura.getCliente());
		System.out.println("### forma pagament:"+factura.getForpag());
		System.out.println("######### exercici:"+factura.getEjercicio());
		System.out.println("############ serie:"+factura.getSerie());
		System.out.println("########### numero:"+factura.getNumero());
		System.out.println("##### detall ######:");
		if (factura.getDetall()!=null) {
		   factura.getDetall().forEach(item->System.out.println(item));
		}
		System.out.println("##### bases  ######:");
		if (factura.getBases()!=null) {
		   factura.getBases().forEach(base->System.out.println(base));
		}
		assert (factura != null);
	}
	
	

}
