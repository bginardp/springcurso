package es.palmademallorca.factu.dto;

import java.math.BigDecimal;

import javax.persistence.Column;

import es.palmademallorca.factu.model.Facturalin;

public class FacLinDto {
	// TODO afegir validacions s anivell d'atributs
	private Long id;
	private Long facturaId;
	private BigDecimal cantidad;
	private String dem;
	private BigDecimal importe;
	private BigDecimal pordte;
	private Long tipivaId;
	private String tipivaDec;
	private BigDecimal poriva;
	private BigDecimal preu;
	private String producteId;
	private BigDecimal requiv;
	
	
	public FacLinDto() {
	
	}


	public FacLinDto(Long id, Long facturaId, BigDecimal cantidad, String dem, BigDecimal importe, BigDecimal pordte,
			Long tipivaId, String tipivaDec, BigDecimal poriva, BigDecimal preu, String producteId, BigDecimal requiv) {
		this.id = id;
		this.facturaId = facturaId;
		this.cantidad = cantidad;
		this.dem = dem;
		this.importe = importe;
		this.pordte = pordte;
		this.tipivaId = tipivaId;
		this.tipivaDec = tipivaDec;
		this.poriva = poriva;
		this.preu = preu;
		this.producteId = producteId;
		this.requiv = requiv;
	}
	
	
	public FacLinDto(Facturalin faclin) {
		this.id = faclin.getId();
		this.facturaId = faclin.getFacturaId();
		this.cantidad = faclin.getCantidad();
		this.dem = faclin.getDem();
		this.importe = faclin.getImporte();
		this.pordte = faclin.getPordte();
		this.tipivaId = faclin.getTipivaId();
//		this.tipivaDec = faclin.getTipivaDec();
		this.poriva = faclin.getPoriva();
		this.preu = faclin.getPreu();
		this.producteId = faclin.getProducteId();
		this.requiv = faclin.getRequiv();
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getFacturaId() {
		return facturaId;
	}
	public void setFacturaId(Long facturaId) {
		this.facturaId = facturaId;
	}
	public BigDecimal getCantidad() {
		return cantidad;
	}
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}
	public String getDem() {
		return dem;
	}
	public void setDem(String dem) {
		this.dem = dem;
	}
	public BigDecimal getImporte() {
		return importe;
	}
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	public BigDecimal getPordte() {
		return pordte;
	}
	public void setPordte(BigDecimal pordte) {
		this.pordte = pordte;
	}
	public Long getTipivaId() {
		return tipivaId;
	}
	public void setTipivaId(Long tipivaId) {
		this.tipivaId = tipivaId;
	}
	public String getTipivaDec() {
		return tipivaDec;
	}
	public void setTipivaDec(String tipivaDec) {
		this.tipivaDec = tipivaDec;
	}
	public BigDecimal getPoriva() {
		return poriva;
	}
	public void setPoriva(BigDecimal poriva) {
		this.poriva = poriva;
	}
	public BigDecimal getPreu() {
		return preu;
	}
	public void setPreu(BigDecimal preu) {
		this.preu = preu;
	}
	public String getProducteId() {
		return producteId;
	}
	public void setProducteId(String producteId) {
		this.producteId = producteId;
	}
	public BigDecimal getRequiv() {
		return requiv;
	}
	public void setRequiv(BigDecimal requiv) {
		this.requiv = requiv;
	}

}
