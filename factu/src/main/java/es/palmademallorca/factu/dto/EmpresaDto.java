package es.palmademallorca.factu.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.palmademallorca.factu.model.Empresa;

public class EmpresaDto {
	
	// TODO afegir validacions s anivell d'atributs
	
	private Long id;
	@NotNull
	@Size(min=5,max=30)
	private String dec;
	private String dem;
	private String nif;
	@NotNull
	@Size(min=5,max=80)
	private String direccion;
	@NotNull
	@Size(max=80)
	private String municipio;
	private String provincia;
	private String postal;
	private String tel;
	private String fax;
	private String email;

	public EmpresaDto() {
	
	}

	public EmpresaDto(Empresa empresa) {
		this.id=empresa.getId();
		this.dec=empresa.getDec();
		this.dem=empresa.getDem();
		this.direccion=empresa.getDireccion();
		this.fax=empresa.getFax();
		this.municipio=empresa.getMunicipio();
		this.nif=empresa.getNif();
		this.provincia=empresa.getProvincia();
		this.tel=empresa.getTel();
		this.email=empresa.getEmail();
		this.postal=empresa.getPostal();
	}

	
	
	public EmpresaDto(Long id, String dec, String dem, String direccion, String fax, String municipio, String nif,
			String provincia, String postal, String tel, String email) {
		super();
		this.id = id;
		this.dec = dec;
		this.dem = dem;
		this.direccion = direccion;
		this.fax = fax;
		this.municipio = municipio;
		this.nif = nif;
		this.provincia = provincia;
		this.postal = postal;
		this.tel = tel;
		this.email = email;
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
