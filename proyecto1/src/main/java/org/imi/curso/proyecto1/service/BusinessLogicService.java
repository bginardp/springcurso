package org.imi.curso.proyecto1.service;

import java.util.ArrayList;
import java.util.List;

import org.imi.curso.proyecto1.dto.PersonDto;
import org.springframework.stereotype.Service;

@Service
public class BusinessLogicService {

	
	public String hello(){
		return "hello";
	}
	
	public List<PersonDto> getPeople(){
		List<PersonDto> result = new ArrayList<>();
		result.add(new PersonDto(1l, "Ramón", "Arnau"));
		result.add(new PersonDto(2l, "José", "Arrecio"));
		return result;
	}
}
