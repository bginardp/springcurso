package es.palmademallorca.factu.session;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import es.palmademallorca.factu.model.Ejercicio;
import es.palmademallorca.factu.model.Empresa;

@Component
@Scope("session")
// @Scope("singleton")
public class UserPreferences {
	private String usuari;
	private Empresa empresa;
	private Ejercicio ejercicio;
	
	public UserPreferences() {
		System.out.println("################ constructor UserPreferences");
	}
	
	@PostConstruct
	private void init () {
		this.empresa=new Empresa(new Long(1),"empresa A","empresa A","ce ciutadella 25 2d","","palma","123456789","illes balears","971123456","company@putmail.com");
		this.ejercicio=new Ejercicio(2016);
	}
	public String getUsuari() {
		return usuari;
	}
	public void setUsuari(String usuari) {
		this.usuari = usuari;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public Ejercicio getEjercicio() {
		return ejercicio;
	}
	public void setEjercicio(Ejercicio ejercicio) {
		this.ejercicio = ejercicio;
	}

	
}