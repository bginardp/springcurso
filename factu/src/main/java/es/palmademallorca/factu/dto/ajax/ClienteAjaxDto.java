package es.palmademallorca.factu.dto.ajax;

import es.palmademallorca.factu.dto.ItemDto;

/**
 * classe que ens ajuda a fer servir la funcionalitat de autocomplete de jquery
 * necessariament ha de tener aquest dos atributs amb aquests noms. 
 * (label i value). Per aixó aquest dos atributs els heretem de ItemDto
 * Afegim atributs a la classe filla segons les necessitats. 
 *  
 * @author BERNAT1
 *
 */
/**
 * @author BERNAT1
 *
 */
public class ClienteAjaxDto extends ItemDto {
	private String cif;
	private String direccion;
	private String municipio;
	private String provincia;
	private String postal;
	private String tel;
	private String movil;
	private String email;
	
	
	public ClienteAjaxDto(String label, String value, String cif, String direccion,
			              String municipio, String provincia, String postal, 
			              String tel, String movil, String email) {
		super(label,value);
		this.cif=cif;
		this.direccion=direccion;
		this.municipio=municipio;
		this.provincia=provincia;
		this.postal=postal;
		this.tel=tel;
		this.movil=movil;
		this.email=email;
	}
	
	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ClienteAjaxDto [cif=" + cif + ", direccion=" + direccion + ", municipio=" + municipio + ", provincia="
				+ provincia + ", postal=" + postal + ", tel=" + tel + ", movil=" + movil + ", email=" + email
				+ ", getLabel()=" + getLabel() + ", getValue()=" + getValue() + "]";
	}

	

	
}
