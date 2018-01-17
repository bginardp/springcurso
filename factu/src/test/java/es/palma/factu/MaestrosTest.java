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
@ContextConfiguration(classes = FactuApp.class)
public class MaestrosTest {
	@Autowired
	FactuService factuService;

	@Test
	public void getEjercicio() {
		System.out.println("############# inici getEjercicio(): ");
		EjercicioDto res = factuService.getEjercicio(2015);
    	System.out.println("############# resultat getEjercicio(): "+ res); 
		assert (res != null);
	}

}
