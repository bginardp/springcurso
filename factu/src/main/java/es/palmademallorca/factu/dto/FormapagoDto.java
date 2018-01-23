package es.palmademallorca.factu.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.palmademallorca.factu.model.Formapago;

public class FormapagoDto {
	// TODO afegir validacions s anivell d'atributs
	private Long id;
	@NotNull
	@Size(min=3,max=80)
	private String dem;
	private boolean hbl;

	
	
	public FormapagoDto() {
		this.hbl=true;
	}

	public FormapagoDto(Formapago formapago) {
		this.id = formapago.getId();
		this.dem = formapago.getDem();
		this.hbl = formapago.getHbl().equals("S")?true:false;
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

	public boolean isHbl() {
		return hbl;
	}

	public void setHbl(boolean hbl) {
		this.hbl = hbl;
	}

	@Override
	public String toString() {
		return "FormapagoDto [id=" + id + ", dem=" + dem + ", hbl=" + hbl + "]";
	}

	
	
	
}
