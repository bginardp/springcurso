package es.palmademallorca.factu.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.palmademallorca.factu.beans.UserSession;
import es.palmademallorca.factu.service.FactuService;

@Controller
@RequestMapping("/facturas")
public class FacturasController {
	// @Autowired
	// UserSession userSession;
	@Autowired
	FactuService factuService;

	@ModelAttribute("page")
	public String module() {
		return "facturas";
	}

	@PostConstruct
	private void init() {
		// this.empresa=new Empresa(new Long(1),"empresa A","empresa A","ce
		// ciutadella 25 2d","","palma","123456789","illes
		// balears","971123456","company@putmail.com","07003");
		// this.setEjercicio(new Ejercicio(2016));
		System.out.println("################ init FacturasController");
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listFacturas(HttpSession session, Model model, @PageableDefault(size = 10) Pageable pageRequest,
			@RequestParam(value = "ejercicio", required = true) Long ejercicio,
			@RequestParam(value = "empresa", required = true) Long empresa,
			@RequestParam(value = "term", required = false) String term) {
		UserSession userSession = (UserSession) session.getAttribute("user");
		if (userSession == null) {
			model.addAttribute("msgErr",
					"Es necesario seleccionar una empresa y ejercicio para poder ver las facturas");
			return null;

		} else {
			model.addAttribute("ejercicio", ejercicio);
			model.addAttribute("empresa", empresa);
			model.addAttribute("term", term);
			model.addAttribute("user",userSession);
			model.addAttribute("facturas", factuService.getFacturas(empresa, ejercicio, term, pageRequest));
		}
		return "factura/list";

	}

}
