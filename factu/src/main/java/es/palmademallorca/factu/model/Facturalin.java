package es.palmademallorca.factu.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import es.palmademallorca.factu.dto.FacLinDto;


/**
 * The persistent class for the factureslin database table.
 *
 */
@Entity
public class Facturalin {
	@Id
	private Long id;
	private BigDecimal cantidad;
	private String dem;
	@Column(name="import")
	private BigDecimal importe;
	private BigDecimal pordte;
	private BigDecimal poriva;
	private BigDecimal preu;
	@Column(name="producte_id")
	private String producteId;
	private BigDecimal requiv;
	@Column(name="tipiva_id")
	private Long tipivaId;
	@Column(name="factura_id")
	private Long facturaId;
	
//	@ManyToOne
//	private Factura factura;

	public Facturalin() {
	}

	public Facturalin(FacLinDto faclinDto) {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getTipivaId() {
		return tipivaId;
	}

	public void setTipivaId(Long tipivaId) {
		this.tipivaId = tipivaId;
	}

	public Long getFacturaId() {
		return facturaId;
	}

	public void setFacturaId(Long facturaId) {
		this.facturaId = facturaId;
	}

//	public Factura getFactura() {
//		return factura;
//	}
//
//	public void setFactura(Factura factura) {
//		this.factura = factura;
//	}





	


}