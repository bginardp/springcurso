package es.palmademallorca.factu.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.palmademallorca.factu.model.TipivaDet;
import es.palmademallorca.factu.utils.Converter;

public class TipivaDetDto {

	private Long id;
	private TipivaDto tipiva;
	@NotNull
	private Long anyo;	
	@NotNull
	@Min(1)
	@Max(12)
	private Long mes;
	private BigDecimal poriva;
	private BigDecimal requiv;
	

	public TipivaDetDto() {
		
	}


	public TipivaDetDto(TipivaDet dettipiva) {
		if (dettipiva!=null) {
			this.id=dettipiva.getId();
			this.tipiva=Converter.toDto(dettipiva.getTipiva());
			this.anyo=dettipiva.getAnyo();
			this.mes=dettipiva.getMes();
			this.poriva=dettipiva.getPoriva();
			this.requiv=dettipiva.getRequiv();
		}
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


	public TipivaDto getTipiva() {
		return tipiva;
	}


	public void setTipiva(TipivaDto tipiva) {
		this.tipiva = tipiva;
	}


	@Override
	public String toString() {
		return "TipivaDetDto [id=" + id + ", tipiva=" + tipiva + ", anyo=" + anyo + ", mes=" + mes + ", poriva="
				+ poriva + ", requiv=" + requiv + "]";
	}

	

}
