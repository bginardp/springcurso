package es.palmademallorca.factu.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.palmademallorca.factu.model.Cliente;

public class ClienteDto {
	private Long id;
	private String cif;
	@NotNull
	@Size(min = 1, max = 80)
	private String nom;
	@Size(max = 60)
	private String direccion;
	@Size(max = 40)
	private String municipio;
	@Size(max = 40)
	private String provincia;
	@Size(max = 10)
	private String postal;
	@Size(max = 15)
	private String tel;
	@Size(max = 15)
	private String movil;
	@Size(max = 60)
	private String email;
	@Size(max = 10)
	private String ctecon;
	private Long forpagId;
	private String forpagDem;
	private String dadesCliente;

	public ClienteDto() {

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
		this.ctecon = cliente.getCtecon();
		this.forpagId = cliente.getForpagId();
		if (cliente.getFormaspago() != null) {
			this.forpagDem = cliente.getFormaspago().getDem();
		}
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

	public String getCtecon() {
		return ctecon;
	}

	public void setCtecon(String ctecon) {
		this.ctecon = ctecon;
	}

	public Long getForpagId() {
		return forpagId;
	}

	public void setForpagId(Long forpagId) {
		this.forpagId = forpagId;
	}

	public String getForpagDem() {
		return forpagDem;
	}

	public void setForpagDem(String forpagDem) {
		this.forpagDem = forpagDem;
	}

	@Override
	public String toString() {
		return "ClienteDto [id=" + id + ", cif=" + cif + ", nom=" + nom + ", direccion=" + direccion + ", municipio="
				+ municipio + ", provincia=" + provincia + ", postal=" + postal + ", tel=" + tel + ", movil=" + movil
				+ ", email=" + email + ", ctecon=" + ctecon + ", forpagId=" + forpagId + ", forpagDem=" + forpagDem
				+ ", dadesCliente=" + dadesCliente + "]";
	}

	public String getDadesCliente() {
		StringBuilder sb = new StringBuilder();
		if (nom != null) {
			sb.append("<strong>").append(nom).append("</strong><br />").append(direccion).append("<br />")
					.append(postal).append(" ").append(municipio).append("<br />").append(provincia).append("<br />");
		}
		return sb.toString();
	}

}
