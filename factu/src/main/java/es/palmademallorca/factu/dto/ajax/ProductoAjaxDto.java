package es.palmademallorca.factu.dto.ajax;

import java.math.BigDecimal;

import es.palmademallorca.factu.dto.ItemDto;
import es.palmademallorca.factu.dto.TipivaDto;

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
	private TipivaDto tipiva;
	private BigDecimal poriva;
	
	
	public ProductoAjaxDto(String label, String value, String dem, BigDecimal pvp, TipivaDto tipiva, BigDecimal poriva) {
		super(label,value);
		this.dem=dem;
		this.pvp=pvp;
		this.tipiva=tipiva;
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

	@Override
	public String toString() {
		return "ProductoAjaxDto [dem=" + dem + ", pvp=" + pvp + ", tipiva=" + tipiva + ", poriva=" + poriva + "]";
	}

	
	
}
