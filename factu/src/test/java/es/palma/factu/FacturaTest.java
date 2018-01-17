package es.palma.factu;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import es.palmademallorca.factu.FactuApp;
import es.palmademallorca.factu.dto.ClienteDto;
import es.palmademallorca.factu.dto.EjercicioDto;
import es.palmademallorca.factu.dto.EmpresaDto;
import es.palmademallorca.factu.dto.FacturaDto;
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
	public void altaFactura() throws ParseException {
	    System.out.println("############# inici altaFactura(): ");
	    Long empresaId=1L;
        Long clienteId=1L;
        Long ejercicioId=2018L;
        Date now=DateUtils.parseDate("01012018", "ddMMyyyy");
        EjercicioDto ejercicio=factuService.getEjercicio(ejercicioId);
        ClienteDto cliente = factuService.getCliente(clienteId);
        EmpresaDto empresa = adminService.getEmpresa(empresaId);
        
        FacturaDto factura=new FacturaDto();
        factura.setEmpresa(empresa);
        factura.setCliente(cliente);
        factura.setEjercicio(ejercicio); 
        factura.setDat(now);
        
        
        System.out.println("############# resultat altaFactura(): "+ factura); 
		assert(ejercicio!=null);


		// fail("Not yet implemented");
	}

}
