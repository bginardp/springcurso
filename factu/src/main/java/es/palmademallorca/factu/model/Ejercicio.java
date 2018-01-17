package es.palmademallorca.factu.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import es.palmademallorca.factu.dto.EjercicioDto;

/**
 * The persistent class for the ejercicio database table.
 *
 */
@Entity
public class Ejercicio  {

    @Id
	private Long id;

    public Ejercicio() {
		super();
	}

	public Ejercicio(Long id) {
    	this.id=id;
	}
    
	public Ejercicio(EjercicioDto ejercicioDto) {
		this.id=ejercicioDto.getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Ejercicio [id=" + id + "]";
	}

	



}