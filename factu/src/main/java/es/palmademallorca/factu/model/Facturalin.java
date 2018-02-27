package es.palmademallorca.factu.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import es.palmademallorca.factu.dto.FacLinDto;


/**
 * The persistent class for the factureslin database table.
 *
 */
@Entity
public class Facturalin {
	@Id
	@GeneratedValue(generator = "FacturaLinSeq")
	@SequenceGenerator(name = "FacturaLinSeq", sequenceName = "factu.facturalin_seq", allocationSize = 1)
	private Long id;
	private BigDecimal cantidad;
	private String dem;
	@Column(name="import")
	private BigDecimal importe;
	private BigDecimal pordte;
	private BigDecimal poriva;
	private BigDecimal preu;
	private BigDecimal requiv;
	@Column(name="producte_id")
	private String productoId;
	@Column(name="tipiva_id")
	private String tipivaId;
	@ManyToOne
	@JoinColumn(name = "producte_id", insertable = false, updatable = false)
	private Producto producto;
	@ManyToOne
	@JoinColumn(name = "tipiva_id", insertable = false, updatable = false)
	private Tipiva tipiva;
	
	@ManyToOne
	@JoinColumn(name = "factura_id", nullable = false)
	private Factura factura;

	
	public Facturalin() {
	}

	public Facturalin(FacLinDto faclinDto) {
		this.id=faclinDto.getId();
		this.cantidad=faclinDto.getCantidad();
		this.dem=faclinDto.getDem();
		this.importe=faclinDto.getImporte();
		this.pordte=faclinDto.getPordte();
		this.poriva=faclinDto.getPoriva();
		this.preu=faclinDto.getPreu();
		this.requiv=faclinDto.getRequiv();
		this.productoId=faclinDto.getProducto().getId();
		this.tipivaId=faclinDto.getTipiva().getId();
				
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

	public BigDecimal getRequiv() {
		return requiv;
	}

	public void setRequiv(BigDecimal requiv) {
		this.requiv = requiv;
	}

	public String getProductoId() {
		return productoId;
	}

	public void setProductoId(String productoId) {
		this.productoId = productoId;
	}

	public String getTipivaId() {
		return tipivaId;
	}

	public void setTipivaId(String tipivaId) {
		this.tipivaId = tipivaId;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	
	
	public Tipiva getTipiva() {
		return tipiva;
	}

	public void setTipiva(Tipiva tipiva) {
		this.tipiva = tipiva;
	}

	
	
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "Facturalin [id=" + id + ", cantidad=" + cantidad + ", dem=" + dem + ", importe=" + importe + ", pordte="
				+ pordte + ", poriva=" + poriva + ", preu=" + preu + ", requiv=" + requiv + ", productoId=" + productoId
				+ ", tipivaId=" + tipivaId + ", factura=" + factura + "]";
	}

	


	


}