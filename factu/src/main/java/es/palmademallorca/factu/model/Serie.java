package es.palmademallorca.factu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import es.palmademallorca.factu.dto.SerieDto;


/**
 * The persistent class for the serie database table.
 *
 */
@Entity

@Table(name="serie")

@NamedQuery(name = "Serie.findAll", query = "SELECT s FROM Serie s")
public class Serie {
	@Id
	private String id;
	private String dec;
	private String hbl;
	@ManyToOne
	private Empresa empresa;

	public Serie() {
	}

	public Serie(SerieDto serieDto) {
		this.id=serieDto.getId();
		this.dec=serieDto.getDec();
		this.hbl=serieDto.isHbl()?"S":"N";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDec() {
		return dec;
	}

	public void setDec(String dec) {
		this.dec = dec;
	}

	public String getHbl() {
		return hbl;
	}

	public void setHbl(String hbl) {
		this.hbl = hbl;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public String toString() {
		return "Serie [id=" + id + ", dec=" + dec + ", hbl=" + hbl + ", empresa=" + empresa + "]";
	}




}