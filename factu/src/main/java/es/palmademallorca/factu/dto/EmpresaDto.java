package es.palmademallorca.factu.dto;

import es.palmademallorca.factu.model.Empresa;

public class EmpresaDto {
	
	// TODO afegir validacions s anivell d'atributs
	
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
		this.web=empresa.getWeb();
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
