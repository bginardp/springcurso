package es.palmademallorca.factu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.palmademallorca.factu.dto.ClienteDto;
import es.palmademallorca.factu.dto.EmpresaDto;
import es.palmademallorca.factu.dto.ProductoDto;
import es.palmademallorca.factu.dto.ajax.ClienteAjaxDto;
import es.palmademallorca.factu.dto.ajax.EmpresaAjaxDto;
import es.palmademallorca.factu.dto.ajax.ProductoAjaxDto;
import es.palmademallorca.factu.service.AdminService;
import es.palmademallorca.factu.service.FactuService;

@RestController
@RequestMapping("/ajax")
public class AjaxController {

	@Autowired
	FactuService factuService;
	@Autowired
	AdminService adminService;

	@RequestMapping("/clientes")
	public List<ClienteAjaxDto> clientes(@RequestParam("term") String term) {
		Page<ClienteDto> clientes = factuService.getClientes(term, new PageRequest(0, 5));
		List<ClienteAjaxDto> result = new ArrayList<>();
		clientes.getContent()
				.forEach(c -> result.add(new ClienteAjaxDto(c.getNom(), c.getId().toString(), c.getCif(),
						c.getDireccion(), c.getMunicipio(), c.getProvincia(), c.getPostal(), c.getTel(), c.getMovil(),
						c.getEmail())));
		return result;
	}
	
	@RequestMapping("/productos")
	public List<ProductoAjaxDto> productos(@RequestParam("term") String term) {
		Page<ProductoDto> productos = factuService.getProductos(term, new PageRequest(0, 5));
		List<ProductoAjaxDto> result = new ArrayList<>();
		productos.getContent()
				.forEach(c -> result.add(new ProductoAjaxDto(c.getDem(), c.getId().toString(), c.getDem(),
						c.getPvp(),c.getTipiva(), c.getPoriva())));
		return result;
	}
	
	@RequestMapping("/empresas")
	public List<EmpresaAjaxDto> empresas(@RequestParam("term") String term) {
		Page<EmpresaDto> empresas = adminService.getEmpresas(term, new PageRequest(0, 5));
		List<EmpresaAjaxDto> result = new ArrayList<>();
		empresas.getContent()
				.forEach(c -> result.add(new EmpresaAjaxDto(c.getDec(), c.getId().toString(), c.getDem(),
						c.getNif(),	c.getDireccion(), c.getMunicipio(), c.getProvincia(), c.getPostal(), 
						c.getTel(), c.getFax(),	c.getEmail())));
		return result;
	}
}
