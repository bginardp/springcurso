package es.palmademallorca.factu.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.palmademallorca.factu.model.Serie;

public class SerieDto {
	// TODO afegir validacions s anivell d'atributs
	private String id;
	@NotNull
	@Size(min=1,max=15)
	private String dec;
	private boolean hbl;
	
	public SerieDto() {
		this.hbl=true;
	}

	public SerieDto(Serie serie) {
		this.id=serie.getId();
		this.dec=serie.getDec();
		this.hbl = serie.getHbl().equals("S")?true:false;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDec() {
		return dec;
	}

	public void setDec(String dec) {
		this.dec = dec;
	}

	public boolean isHbl() {
		return hbl;
	}

	public void setHbl(boolean hbl) {
		this.hbl = hbl;
	}


	
}
