package es.palmademallorca.factu.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	@ManyToOne()
	@JoinColumn(name = "tipiva_id")
	private Tipiva tipiva;
	@Transient 
	private BigDecimal poriva;
	@Transient 
	private BigDecimal requiv;

	public Producto() {
	}

	

	public Producto(String id, String dem, BigDecimal pvp, String hbl, Tipiva tipiva) {
		super();
		this.id = id;
		this.dem = dem;
		this.pvp = pvp;
		this.hbl = hbl;
		this.tipiva = tipiva;
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
	



}