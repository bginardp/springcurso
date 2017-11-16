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
public class EmpresaAjaxDto extends ItemDto {
	private String dec;
	private String dem;
	private String nif;
	private String direccion;
	private String municipio;
	private String provincia;
	private String postal;
	private String tel;
	private String fax;
	private String email;
	
	
	public EmpresaAjaxDto(String label, String value, String dem, String nif,
						  String direccion, String municipio, String provincia, 
						  String postal, String tel, String fax, String email) {
		super(label,value);
		this.dec=label;
		this.dem=dem;
		this.nif=nif;
		this.direccion=direccion;
		this.municipio=municipio;
		this.provincia=provincia;
		this.postal=postal;
		this.tel=tel;
		this.fax=fax;
		this.email=email;
	}


	public String getDec() {
		return dec;
	}


	public void setDec(String dec) {
		this.dec = dec;
	}


	public String getDem() {
		return dem;
	}


	public void setDem(String dem) {
		this.dem = dem;
	}


	public String getNif() {
		return nif;
	}


	public void setNif(String nif) {
		this.nif = nif;
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


	public String getFax() {
		return fax;
	}


	public void setFax(String fax) {
		this.fax = fax;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "EmpresaAjaxDto [dec=" + dec + ", dem=" + dem + ", nif=" + nif + ", direccion=" + direccion
				+ ", municipio=" + municipio + ", provincia=" + provincia + ", postal=" + postal + ", tel=" + tel
				+ ", fax=" + fax + ", email=" + email + "]";
	}
	
	
	
}
