package es.palmademallorca.factu.dto;

import java.math.BigDecimal;

/**
 * @author BERNAT1
 *
 */
public class FacturaBasesDto {
	private Long id;
	private TipivaDto tipiva;
	private BigDecimal por;
	private BigDecimal requiv;
	private BigDecimal base;
	private BigDecimal impiva;
	private BigDecimal imprequiv;
	
	public FacturaBasesDto(TipivaDto tipiva, BigDecimal por, BigDecimal base) {
		super();
		this.tipiva = tipiva;
		//this.requiv = requiv;
		this.por = por;
		this.base = base;
		this.impiva=por.multiply(base).divide(new BigDecimal("100"));
		impiva=impiva.setScale(2,BigDecimal.ROUND_HALF_UP);
		if (requiv!=null) {
		  this.imprequiv=requiv.multiply(base).divide(new BigDecimal("100"));
		  imprequiv=imprequiv.setScale(2,BigDecimal.ROUND_HALF_UP);
		}
	}

	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public TipivaDto getTipiva() {
		return tipiva;
	}


	public void setTipiva(TipivaDto tipiva) {
		this.tipiva = tipiva;
	}


	public BigDecimal getPor() {
		return por;
	}


	public void setPor(BigDecimal por) {
		this.por = por;
	}


	public BigDecimal getRequiv() {
		return requiv;
	}


	public void setRequiv(BigDecimal requiv) {
		this.requiv = requiv;
	}


	public BigDecimal getBase() {
		return base;
	}


	public void setBase(BigDecimal base) {
		this.base = base;
	}

	public BigDecimal getImpiva() {
		return impiva;
	}


	public void setImpiva(BigDecimal impiva) {
		this.impiva = impiva;
	}


	public BigDecimal getImprequiv() {
		return imprequiv;
	}


	public void setImprequiv(BigDecimal imprequiv) {
		this.imprequiv = imprequiv;
	}


	@Override
	public String toString() {
		return "FacturaBasesDto [id=" + id + ", tipiva=" + tipiva + ", por=" + por + ", requiv=" + requiv + ", base="
				+ base + ", impiva=" + impiva + ", imprequiv=" + imprequiv + "]";
	}


	
	
	
}
