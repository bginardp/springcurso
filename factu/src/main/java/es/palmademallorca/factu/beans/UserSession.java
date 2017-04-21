package es.palmademallorca.factu.beans;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
//@Scope(value="session")
// @Scope("singleton")
public class UserSession {
	private String usuari;
	private Long empresaId;
	private String empresaName;
	private Long ejercicioId;
	
	public UserSession() {
		this.usuari="usuario";
		System.out.println("################ constructor UserSession");
	}
	
	@PostConstruct
	private void init () {
//		this.empresa=new Empresa(new Long(1),"empresa A","empresa A","ce ciutadella 25 2d","","palma","123456789","illes balears","971123456","company@putmail.com","07003");
//		this.setEjercicio(new Ejercicio(2016));
		System.out.println("################ init UserSession:"+empresaId);
	}
	public String getUsuari() {
		return usuari;
	}
	public void setUsuari(String usuari) {
		this.usuari = usuari;
	}

	public Long getEmpresaId() {
		return empresaId;
	}

	public void setEmpresaId(Long empresaId) {
		this.empresaId = empresaId;
	}

	public Long getEjercicioId() {
		return ejercicioId;
	}

	public void setEjercicioId(Long ejercicioId) {
		this.ejercicioId = ejercicioId;
	}

	public String getEmpresaName() {
		return empresaName;
	}

	public void setEmpresaName(String empresaName) {
		this.empresaName = empresaName;
	}

	
	
	

	
}