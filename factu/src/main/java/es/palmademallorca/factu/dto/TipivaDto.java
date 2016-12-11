package es.palmademallorca.factu.dto;

import java.math.BigDecimal;

import es.palmademallorca.factu.model.Tipiva;

public class TipivaDto {
	// TODO afegir validacions s anivell d'atributs
	private Long id;
	private String tipo;
	private Long anyo;
	private String dem;
	private Long mes;
	private BigDecimal poriva;
	private BigDecimal requiv;
	

	public TipivaDto(Tipiva tipiva) {
		this.id=tipiva.getId();
		this.tipo=tipiva.getTipo();
		this.anyo=tipiva.getAnyo();
		this.dem=tipiva.getDem();
		this.mes=tipiva.getMes();
		this.poriva=tipiva.getPoriva();
		this.requiv=tipiva.getRequiv();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public Long getAnyo() {
		return anyo;
	}


	public void setAnyo(Long anyo) {
		this.anyo = anyo;
	}


	public String getDem() {
		return dem;
	}


	public void setDem(String dem) {
		this.dem = dem;
	}


	public Long getMes() {
		return mes;
	}


	public void setMes(Long mes) {
		this.mes = mes;
	}


	public BigDecimal getPoriva() {
		return poriva;
	}


	public void setPoriva(BigDecimal poriva) {
		this.poriva = poriva;
	}


	public BigDecimal getRequiv() {
		return requiv;
	}


	public void setRequiv(BigDecimal requiv) {
		this.requiv = requiv;
	}

}
