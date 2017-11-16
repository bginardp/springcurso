package es.palmademallorca.factu.dto;

public class EntradaDto {

	private Long ejercicioId;
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
