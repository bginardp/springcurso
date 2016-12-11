package es.palmademallorca.factu.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the empresas database table.
 *
 */
@Entity
@Table(name="empresas")

@NamedQueries ({
	@NamedQuery(name="Empresa.findAll", query="SELECT e FROM Empresa e"),
    @NamedQuery(name="Empresa.findByDem", query="SELECT e FROM Empresa e WHERE e.dem like :dem")
})

public class Empresa {
	@Id
	private Long id;
	private String dec;
	private String dem;
	private String direccion;
	private String fax;
	private String municipio;
	private String nif;
	private String provincia;
	private String tel;
	private String web;

	public Empresa() {
	}
	
		
	public Empresa(Long id, String dec, String dem, String direccion, String fax, String municipio, String nif,
			String provincia, String tel, String web) {
		super();
		this.id = id;
		this.dec = dec;
		this.dem = dem;
		this.direccion = direccion;
		this.fax = fax;
		this.municipio = municipio;
		this.nif = nif;
		this.provincia = provincia;
		this.tel = tel;
		this.web = web;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}





}