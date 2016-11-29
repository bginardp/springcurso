package es.palmademallorca.imi.proyecto2.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class AddressDto { //jsr-303 
	
	@NotNull
	private Long personId;
	
	@NotNull
	@Length(min=5, max=150)
	private String street;
	
	@NotNull
	@Min(1)
	private Long number;
	
	@NotNull
	@Length(min=5, max=50)
	private String locality;

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}
	
	
}
