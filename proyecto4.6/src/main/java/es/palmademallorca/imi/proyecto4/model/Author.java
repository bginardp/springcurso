package es.palmademallorca.imi.proyecto4.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Size(min = 3, max = 25)
	private String name;
	@NotNull
	@Size(min = 5, max = 25)
	private String surname;
	@NotNull
	@Size(min = 5, max = 25)
	private String place;

		
	public Author() {
		super();
	}

	
	public Author(String name, String surname, String place) {
		super();
		this.name = name;
		this.surname = surname;
		this.place = place;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

}
