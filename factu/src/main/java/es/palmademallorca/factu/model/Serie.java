package es.palmademallorca.factu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class Serie implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String dec;
	private String hbl;
	@Column(name = "empresa_id")
	private Long empresaId;
	@ManyToOne
	@JoinColumn(name = "empresa_id", insertable = false, updatable = false)
	private Empresa empresa;

	public Serie() {
	}

	
	
	public Serie(String id, String dec, String hbl, Long empresaId) {
		super();
		this.id = id;
		this.dec = dec;
		this.hbl = hbl;
		this.empresaId = empresaId;
	}

	public Serie(SerieDto serieDto) {
		this.id=serieDto.getId();
		this.dec=serieDto.getDec();
		this.hbl=serieDto.isHbl()?"S":"N";
		this.empresaId=serieDto.getEmpresaId();
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

	public Long getEmpresaId() {
		return empresaId;
	}

	public void setEmpresaId(Long empresaId) {
		this.empresaId = empresaId;
	}

	@Override
	public String toString() {
		return "Serie [id=" + id + ", dec=" + dec + ", hbl=" + hbl + ", empresa=" + empresa + "]";
	}




}