package es.palmademallorca.factu.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.palmademallorca.factu.model.Producto;
import es.palmademallorca.factu.utils.Converter;

/**
 * @author BERNAT1
 *
 */
public class ProductoDto {
	
	private String id;
	@NotNull
	@Size(min=3,max=256)
   	private String dem;
   	private BigDecimal pvp;
	private boolean hbl;
	private TipivaDto tipiva;
	private BigDecimal poriva;
	private BigDecimal requiv;
	
	
	public ProductoDto() {
		this.hbl=true;
	
	}

	public ProductoDto(Producto producto) {
		if (producto !=null) {
			this.id=producto.getId();
			this.dem=producto.getDem();
			this.pvp=producto.getPvp();
			this.hbl = producto.getHbl().equals("S")?true:false;
			this.tipiva=Converter.toDto(producto.getTipiva());
			this.poriva=producto.getPoriva();
			this.requiv=producto.getRequiv();
		}
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDem() {
		return dem;
	}
	public void setDem(String dem) {
		this.dem = dem;
	}

	public boolean isHbl() {
		return hbl;
	}

	public void setHbl(boolean hbl) {
		this.hbl = hbl;
	}
	
	public BigDecimal getPvp() {
		return pvp;
	}

	public void setPvp(BigDecimal pvp) {
		this.pvp = pvp;
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
	
	public BigDecimal getRequiv() {
		return requiv;
	}
	public void setRequiv(BigDecimal requiv) {
		this.requiv = requiv;
	}
	
	@Override
	public String toString() {
		return "ProductoDto [id=" + id + ", dem=" + dem + ", pvp=" + pvp + ", hbl=" + hbl + ", tipiva=" + tipiva
				+ ", poriva=" + poriva + ", requiv=" + requiv + "]";
	}

	
	
	
}
