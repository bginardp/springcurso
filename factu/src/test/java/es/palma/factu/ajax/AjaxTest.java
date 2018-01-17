package es.palma.factu.ajax;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import es.palmademallorca.factu.FactuApp;
import es.palmademallorca.factu.dto.ClienteDto;
import es.palmademallorca.factu.dto.EmpresaDto;
import es.palmademallorca.factu.dto.ProductoDto;
import es.palmademallorca.factu.dto.ajax.ClienteAjaxDto;
import es.palmademallorca.factu.dto.ajax.EmpresaAjaxDto;
import es.palmademallorca.factu.dto.ajax.ProductoAjaxDto;
import es.palmademallorca.factu.service.AdminService;
import es.palmademallorca.factu.service.FactuService;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes=FactuApp.class)
public class AjaxTest {
	@Autowired
	FactuService factuService;
	@Autowired
	AdminService adminService;
	
	@Test
	public void testEmpresas() {
		String term="234";
		Page<EmpresaDto> empresas = adminService.getEmpresas(term, new PageRequest(0, 5));
        List<EmpresaAjaxDto> result = new ArrayList<>();
		empresas.getContent()
				.forEach(c -> result.add(new EmpresaAjaxDto(c.getDec(), c.getId().toString(), c.getDem(),
						c.getNif(),	c.getDireccion(), c.getMunicipio(), c.getProvincia(), c.getPostal(), 
						c.getTel(), c.getFax(),	c.getEmail())));

		result.forEach(e -> System.out.println("####  "+e));
		assertNotNull(empresas);
	}
	
	@Test
	public void testClientes() {
		String term="AJ";
		Page<ClienteDto> clientes = factuService.getClientes(term, new PageRequest(0, 5));
        List<ClienteAjaxDto> result = new ArrayList<>();
		clientes.getContent()
				.forEach(c -> result.add(new ClienteAjaxDto(c.getNom(), c.getId().toString(), 
						c.getCif(),	c.getDireccion(), c.getMunicipio(), c.getProvincia(), c.getPostal(), 
						c.getTel(), c.getMovil(),	c.getEmail())));

		result.forEach(e -> System.out.println("####  "+e));
		assertNotNull(clientes);
	}
	
	@Test
	public void testProductos() {
		String term="234";
		Page<ProductoDto> productos = factuService.getProductos(term, new PageRequest(0, 5));
        List<ProductoAjaxDto> result = new ArrayList<>();
        productos.getContent()
				.forEach(c -> result.add(new ProductoAjaxDto(c.getDem(),c.getId(), c.getDem(),c.getPvp(),c.getTipiva().getId(),c.getTipiva().getDem(),c.getPoriva())));

		result.forEach(e -> System.out.println("####  "+e));
		assertNotNull(productos);
	}



}
