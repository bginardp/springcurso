package es.palmademallorca.factu.dto;

import java.math.BigDecimal;

public class FacImpuestoDto {
	// TODO afegir validacions s anivell d'atributs
	public String impuestId;
	public String impuestNom; // iva 1, iva 2, irpf, dto 
	public BigDecimal percentatge;
	public BigDecimal imp;
	
	
	public String getImpuestId() {
		return impuestId;
	}
	public void setImpuestId(String impuestId) {
		this.impuestId = impuestId;
	}
	public String getImpuestNom() {
		return impuestNom;
	}
	public void setImpuestNom(String impuestNom) {
		this.impuestNom = impuestNom;
	}
	public BigDecimal getPercentatge() {
		return percentatge;
	}
	public void setPercentatge(BigDecimal percentatge) {
		this.percentatge = percentatge;
	}
	public BigDecimal getImp() {
		return imp;
	}
	public void setImp(BigDecimal imp) {
		this.imp = imp;
	}
}
