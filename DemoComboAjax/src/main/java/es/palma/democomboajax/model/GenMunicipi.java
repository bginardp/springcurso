package es.palma.democomboajax.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "gen_municipis")
public class GenMunicipi {
	@EmbeddedId
	@NotNull
	@Id
	private MunicipiId municipiId;
	@NotNull
	@Length(max = 40)
	private String nom;
	@Max(999)
	private Long dispos;

	public GenMunicipi() { }
	public GenMunicipi(MunicipiId municipiId, String nom, Long dispos) {
		super();
		this.municipiId = municipiId;
		this.nom = nom;
		this.dispos = dispos;
	}

	public MunicipiId getMunicipiId() {
		return municipiId;
	}
	public void setMunicipiId(MunicipiId municipiId) {
		this.municipiId = municipiId;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Long getDispos() {
		return dispos;
	}
	public void setDispos(Long dispos) {
		this.dispos = dispos;
	}

	public String toString() {
		return new StringBuilder().append("{ municipiId: ").append(getMunicipiId()).append(", nom: \"").append(getNom())
			.append("\", dispos: ").append(getDispos()).append(" }").toString();
	}
}