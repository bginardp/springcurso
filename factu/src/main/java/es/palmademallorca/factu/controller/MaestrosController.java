package es.palmademallorca.factu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.palmademallorca.factu.dto.FormapagoDto;
import es.palmademallorca.factu.dto.SerieDto;
import es.palmademallorca.factu.dto.TipivaDto;
import es.palmademallorca.factu.service.AdminService;
import es.palmademallorca.factu.service.FactuService;

@Controller
@RequestMapping("/maestros")
public class MaestrosController {
	@Autowired
	FactuService factuService;
	@Autowired
	AdminService adminService;

	@ModelAttribute("page")
	public String module() {
		return "altres";
	}

	// formas de pago
	@RequestMapping(value = "/formaspago", method = RequestMethod.GET)
	public String listForpag(Model model) {
		model.addAttribute("formaspago", factuService.findAllFormaspago());
		return "maestros/formapago/list";
	}

	@RequestMapping(value = { "/formapago/{id}", "/formapago/new" }, method = RequestMethod.GET)
	public String editForpag(Model model, @PathVariable(value = "id", required = false) Long formapagoId) {
		FormapagoDto formapago = null;
		if (formapagoId != null) {
			formapago = factuService.getFormapago(formapagoId);
		} else {
			formapago = new FormapagoDto();
		}

		return gotoEditForpag(model, formapago);
	}

	private String gotoEditForpag(Model model, FormapagoDto formapago) {
		model.addAttribute("formapago", formapago);
		return "maestros/formapago/edit";
	}

	@RequestMapping(value = "/formapago/save", method = RequestMethod.POST)
	public String saveForpag(Model model, @Valid @ModelAttribute("formapago") FormapagoDto formapago,
			BindingResult results) {
		if (results.hasErrors()) {
			return gotoEditForpag(model, formapago);
		} else {
			Long formapagoId = factuService.saveFormapago(formapago);
			return "redirect:/maestros/formapago/" + formapagoId + "?msg=ok";
		}
	}

	// tipos de iva
	@RequestMapping(value = "/tiposiva", method = RequestMethod.GET)
	public String listTipiva(Model model) {
		model.addAttribute("tiposiva", factuService.findAllTiposIvaDet());
		return "maestros/tipiva/list";
	}

	@RequestMapping(value = { "/tipoiva/{id}", "/tipoiva/new" }, method = RequestMethod.GET)
	public String editTipiva(Model model, @PathVariable(value = "id", required = false) String tipoivaId) {
		TipivaDto tipoiva = null;
		if (tipoivaId != null) {
			tipoiva = factuService.getTipIva(tipoivaId);
		} else {
			tipoiva = new TipivaDto();
		}

		return gotoEditTipiva(model, tipoiva);
	}

	private String gotoEditTipiva(Model model, TipivaDto tipoiva) {
		model.addAttribute("tipoiva", tipoiva);
		return "maestros/tipiva/edit";
	}

	@RequestMapping(value = "/tipoiva/save", method = RequestMethod.POST)
	public String saveTipiva(Model model, @Valid @ModelAttribute("tipoiva") TipivaDto tipoiva, BindingResult results) {
		if (results.hasErrors()) {
			return gotoEditTipiva(model, tipoiva);
		} else {
			factuService.saveTipiva(tipoiva);
			return "redirect:/maestros/tipoiva/" + tipoiva.getId() + "?msg=ok";
		}
	}

	// series
	@RequestMapping(value = "/series", method = RequestMethod.GET)
	public String listSeries(Model model) {
//		UserSession userSession = (UserSession) session.getAttribute("user");
//		if (userSession == null) {
//			model.addAttribute("msgErr",
//					"Es necesario seleccionar una empresa y ejercicio para poder ver las facturas");
//			return null;
//
//		}
//		model.addAttribute("user", userSession);
		model.addAttribute("series", factuService.findAllSeries());

		return "maestros/serie/list";
	}

	@RequestMapping(value = { "/serie/{id}", "/serie/new" }, method = RequestMethod.GET)
	public String editSerie(Model model,
			@PathVariable(value = "id", required = false) String serieId) {
		SerieDto serie = null;
		serie = factuService.getSerie(serieId);
		return gotoEditSerie(model, serie);
	}

	private String gotoEditSerie(Model model, SerieDto serie) {
		model.addAttribute("serie", serie);
		model.addAttribute("empresas", adminService.findAllEmpresas());
		return "maestros/serie/edit";
	}

	@RequestMapping(value = "/serie/save", method = RequestMethod.POST)
	public String saveSerie(Model model, @Valid @ModelAttribute("serie") SerieDto serie, BindingResult results) {
		if (results.hasErrors()) {
			return gotoEditSerie(model, serie);
		} else {
			factuService.saveSerie(serie);
			return "redirect:/maestros/serie/" + serie.getId() + "?msg=ok";
		}
	}
	
	@RequestMapping(value="/serie/remove",method=RequestMethod.POST)
	public String removeSerie(@RequestParam("id") String id){
		factuService.removeSerie(id);
		return "redirect:/maestros/series";
	}

}
