package es.palmademallorca.factu.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.palmademallorca.factu.model.TipivaDet;

public class TipivaDetDto {

	private Long id;
	@NotNull
	@Size(min=1,max=30)
	private String tipivaId;
	@NotNull
	private Long anyo;
	private String tipivaDem;
	@NotNull
	@Min(1)
	@Max(12)
	private Long mes;
	private BigDecimal poriva;
	private BigDecimal requiv;
	

	public TipivaDetDto() {
		
	}


	public TipivaDetDto(TipivaDet tipiva) {
		this.id=tipiva.getId();
		this.tipivaId=tipiva.getTipiva().getId();
		this.anyo=tipiva.getAnyo();
		this.tipivaDem=tipiva.getTipiva().getDem();
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


	public Long getAnyo() {
		return anyo;
	}


	public void setAnyo(Long anyo) {
		this.anyo = anyo;
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


	public String getTipivaId() {
		return tipivaId;
	}


	public void setTipivaId(String tipivaId) {
		this.tipivaId = tipivaId;
	}


	public String getTipivaDem() {
		return tipivaDem;
	}


	public void setTipivaDem(String tipivaDem) {
		this.tipivaDem = tipivaDem;
	}

}
