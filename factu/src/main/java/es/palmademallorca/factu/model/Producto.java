package es.palmademallorca.factu.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.palmademallorca.factu.dto.ProductoDto;


/**
 * The persistent class for the productos database table.
 *
 */
@Entity
@Table(name="productos")
public class Producto {
	@Id
	private String id;
   	private String dem;
   	private BigDecimal pvp;
	private String hbl;
	@ManyToOne
	@JoinColumn(name = "tipiva_id", insertable = false, updatable = false)
	private Tipiva tipiva;

	public Producto() {
	}


	public Producto(ProductoDto productoDto) {
		this.id=productoDto.getId();
		this.dem=productoDto.getDem();
		this.pvp=productoDto.getPvp();
		this.hbl=productoDto.isHbl()?"S":"N";
		this.tipiva=new Tipiva(productoDto.getId(),productoDto.getDem());
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


	public BigDecimal getPvp() {
		return pvp;
	}


	public void setPvp(BigDecimal pvp) {
		this.pvp = pvp;
	}


	public Tipiva getTipiva() {
		return tipiva;
	}


	public void setTipiva(Tipiva tipiva) {
		this.tipiva = tipiva;
	}


}