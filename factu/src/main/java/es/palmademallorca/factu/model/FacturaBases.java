package es.palmademallorca.factu.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import es.palmademallorca.factu.dto.FacturaBasesDto;
import es.palmademallorca.factu.utils.Converter;

@Entity
public class FacturaBases {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "tipiva_id", insertable = false, updatable = false)
	private Tipiva tipiva;
	private BigDecimal por;
	private BigDecimal requiv;
	private BigDecimal base;
	@ManyToOne
	@JoinColumn(name = "factura_id", insertable = false, updatable = false)
	private Factura factura;
	
	public FacturaBases() {
		
	}
	
	public FacturaBases(FacturaBasesDto dto) {
		this.tipiva=Converter.toDao(dto.getTipiva());
		this.por=dto.getPor();
		this.base=dto.getBase();
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "FacturaBases [id=" + id + ", tipiva=" + tipiva + ", por=" + por + ", base=" + base + ", factura="
				+ factura + "]";
	}


	
	
	
}
