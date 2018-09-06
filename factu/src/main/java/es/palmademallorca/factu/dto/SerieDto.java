package es.palmademallorca.factu.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.palmademallorca.factu.model.Serie;
import es.palmademallorca.factu.utils.Converter;

public class SerieDto {
	private String id;
	@NotNull
	@Size(min=1,max=15)
	private String dec;
	private boolean hbl;
	private EmpresaDto empresa;
	
	public SerieDto() {
		this.hbl=true;
	}

	
	public SerieDto(Serie serie) {
		if (serie!=null) {
			this.id=serie.getId();
			this.dec=serie.getDec();
			this.empresa=Converter.toDto(serie.getEmpresa());
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


	public EmpresaDto getEmpresa() {
		return empresa;
	}


	public void setEmpresa(EmpresaDto empresa) {
		this.empresa = empresa;
	}


	@Override
	public String toString() {
		return "SerieDto [id=" + id + ", dec=" + dec + ", hbl=" + hbl + ", empresa=" + empresa + "]";
	}

		

	
}
