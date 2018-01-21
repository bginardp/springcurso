package es.palmademallorca.factu.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.palmademallorca.factu.model.Tipiva;

public class TipivaDto {
	@NotNull
	@Size(min=1,max=30)
	private String id;
	@NotNull
	private String dem;
	
	public TipivaDto() {
		
	}

	public TipivaDto (String id, String dem) {
		this.id=id;
		this.dem=dem;
	}
	
	public TipivaDto(Tipiva tipiva) {
		if (tipiva !=null) {
		  this.id=tipiva.getId();
		  this.dem=tipiva.getDem();
		}
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

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	
	
}
