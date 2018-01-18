package es.palmademallorca.factu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import es.palmademallorca.factu.dto.ClienteDto;

/**
 * JPA Class Cliente
 */
@Entity
@Table(name = "clientes")
public class Cliente  {

	@Id
	@GeneratedValue(generator="CliSeq")
    @SequenceGenerator(name="CliSeq",sequenceName="factu.clientes_seq", allocationSize=1)
	private Long id;
	private String cif;
   	private String nom;
	private String direccion;
	private String municipio;
	private String provincia;
	private String postal;
	private String tel;
	private String movil;
	private String email;
	private String ctecon;
	@Column(name = "forpag_id")
	private Long forpagId;
	@ManyToOne
	@JoinColumn(name = "forpag_id", insertable = false, updatable = false)
	private Formapago formaspago;

	

	/**
	 * Class constructor methods
	 */
	public Cliente() {
		super();
	}

	
	
	public Cliente( String cif, String nom, String direccion, String municipio, String provincia, String postal,
			String tel, String movil, String email, String ctecon, Long forpagId) {
		super();
		this.cif = cif;
		this.nom = nom;
		this.direccion = direccion;
		this.municipio = municipio;
		this.provincia = provincia;
		this.postal = postal;
		this.tel = tel;
		this.movil = movil;
		this.email = email;
		this.ctecon = ctecon;
		this.forpagId = forpagId;
		this.formaspago = formaspago;
	}



	public Cliente(ClienteDto cliente) {
		this.id=cliente.getId();
		this.cif=cliente.getCif();
		this.nom=cliente.getNom();
		this.direccion=cliente.getDireccion();
		this.municipio=cliente.getMunicipio();
		this.provincia=cliente.getProvincia();
		this.postal=cliente.getPostal();
		this.tel=cliente.getTel();
		this.movil=cliente.getMovil();
		this.email=cliente.getEmail();
		this.ctecon=cliente.getCtecon();
		this.forpagId=cliente.getForpagId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id=id;
	}

	
	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif=cif;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom=nom;
	}

	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion=direccion;
	}
	
	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio=municipio;
	}
	
	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia=provincia;
	}

	
	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal=postal;
	}
	
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel=tel;
	}
	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil=movil;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email=email;
	}

	public Long getForpagId() {
		return forpagId;
	}

	public void setForpagId(Long forpagId) {
		this.forpagId = forpagId;
	}

	public Formapago getFormaspago() {
		return formaspago;
	}

	public void setFormaspago(Formapago formaspago) {
		this.formaspago = formaspago;
	}
	
	public String getCtecon() {
		return ctecon;
	}

	public void setCtecon(String ctecon) {
		this.ctecon = ctecon;
	}


}
