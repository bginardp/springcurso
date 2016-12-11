package es.palmademallorca.factu.dto;

import es.palmademallorca.factu.model.Producto;

public class ProductoDto {
	// TODO afegir validacions s anivell d'atributs
	private String id;
   	private String dem;
	private String hbl;
	
	
	public ProductoDto(Producto producto) {
		this.id=producto.getId();
		this.dem=producto.getDem();
		this.hbl=producto.getDem();
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
	public String getHbl() {
		return hbl;
	}
	public void setHbl(String hbl) {
		this.hbl = hbl;
	}

	
}
