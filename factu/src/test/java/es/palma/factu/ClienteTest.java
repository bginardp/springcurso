package es.palma.factu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import es.palmademallorca.factu.FactuApp;
import es.palmademallorca.factu.dto.EjercicioDto;
import es.palmademallorca.factu.service.FactuService;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes=FactuApp.class)
public class ClienteTest {
	@Autowired
	FactuService factuService;
	
	@Test
	public void test() {
        EjercicioDto ejercicio=factuService.getEjercicio(2015);
//		ClientesDAO model = new ClientesService(em);
//		List<Cliente> clientes= model.getClientes();
//
//	    for (Iterator<Cliente> iterator = clientes.iterator(); iterator.hasNext();) {
//			Cliente clienteJPA = iterator.next();
//			System.out.println(clienteJPA.getId() + " " + clienteJPA.getCif() + " " + clienteJPA.getNom());
//
//		}
//
System.out.println(ejercicio.getId());
		assert(ejercicio!=null);


		// fail("Not yet implemented");
	}

}
