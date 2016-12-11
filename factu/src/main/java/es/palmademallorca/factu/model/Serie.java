package es.palmademallorca.factu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the serie database table.
 *
 */
@Entity

@Table(name="serie")

@NamedQuery(name = "Serie.findAll", query = "SELECT s FROM Serie s")
public class Serie {
	@Id
	@GeneratedValue(generator="SerieSeq")
    @SequenceGenerator(name="SerieSeq",sequenceName="factu.serie_seq", allocationSize=1)
	private String id;
	private String dec;
	private String hbl;
	@ManyToOne
	private Empresa empresa;

	public Serie() {
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

	
//	@Id
//	@GeneratedValue(generator="SerieSeq")
//    @SequenceGenerator(name="SerieSeq",sequenceName="factu.serie_seq", allocationSize=1)
//	public String getId() {
//		return this.id.get();
//	}
//
//	public void setId(String id) {
//		this.id.set(id);
//	}
//	public StringProperty idProperty() {
//		return id;
//	}
//	public String getDec() {
//		return this.dec.get();
//	}
//
//	public void setDec(String dec) {
//		this.dec.set(dec);
//	}
//	public StringProperty decProperty() {
//		return dec;
//	}
//	public String getHbl() {
//		return this.hbl.get();
//	}
//
//	public void setHbl(String hbl) {
//		this.hbl.set(hbl);
//	}
//	public StringProperty habProperty() {
//		return hbl;
//	}
//
//	// bi-directional many-to-one association to Empresa
//	@ManyToOne
//	public Empresa getEmpresa() {
//		return this.empresa;
//	}
//
//	public void setEmpresa(Empresa empresa) {
//		this.empresa = empresa;
//	}
//
//	@Override
//	public String toString() {
//		StringBuilder sb = new StringBuilder();
//		sb.append(this.getId()).append(" ").append(this.getDec());
//		return sb.toString();
//	}



}