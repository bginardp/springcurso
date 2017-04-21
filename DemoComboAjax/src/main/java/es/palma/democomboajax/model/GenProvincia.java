package es.palma.democomboajax.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="gen_provincies")
public class GenProvincia {
	@Id
	@NotNull
	@Max(99)
	private Long con;
	@NotNull
	@Length(max = 240)
	private String nom;
	
	public GenProvincia() { }
	public GenProvincia(Long con, String nom) {
		super();
		this.con = con;
		this.nom = nom;
	}
	
	public Long getCon() {
		return con;
	}
	public void setCon(Long con) {
		this.con = con;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((con == null) ? 0 : con.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GenProvincia other = (GenProvincia) obj;
		if (con == null) {
			if (other.con != null)
				return false;
		} else if (!con.equals(other.con))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
	
	public String toString() {
		return new StringBuilder().append("{ con: ").append(getCon()).append(", nom: \"").append(getNom())
			.append("\" }").toString();
	}
}

//CON     NUMBER(2)                             NOT NULL,
//NOM     VARCHAR2(240 BYTE)                    NOT NULL,
