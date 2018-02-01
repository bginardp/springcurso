package es.palmademallorca.factu.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.palmademallorca.factu.dto.ClienteDto;
import es.palmademallorca.factu.dto.CriteriosFacturasDto;
import es.palmademallorca.factu.dto.EjercicioDto;
import es.palmademallorca.factu.dto.EmpresaDto;
import es.palmademallorca.factu.dto.FacLinDto;
import es.palmademallorca.factu.dto.FacturaDto;
import es.palmademallorca.factu.dto.common.ErrorDto;
import es.palmademallorca.factu.service.AdminService;
import es.palmademallorca.factu.service.FactuService;
import es.palmademallorca.factu.utils.Constants;

@Controller
public class FacturasController {
	@Autowired
	FactuService factuService;
	@Autowired
	AdminService adminService;

	@ModelAttribute("page")
	public String module() {
		return "facturas";
	}

	@PostConstruct
	private void init() {
		System.out.println("################ init FacturasController");
	}

	@RequestMapping(value = "/facturas", method = RequestMethod.GET)
	public String listFacturas(Model model, @PageableDefault(size = 10) Pageable pageRequest) {
		CriteriosFacturasDto criteris = new CriteriosFacturasDto();
		Page<FacturaDto> facturas=new PageImpl<>(new ArrayList<FacturaDto>(), pageRequest,0);
		model.addAttribute("facturas", facturas);
		model.addAttribute("criteris", criteris);
		 return gotoFacturasList(model);
			
	}
	
	private String gotoFacturasList(Model model) {
		model.addAttribute("empresas", adminService.findAllEmpresas());
		model.addAttribute("ejercicios", factuService.findAllEjercicios());
	return "factura/list";
		
	}

	@RequestMapping(value = "/facturas/search", method = RequestMethod.GET)
	public String findFacturas(HttpSession session, Model model, 
			@PageableDefault(size = 10) Pageable pageRequest, CriteriosFacturasDto criteris) {
		// begin
//		UserSession userSession = (UserSession) session.getAttribute("user");
//		if (userSession == null) {
//			model.addAttribute("msgErr",
//					"Es necesario seleccionar una empresa y ejercicio para poder ver las facturas");
//			return null;
//
//		} else {
			model.addAttribute("criteris", criteris);
			model.addAttribute("facturas", factuService.getFacturas(criteris.getEmpresaId(), criteris.getEjercicioId(), criteris.getTerm(), pageRequest));
//	}
		return gotoFacturasList(model);
	}
	
	@PostMapping(value = "/factura/save", params={"save"})
	public String save(Model model, @Valid @ModelAttribute("factura") FacturaDto factura, BindingResult results){
		if (results.hasErrors()){
			return gotoEditFactura(model, factura);
		} else {
			factura=validaFacturaForm(factura);
			if (factura.hasErrors()) {
				return gotoEditFactura(model, factura);	
			} else {
				Long facturaId=factuService.saveFactura(factura);
				return "redirect:/factura/"+facturaId+"?msg=ok";	
			}
			
		}
	}
	
	private FacturaDto validaFacturaForm(FacturaDto factura) {
		if (factura.getCliente()==null || StringUtils.isBlank(factura.getCliente().getCif())) {
			factura.addError(new ErrorDto(Constants.ERR_CLIENT_NOTNULL));
		}
		if (factura.getEmpresa()==null || factura.getEmpresa().getId()==0) {
			factura.addError(new ErrorDto(Constants.ERR_EMPRESA_NOTNULL));
		}
		if (!factura.hasDetall()) {
			factura.addError(new ErrorDto(Constants.ERR_LINDET_NOTNULL));
		}
		return factura;
	}

	@RequestMapping(value = "/factura/save", method = RequestMethod.POST, params={"addRow"})
	public String addRow (Model model,@Valid @ModelAttribute("factura") FacturaDto factura,BindingResult results) {
		// 1 obtenim la linia que s'ha editat a la pantalla
		FacLinDto linea=factura.getLinea();
		// 2 valida linea si cal?
		//TODO
		// 3 obtenim la llista de linies i afegim la linia editada a la llista
		List<FacLinDto> detall=factura.getDetall();
		if (detall==null) {
			detall=new ArrayList<FacLinDto>();
		}
		detall.add(linea);
		// 4 inicialitzem una nova linia
		linea=initLinea();
		factura.setDetall(detall);
		factura.setLinea(linea);
		// 5 actualitzem els totals de la factura
		factura=getTotalsFactura(factura);
		return gotoEditFactura(model,factura);
		
	}

	@RequestMapping(value = "/factura/save", method = RequestMethod.POST, params={"removeRow"})
	public String removeRow (Model model,@Valid @ModelAttribute("factura") FacturaDto factura,BindingResult results) {
		factura.getDetall().add(new FacLinDto());
		return gotoEditFactura(model,factura);
		
	}
	
	@RequestMapping(value ={"/factura/{id}","/factura/new"}, method=RequestMethod.GET)
	public String edit(@PathVariable(value="id",required=false) Long facturaId,
			Model model
			){
		FacturaDto factura=null;
		if (facturaId!=null) {
		  factura = factuService.getFactura(facturaId);
		} else {
		  factura = initFactura();
		
		}
		return gotoEditFactura(model,factura);
	}
	
	private FacturaDto initFactura() {
		EjercicioDto ejercicio=factuService.getDefaultEjercicio();  
		FacturaDto factura =   new FacturaDto();
		  //TODO pasar a funcio
		  Calendar cal=Calendar.getInstance();
		  Date dat = new Date(System.currentTimeMillis());
		  cal.setTime(dat);
		  cal.add(Calendar.DATE, -2);
		  //
		  factura.setDat(cal.getTime());
		  factura.setEjercicio(ejercicio);
		  ClienteDto cliente=new ClienteDto();
		  EmpresaDto empresa=adminService.getEmpresa(1);
		  factura.setCliente(cliente);
		  factura.setEmpresa(empresa);
		  List<FacLinDto> detall = new ArrayList<FacLinDto>();
		  factura.setDetall(detall);
		  factura.setLinea(initLinea());
		  return factura;
	}
	
	private String gotoEditFactura(Model model, FacturaDto factura) {
		if (factura.getCliente()!=null && factura.getCliente().getId()!=null) {
			factura.setCliente(factuService.getCliente(factura.getCliente().getId()));
		}
		if (factura.getEmpresa()!=null && factura.getEmpresa().getId()!=null) {
			factura.setEmpresa(adminService.getEmpresa(factura.getEmpresa().getId()));
		}
		model.addAttribute("factura", factura);
		model.addAttribute("formasPago",factuService.findAllFormaspago());
		model.addAttribute("ejercicios", factuService.findAllEjercicios());
		return "factura/edit";
	}
	
	@RequestMapping(value ={"/faclin/{id}","/faclin/new"})
	public String editLin(
			Model model,
			@PathVariable(value="id",required=false) Long faclinId, FacturaDto factura){
		if (faclinId!=null) {
		  factura.setLinea(factuService.getFaclin(faclinId));
		} else {
			FacLinDto linea=initLinea();
		    factura.setLinea(linea);
		}
		return gotoEditLin(model,factura);
	}
	
	private FacturaDto getTotalsFactura(FacturaDto factura) {
		List<FacLinDto> detall =factura.getDetall();
		Function<FacLinDto, BigDecimal> totalMapper = lin -> lin.getImporte();
		BigDecimal result=detall.stream().map(totalMapper).reduce(BigDecimal.ZERO, BigDecimal::add);
		factura.setTotfac(result);
		return factura;
	}

	private FacLinDto initLinea() {
		FacLinDto linea= new FacLinDto();
		linea.setDem("Escribir texto");
		return linea;
	}

//	@RequestMapping(value = "/faclin/save", method = RequestMethod.POST)
//	public String save(
//			Model model,FacturaDto factura,
//			@Valid @ModelAttribute("faclin") FacLinDto faclin,
//			BindingResult results){
//		if (results.hasErrors()){
//			return gotoEditLin(model, factura, faclin);
//		} else {
//			Long faclinId=factuService.saveFaclin(faclin);
//			
//			return "redirect:/clientes/"+faclinId+"?msg=ok";
//		}
//	}
	
	private String gotoEditLin(Model model, FacturaDto factura) {
		model.addAttribute("factura", factura);
		return "factura/edit";
	}
}
