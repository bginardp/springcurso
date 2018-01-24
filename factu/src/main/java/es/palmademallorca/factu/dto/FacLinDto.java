package es.palmademallorca.factu.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.palmademallorca.factu.model.Facturalin;
import es.palmademallorca.factu.utils.Converter;

public class FacLinDto {
	// TODO afegir validacions s anivell d'atributs
	private Long id;
	private Long facturaId;
	@NotNull
	@Size(min=1,max=1000)
	private String dem;
	private BigDecimal cantidad;
	private BigDecimal preu;
	private BigDecimal importe;
	private BigDecimal pordte;
	private TipivaDto tipiva;
	private BigDecimal poriva;
	private ProductoDto producto;
	private BigDecimal requiv;
	
	
	public FacLinDto() {
	
	}


	public FacLinDto(Long id, Long facturaId, BigDecimal cantidad, String dem, BigDecimal importe, BigDecimal pordte,
			TipivaDto tipiva, BigDecimal poriva, BigDecimal preu, ProductoDto producto, BigDecimal requiv) {
		this.id = id;
		this.facturaId = facturaId;
		this.cantidad = cantidad;
		this.dem = dem;
		this.importe = importe;
		this.pordte = pordte;
		this.tipiva = tipiva;
		this.poriva = poriva;
		this.preu = preu;
		this.producto = producto;
		this.requiv = requiv;
	}
	
	
	public FacLinDto(Facturalin faclin) {
		this.id = faclin.getId();
		this.facturaId = faclin.getFactura().getId();
		this.cantidad = faclin.getCantidad();
		this.dem = faclin.getDem();
		this.importe = faclin.getImporte();
		this.pordte = faclin.getPordte();
		this.tipiva = new TipivaDto(faclin.getTipiva());
		this.poriva = faclin.getPoriva();
		this.preu = faclin.getPreu();
		this.producto = Converter.toDto(faclin.getProducto());
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
	
	public TipivaDto getTipiva() {
		return tipiva;
	}

	public void setTipiva(TipivaDto tipiva) {
		this.tipiva = tipiva;
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

	
	
	public ProductoDto getProducto() {
		return producto;
	}


	public void setProducto(ProductoDto producto) {
		this.producto = producto;
	}


	public BigDecimal getRequiv() {
		return requiv;
	}
	public void setRequiv(BigDecimal requiv) {
		this.requiv = requiv;
	}


	@Override
	public String toString() {
		return "FacLinDto [id=" + id + ", facturaId=" + facturaId + ", dem=" + dem + ", cantidad=" + cantidad
				+ ", preu=" + preu + ", importe=" + importe + ", pordte=" + pordte + ", tipiva=" + tipiva + ", poriva="
				+ poriva + ", producto=" + producto + ", requiv=" + requiv + "]";
	}

	

	
	
}
