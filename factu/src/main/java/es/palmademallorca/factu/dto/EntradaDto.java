package es.palmademallorca.factu.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EntradaDto {
//	@NotNull
//	@Size(min=1,max=2099)
	private Long ejercicioId;
//	@NotNull
//	@Size(min=1, max=10)
	private Long empresaId;
	private String empresaName;

	public EntradaDto() {
		
	}

	public EntradaDto(Long ejercicio, Long empresaId, String empresaName ) {
		super();
		this.ejercicioId = ejercicio;
		this.empresaId = empresaId;
		this.empresaName = empresaName;
	}

	public Long getEjercicioId() {
		return ejercicioId;
	}

	public void setEjercicioId(Long ejercicioId) {
		this.ejercicioId = ejercicioId;
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
	
	
	
	
}
