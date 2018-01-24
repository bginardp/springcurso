package es.palmademallorca.factu.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.palmademallorca.factu.model.Producto;

public class ProductoDto {
	
	private String id;
	@NotNull
	@Size(min=3,max=256)
   	private String dem;
   	private BigDecimal pvp;
	private boolean hbl;
	private TipivaDto tipiva;
	private BigDecimal poriva;
	
	
	public ProductoDto() {
		this.hbl=true;
	
	}
	//TODO obtenir el % de iva
	public ProductoDto(Producto producto) {
		if (producto !=null) {
			this.id=producto.getId();
			this.dem=producto.getDem();
			this.pvp=producto.getPvp();
			this.hbl = producto.getHbl().equals("S")?true:false;
			this.tipiva=new TipivaDto(producto.getTipiva());
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

	
	
}
