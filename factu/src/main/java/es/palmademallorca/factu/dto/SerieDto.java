package es.palmademallorca.factu.dto;

import es.palmademallorca.factu.model.Serie;

public class SerieDto {
	// TODO afegir validacions s anivell d'atributs
	private String id;
	private String dec;
	private String hbl;
	
	public SerieDto(Serie serie) {
		this.id=serie.getId();
		this.dec=serie.getDec();
		this.hbl=serie.getHbl();
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

	public String getHbl() {
		return hbl;
	}

	public void setHbl(String hbl) {
		this.hbl = hbl;
	}
	
	
}
