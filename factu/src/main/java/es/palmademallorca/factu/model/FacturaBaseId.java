package es.palmademallorca.factu.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class FacturaBaseId implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long facturaId;
	private Long seq;
	
	public FacturaBaseId() {
		
	}

	public Long getFacturaId() {
		return facturaId;
	}

	public void setFacturaId(Long facturaId) {
		this.facturaId = facturaId;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}
	
	

}
