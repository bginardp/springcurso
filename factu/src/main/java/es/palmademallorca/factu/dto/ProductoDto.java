package es.palmademallorca.factu.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.palmademallorca.factu.model.Producto;

public class ProductoDto {
	// TODO afegir validacions s anivell d'atributs
	private String id;
	@NotNull
	@Size(min=3,max=256)
   	private String dem;
   	private BigDecimal pvp;
	private boolean hbl;
	
	
	public ProductoDto() {
		this.hbl=true;
	
	}

	public ProductoDto(Producto producto) {
		this.id=producto.getId();
		this.dem=producto.getDem();
		this.pvp=producto.getPvp();
		this.hbl = producto.getHbl().equals("S")?true:false;
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
}
