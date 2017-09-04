package es.palmademallorca.factu.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import es.palmademallorca.factu.dto.TipivaDto;

/**
 * The persistent class for the tipiva database table.
 *
 */
@Entity
@Table(name = "tipiva")

public class Tipiva {
	@Id
	private String id;
	private String dem;

	public Tipiva() {
	}

	public Tipiva(TipivaDto tipivaDto) {

		this.id = tipivaDto.getId();
		this.dem = tipivaDto.getDem();
	}

	public Tipiva(String id, String dem) {
		this.id = id;
		this.dem = dem;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDem() {
		return dem;
	}

	public void setDem(String dem) {
		this.dem = dem;
	}

}