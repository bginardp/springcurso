package es.palmademallorca.imi.proyecto2.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.BindingResult;

public class PersonDto { //jsr-303 
	
	private Long id;
	
	@NotNull
	@Length(min=3, max=50)
	private String name;
	
	@NotNull
	@Length(min=3, max=50)
	private String surname;
	
	private AddressDto address = new AddressDto();
	
	/**
	 * inclusión de posibles validaciones multi-campo
	 * @return
	 */
	public boolean valid(BindingResult result){
		// fecha1 < fecha2
		// result.reject("fecha2","motivo");
		return !result.hasErrors();
	}

	
	public PersonDto(long id, String name, String surname) {
		this.id = id;
		this.name = name;
		this.surname = surname;
	}
	
	public PersonDto() {
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	@Override
	public String toString(){
		return "id="+id+" name="+name+" surname="+surname;
	}
	
	@Override
	public boolean equals(Object obj){
		if (obj instanceof PersonDto){
			return id.equals(((PersonDto)obj).id);
		}
		return false;
	}


	public AddressDto getAddress() {
		return address;
	}


	public void setAddress(AddressDto address) {
		this.address = address;
	}
	
	
}

