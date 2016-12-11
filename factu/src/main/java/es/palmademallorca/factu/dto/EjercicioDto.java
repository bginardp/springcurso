package es.palmademallorca.factu.dto;

import es.palmademallorca.factu.model.Ejercicio;

public class EjercicioDto {
	// TODO afegir validaciones
	private Long id;

	public EjercicioDto(Ejercicio ejercicio) {
		this.id=ejercicio.getId();
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
