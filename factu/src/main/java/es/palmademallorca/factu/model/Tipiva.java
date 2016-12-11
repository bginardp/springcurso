package es.palmademallorca.factu.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the tipiva database table.
 *
 */
@Entity
@Table(name="tipiva")

@NamedQuery(name="Tipiva.findAll", query="SELECT t FROM Tipiva t")
public class Tipiva {
	@Id
	@GeneratedValue(generator="TipivaSeq")
    @SequenceGenerator(name="TipivaSeq",sequenceName="factu.tipiva_seq", allocationSize=1)	
	private Long id;
	private Long anyo;
	private String dem;
	private Long mes;
	private BigDecimal poriva;
	private BigDecimal requiv;
	private String tipo;

	public Tipiva() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAnyo() {
		return anyo;
	}

	public void setAnyo(Long anyo) {
		this.anyo = anyo;
	}

	public String getDem() {
		return dem;
	}

	public void setDem(String dem) {
		this.dem = dem;
	}

	public Long getMes() {
		return mes;
	}

	public void setMes(Long mes) {
		this.mes = mes;
	}

	public BigDecimal getPoriva() {
		return poriva;
	}

	public void setPoriva(BigDecimal poriva) {
		this.poriva = poriva;
	}

	public BigDecimal getRequiv() {
		return requiv;
	}

	public void setRequiv(BigDecimal requiv) {
		this.requiv = requiv;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Tipiva [id=" + id + ", anyo=" + anyo + ", dem=" + dem + ", mes=" + mes + ", poriva=" + poriva
				+ ", requiv=" + requiv + ", tipo=" + tipo + "]";
	}


//	@Id
//	@GeneratedValue(generator="TipivaSeq")
//    @SequenceGenerator(name="TipivaSeq",sequenceName="factu.tipiva_seq", allocationSize=1)
//	public Long getId() {
//		return this.id.get();
//	}
//
//	public void setId(Long id) {
//		this.id.set(id);
//	}
//
//
//	public Long getAnyo() {
//		return this.anyo.get();
//	}
//
//	public void setAnyo(Long anyo) {
//		this.anyo.set(anyo);
//	}
//
//
//	public String getDem() {
//		return this.dem.get();
//	}
//
//	public void setDem(String dem) {
//		this.dem.set(dem);
//	}
//
//
//	public Long getMes() {
//		return this.mes.get();
//	}
//
//	public void setMes(Long mes) {
//		this.mes.set(mes);
//	}
//
//
//	public BigDecimal getPoriva() {
//		return this.poriva.get();
//	}
//
//	public void setPoriva(BigDecimal poriva) {
//		this.poriva.set(poriva);
//	}
//
//
//	public BigDecimal getRequiv() {
//		return this.requiv.get();
//	}
//
//	public void setRequiv(BigDecimal requiv) {
//		this.requiv.set(requiv);
//	}
//
//
//	public String getTipo() {
//		return this.tipo.get();
//	}
//
//	public void setTipo(String tipo) {
//		this.tipo.set(tipo);
//	}
//
//
//	@Override
//	public String toString() {
//		StringBuilder sb = new StringBuilder();
//		sb.append(this.getId()).append(" ").append(this.getDem()).append(" ").append(this.getPoriva()).append(" ").append(this.getRequiv());
//		return sb.toString();
//	}




}