package es.palmademallorca.factu.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import es.palmademallorca.factu.dto.TipivaDetDto;
import es.palmademallorca.factu.utils.Converter;


/**
 * The persistent class for the tipiva database table.
 *
 */
@Entity
@Table(name="tipivadet")

public class TipivaDet {
	@Id
	@GeneratedValue(generator="TipivaSeq")
    @SequenceGenerator(name="TipivaSeq",sequenceName="factu.tipiva_seq", allocationSize=1)	
	private Long id;
	private Long anyo;
	private Long mes;
	private BigDecimal poriva;
	private BigDecimal requiv;
	@ManyToOne
	@JoinColumn(name = "tipiva_id")
	private Tipiva tipiva;
	

	public TipivaDet() {
	}
	
	

	public TipivaDet(Tipiva tipiva, Long anyo, Long mes, BigDecimal poriva, BigDecimal requiv) {
		super();
		this.tipiva = tipiva;
		this.anyo = anyo;
		this.mes = mes;
		this.poriva = poriva;
		this.requiv = requiv;
	}



	public TipivaDet(TipivaDetDto tipivadetDto) {
		this.id=tipivadetDto.getId();
		this.anyo=tipivadetDto.getAnyo();
		this.mes=tipivadetDto.getMes();
		this.poriva=tipivadetDto.getPoriva();
		this.requiv=tipivadetDto.getRequiv();
		this.tipiva=Converter.toDao(tipivadetDto.getTipiva()); 
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

	public Tipiva getTipiva() {
		return tipiva;
	}

	public void setTipiva(Tipiva tipiva) {
		this.tipiva = tipiva;
	}

	


}