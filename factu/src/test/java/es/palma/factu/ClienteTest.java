package es.palma.factu;

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
import es.palmademallorca.factu.service.FactuService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = FactuApp.class)
public class ClienteTest {
	@Autowired
	FactuService factuService;
	
	@Test
	public void getClientesByTerm() {
		System.out.println("############# inici getClientesByTerm(): ");
		Pageable page = new PageRequest(0,10);
		Page<ClienteDto> clientes = factuService.getClientes("43", page);
		System.out.println("############# resultat getClientesByTerm(): "); 
		clientes.forEach(item-> System.out.println(item.getId() + " " + item.getCif() + " " + item.getNom()));
		assert (clientes != null);
	}
	
	@Test
	public void getClientes() {
		System.out.println("############# inici getClientes(): ");
		List<ClienteDto> clientes = factuService.findAllClientes();
		System.out.println("############# resultat getClientes(): "); 
		clientes.forEach(item-> System.out.println(item.getId() + " " + item.getCif() + " " + item.getNom()));
		assert (clientes != null);
	}

}
