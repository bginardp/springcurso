package es.palmademalorca.imi.proyecto2;

import java.util.ArrayList;
import java.util.List;

import es.palmademallorca.imi.proyecto2.dto.PersonDto;

public class InstanciasMain {
	
	public static void main(String[] args){
		PersonDto person = new PersonDto(1l, "Ramón", "Arnau");
		
		List<PersonDto> personList = new ArrayList<>();
		personList.add(person);
				
		PersonDto newperson = new PersonDto(1l, "Ramón", "Arnau");
		personList.remove(newperson);
		
		System.out.println(personList.size());
		
	}

}
