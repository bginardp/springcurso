package es.palmademallorca.factu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.palmademallorca.factu.dto.ClienteAjaxDto;
import es.palmademallorca.factu.dto.ClienteDto;
import es.palmademallorca.factu.service.FactuService;

@RestController
public class AjaxController {

	@Autowired
	FactuService factuService;

	@RequestMapping("/ajax/search")
	public List<ClienteAjaxDto> search(@RequestParam("term") String term) {
		Page<ClienteDto> clientes = factuService.getClientes(term, new PageRequest(0, 5));
		List<ClienteAjaxDto> result = new ArrayList<>();
		clientes.getContent()
				.forEach(c -> result.add(new ClienteAjaxDto(c.getNom(), c.getId().toString(), c.getCif(),
						c.getDireccion(), c.getMunicipio(), c.getProvincia(), c.getPostal(), c.getTel(), c.getMovil(),
						c.getEmail())));
		return result;
	}
}
