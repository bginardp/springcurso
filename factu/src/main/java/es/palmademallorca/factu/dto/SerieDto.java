package es.palmademallorca.factu.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.palmademallorca.factu.model.Serie;

public class SerieDto {
	// TODO afegir validacions s anivell d'atributs
	private String id;
	@NotNull
	@Size(min=1,max=15)
	private String dec;
	private boolean hbl;
	private Long empresaId;
	private String empresaName;
	public SerieDto() {
		this.hbl=true;
	}

	public SerieDto(Long empresaId, String empresaName) {
		this.hbl=true;
		this.empresaId=empresaId;
		this.empresaName=empresaName;
	}
	public SerieDto(Serie serie) {
		if (serie!=null) {
			this.id=serie.getId();
			this.dec=serie.getDec();
			this.empresaId=serie.getEmpresaId();
			this.empresaName=serie.getEmpresa().getDem();
			this.hbl = serie.getHbl().equals("S")?true:false;
		}
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

	public boolean isHbl() {
		return hbl;
	}

	public void setHbl(boolean hbl) {
		this.hbl = hbl;
	}

	public Long getEmpresaId() {
		return empresaId;
	}

	public void setEmpresaId(Long empresaId) {
		this.empresaId = empresaId;
	}

	public String getEmpresaName() {
		return empresaName;
	}

	public void setEmpresaName(String empresaName) {
		this.empresaName = empresaName;
	}

	@Override
	public String toString() {
		return "SerieDto [id=" + id + ", dec=" + dec + ", hbl=" + hbl + ", empresaId=" + empresaId + ", empresaName="
				+ empresaName + "]";
	}

	

	
}
