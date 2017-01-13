package es.palmademallorca.imi.proyecto2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import es.palmademallorca.imi.proyecto2.dto.PersonDto;

@Service
public class PersonService {
	
	private List<PersonDto> personList = new ArrayList<>();
	
	public PersonService(){
		personList.add(new PersonDto(1, "Ramón", "Arnau"));
	}
	
	/**
	 * Devuelve la lista de personas
	 * @return List<PersonDTO> not null
	 */
	public List<PersonDto> getPeople(){
		return personList;
	}
	
	/**
	 * Dado un id devuelve la persona si existe
	 * en la lista o null si no encuentra.
	 * @param id
	 * @return
	 */
	public PersonDto getPerson(Long id){
		if (id!=null){
			for (PersonDto p : personList){
				if (id.equals(p.getId())){
					return p;
				}
			}
		}
		return null;
	}
	
	/**
	 * Sobre escribe los datos de persona si la 
	 * encuentra, o la añade a la lista si es nueva
	 * @param p
	 */
	public void save(PersonDto p){
		if (p==null){
			return;
		}
		PersonDto pDB = getPerson(p.getId());
		if (pDB == null){
			personList.add(p);
		} else {
			// pDB.setId(p.getId());
			pDB.setName(p.getName());
			pDB.setSurname(p.getSurname());
		}
	}
	 
	/**
	 * Elimina la persona de la lista si es 
	 * encontrada por ID.
	 * @param id
	 */
	public void remove(Long id){
		PersonDto pDB = getPerson(id);
		if (pDB != null){
			personList.remove(pDB);
		}
	}
}
