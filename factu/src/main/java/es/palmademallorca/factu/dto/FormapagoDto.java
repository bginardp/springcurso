package es.palmademallorca.factu.dto;

import es.palmademallorca.factu.model.Formapago;

public class FormapagoDto {
	// TODO afegir validacions s anivell d'atributs
	private Long id;
	private String dem;
	private String hbl;

	public FormapagoDto(Formapago formapago) {
		this.id = formapago.getId();
		this.dem = formapago.getDem();
		this.hbl = formapago.getHbl();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDem() {
		return dem;
	}

	public void setDem(String dem) {
		this.dem = dem;
	}

	public String getHbl() {
		return hbl;
	}

	public void setHbl(String hbl) {
		this.hbl = hbl;
	}
	
	
}
