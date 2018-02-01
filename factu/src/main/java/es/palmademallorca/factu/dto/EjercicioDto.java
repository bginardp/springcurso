package es.palmademallorca.factu.dto;

import es.palmademallorca.factu.model.Ejercicio;

public class EjercicioDto {
	private Long id;

	public EjercicioDto() {
		
	}
	
	public EjercicioDto(Long id) {
		this.id=id;
	}
	public EjercicioDto(Ejercicio ejercicio) {
		if (ejercicio!=null) {
	     	this.id=ejercicio.getId();
		}
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "EjercicioDto [id=" + id + "]";
	}
	
	

}
