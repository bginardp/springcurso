package es.palmademallorca.factu.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.palmademallorca.factu.model.Cliente;

public class ClienteDto {
	private Long id;
	private String cif;
	@NotNull
	@Size(min=1,max=80)
	private String nom;
	private String direccion;
	private String municipio;
	private String provincia;
	private String postal;
	private String tel;
	private String movil;
	private String email;
	

	public ClienteDto(){
		
	}
	
	public ClienteDto(Cliente cliente) {
		this.id = cliente.getId();
		this.cif = cliente.getCif();
		this.nom = cliente.getNom();
		this.direccion = cliente.getDireccion();
		this.municipio = cliente.getMunicipio();
		this.provincia = cliente.getProvincia();
		this.postal = cliente.getPostal();
		this.tel = cliente.getTel();
		this.movil = cliente.getMovil();
		this.email = cliente.getEmail();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
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
	
	
	
	
}
