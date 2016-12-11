package es.palmademallorca.factu.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import es.palmademallorca.factu.dto.TipivaDto;


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
	private String tipo;
	private Long anyo;
	private String dem;
	private Long mes;
	private BigDecimal poriva;
	private BigDecimal requiv;
	

	public Tipiva() {
	}

	public Tipiva(TipivaDto tipivaDto) {
		this.id=tipivaDto.getId();
		this.tipo=tipivaDto.getTipo();
		this.anyo=tipivaDto.getAnyo();
		this.dem=tipivaDto.getDem();
		this.mes=tipivaDto.getMes();
		this.poriva=tipivaDto.getPoriva();
		this.requiv=tipivaDto.getRequiv();
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





}