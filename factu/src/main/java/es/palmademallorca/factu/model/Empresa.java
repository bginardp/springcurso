package es.palmademallorca.factu.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import es.palmademallorca.factu.dto.EmpresaDto;


/**
 * The persistent class for the empresas database table.
 *
 */
@Entity
@Table(name="empresas")
public class Empresa {
	@Id
	private Long id;
	private String nif;
	private String dec;
	private String dem;
	private String direccion;
	private String municipio;
	private String provincia;
	private String postal;
	private String tel;
	private String fax;
	private String email;

	public Empresa() {
	}
	
		
	public Empresa(Long id, String dec, String dem, String direccion, String fax, String municipio, String nif,
			String provincia, String tel, String email, String postal) {
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
		this.email = email;
		this.postal=postal;
	}



	public Empresa(EmpresaDto empresaDto) {
		this.id=empresaDto.getId();
		this.dec=empresaDto.getDec();
		this.dem=empresaDto.getDem();
		this.direccion=empresaDto.getDireccion();
		this.fax=empresaDto.getFax();
		this.municipio=empresaDto.getMunicipio();
		this.nif=empresaDto.getNif();
		this.provincia=empresaDto.getProvincia();
		this.postal=empresaDto.getPostal();
		this.tel=empresaDto.getTel();
		this.email=empresaDto.getEmail();
		
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getPostal() {
		return postal;
	}


	public void setPostal(String postal) {
		this.postal = postal;
	}





}