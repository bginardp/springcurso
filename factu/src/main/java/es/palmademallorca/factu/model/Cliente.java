package es.palmademallorca.factu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import es.palmademallorca.factu.dto.ClienteDto;

/**
 * JPA Class Cliente
 */
@Entity
@Table(name = "clientes")
@NamedQueries ({
	@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c"),
    @NamedQuery(name="Cliente.findByNom", query="SELECT c FROM Cliente c WHERE c.nom like :nom")
})
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

	/**
	 * Class constructor methods
	 */
	public Cliente() {
		super();
	}

	public Cliente(ClienteDto cliente) {
		this.cif=cliente.getCif();
		this.nom=cliente.getNom();
		this.direccion=cliente.getDireccion();
		this.municipio=cliente.getMunicipio();
		this.provincia=cliente.getProvincia();
		this.postal=cliente.getPostal();
		this.tel=cliente.getTel();
		this.movil=cliente.getMovil();
		this.email=cliente.getEmail();
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
	
	
	

}
