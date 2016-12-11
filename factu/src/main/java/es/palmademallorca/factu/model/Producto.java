package es.palmademallorca.factu.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.palmademallorca.factu.dto.ProductoDto;


/**
 * The persistent class for the productos database table.
 *
 */
@Entity
@Table(name="productos")
@NamedQueries ({
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p"),
@NamedQuery(name="Producto.findByDem", query="SELECT p FROM Producto p WHERE p.dem like :dem")
})
public class Producto {
	@Id
	private String id;
   	private String dem;
	private String hbl;


	public Producto() {
	}


	public Producto(ProductoDto productoDto) {
		this.id=productoDto.getId();
		this.dem=productoDto.getDem();
		this.hbl=productoDto.getDem();
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


	@Override
	public String toString() {
		return "Producto [id=" + id + ", dem=" + dem + ", hbl=" + hbl + "]";
	}


//	@Id
//	public String getId() {
//		return this.id.get();
//	}
//
//	public void setId(String id) {
//		this.id.set(id);
//	}
//
//	public StringProperty idProperty() {
//		return id;
//	}
//
//	public String getDem() {
//		return this.dem.get();
//	}
//
//	public void setDem(String dem) {
//		this.dem.set(dem);
//	}
//
//	public StringProperty demProperty() {
//		return dem;
//	}
//
//	public String getHbl() {
//		return this.hbl.get();
//	}
//
//	public void setHbl(String hbl) {
//		this.hbl.set(hbl);
//	}
//
//	public StringProperty hblProperty() {
//		return hbl;
//	}
//
//
//	@Override
//	public String toString() {
//		return "Producto [id=" + id + ", dem=" + dem + ", hbl=" + hbl + "]";
//	}




}