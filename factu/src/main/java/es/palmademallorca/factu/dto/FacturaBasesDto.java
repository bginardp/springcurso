package es.palmademallorca.factu.dto;

import java.math.BigDecimal;

import es.palmademallorca.factu.model.FacturaBases;
import es.palmademallorca.factu.utils.Converter;

/**
 * @author BERNAT1
 *
 */
public class FacturaBasesDto {
	private Long id;
	private TipivaDto tipiva;
	private BigDecimal por;
	private BigDecimal base;
	
	
	public FacturaBasesDto(Long id,TipivaDto tipiva, BigDecimal por, BigDecimal base) {
		super();
		this.id=id;
		this.tipiva = tipiva;
		this.por = por;
		this.base = base;
	}


	public FacturaBasesDto(FacturaBases dao) {
		this.id=dao.getId();
		this.tipiva=Converter.toDdto(dao.getTipiva());
		this.por=dao.getPor();
		this.base=dao.getBase();
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


	public BigDecimal getBase() {
		return base;
	}


	public void setBase(BigDecimal base) {
		this.base = base;
	}


	@Override
	public String toString() {
		return "FacImpuestoDto [tipiva=" + tipiva + ", por=" + por + ", base=" + base + "]";
	}

	
	
}
