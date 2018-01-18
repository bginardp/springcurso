package es.palmademallorca.factu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import es.palmademallorca.factu.dto.FormapagoDto;


/**
 * The persistent class for the formaspago database table.
 *
 */
@Entity
public class Formapago {
	@Id
	@GeneratedValue(generator="ForPagSeq")
    @SequenceGenerator(name="ForPagSeq",sequenceName="forpag_seq", allocationSize=1)
	private Long id;
	private String dem;
	private String hbl;

	public Formapago() {
	}
	
	

	public Formapago(String dem, String hbl) {
		super();
		this.dem = dem;
		this.hbl = hbl;
	}



	public Formapago(FormapagoDto formapagoDto) {
		this.id = formapagoDto.getId();
		this.dem = formapagoDto.getDem();
		this.hbl = formapagoDto.isHbl()?"S":"N";;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDem() {
		return dem;
	}

	public void setDem(String dem) {
		this.dem = dem;
	}

	public String getHbl() {
		return hbl;
	}

	public void setHbl(String hbl) {
		this.hbl = hbl;
	}



}