package es.palmademallorca.factu.dto.ajax;

import java.math.BigDecimal;

import es.palmademallorca.factu.dto.ItemDto;

/**
 * Classe que ens ajuda a fer servir la funcionalitat de autocomplete de jquery
 * necessariament ha de tener aquest dos atributs amb aquests noms. 
 * (label i value). Per aixó aquest dos atributs els heretem de ItemDto
 * Afegim atributs a la classe filla segons les necessitats. 
 *  
 * @author BERNAT1
 *
 */
public class ProductoAjaxDto extends ItemDto {
	private String dem;
   	private BigDecimal pvp;
	private String tipivaId;
	private String tipivaDem;
	private BigDecimal poriva;
	
	
	public ProductoAjaxDto(String label, String value, String dem, BigDecimal pvp, String tipivaId, String tipivaDem, BigDecimal poriva) {
		super(label,value);
		this.dem=dem;
		this.pvp=pvp;
		this.tipivaId=tipivaId;
		this.tipivaDem=tipivaDem;
		this.setPoriva(poriva);
		
	}

	public String getDem() {
		return dem;
	}


	public void setDem(String dem) {
		this.dem = dem;
	}


	public BigDecimal getPvp() {
		return pvp;
	}


	public void setPvp(BigDecimal pvp) {
		this.pvp = pvp;
	}


	public String getTipivaId() {
		return tipivaId;
	}


	public void setTipivaId(String tipivaId) {
		this.tipivaId = tipivaId;
	}


	public String getTipivaDem() {
		return tipivaDem;
	}


	public void setTipivaDem(String tipivaDem) {
		this.tipivaDem = tipivaDem;
	}

	public BigDecimal getPoriva() {
		return poriva;
	}

	public void setPoriva(BigDecimal poriva) {
		this.poriva = poriva;
	}

	
	
}
