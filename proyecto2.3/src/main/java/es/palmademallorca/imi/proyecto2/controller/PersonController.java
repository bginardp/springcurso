package es.palmademallorca.imi.proyecto2.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.palmademallorca.imi.proyecto2.dto.AddressDto;
import es.palmademallorca.imi.proyecto2.dto.PersonDto;
import es.palmademallorca.imi.proyecto2.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@PostConstruct
	public void init(){
		System.out.println("Creando Person Controller");
		System.out.println("Valor de personService "+personService);
	}
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public String list(Model model){
		List<PersonDto> personList = personService.getPeople();
		model.addAttribute("people", personList);
		return "list";
	}
	
	@RequestMapping(value = "/edit",method=RequestMethod.GET)
	public String getPerson(
			Model model,
			@RequestParam(value = "id", required=false) Long id,
			@RequestParam(value = "address", required=false) Boolean addressOk){
		PersonDto person = null;
		if (id!= null){
			person = personService.getPerson(id);
		} else {
			person = new PersonDto();
		}
		AddressDto address = person.getAddress();
		address.setPersonId(person.getId());
		model.addAttribute("person", person);
		model.addAttribute("address", address);
		if (addressOk!=null){
			model.addAttribute("mensaje", "Se ha guardado la dirección correctamente");
		}
		return "edit";
	}
	
	@RequestMapping(value="/remove",method=RequestMethod.POST)
	public String removePerson(
			@RequestParam("id") Long id){
		personService.remove(id);
		return "redirect:/person";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String savePerson(
			Model model,
			@Valid @ModelAttribute("person") PersonDto person,
			BindingResult result){
		if (person.valid(result)){
			personService.save(person);
			model.addAttribute("mensaje", "Operación correcta");
		} else {
			model.addAttribute("mensajeError", "Por favor revise los datos introducidos");
		}
		model.addAttribute("person", person);
		return "edit";
	}
	
	@RequestMapping(value="/saveAddress",method=RequestMethod.POST)
	public String saveAddress(
			Model model,
			@Valid @ModelAttribute("address") AddressDto address,
			BindingResult result){
		PersonDto person = personService.getPerson(address.getPersonId());
		if (!result.hasErrors()){
			person.setAddress(address);
			//si BD personService.save(person);
			model.addAttribute("address2", "true");
			return "redirect:/person/edit?id="+address.getPersonId()
			 		+"&address=true";
		} else {
			// si no se ha superado la validación
			model.addAttribute("person", person);
			model.addAttribute("address", address);
			model.addAttribute("mensajeError", "Por favor revise los campos de dirección");
			return "edit";
		}
		
	}
}
