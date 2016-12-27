package es.palmademallorca.factu.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.palmademallorca.factu.model.Factura;

public class FacturaDto {
	// TODO afegir validacions s anivell d'atributs
	private Long id;
	private Long numero;
	@NotNull
	private Date dat;
	@NotNull
	private String serieId;
	private String serieDec;
	@NotNull
	private Long clienteId;
	private String clienteNom;
	@NotNull
	private Long ejercicioId;
	@NotNull
	private Long empresaId;
	private String empresaNom;
	private Long forpagId;
	private String forPagDem;
	
	public FacturaDto() {
	
	}
	public FacturaDto(Long id, Long numero, Date dat, String serieId, String serieDec, Long clienteId,
			String clienteNom, Long ejercicioId, Long empresaId, String empresaNom, Long forpagId, String forPagDem) {
		this.id = id;
		this.numero = numero;
		this.dat = dat;
		this.serieId = serieId;
		this.serieDec = serieDec;
		this.clienteId = clienteId;
		this.clienteNom = clienteNom;
		this.ejercicioId = ejercicioId;
		this.empresaId = empresaId;
		this.empresaNom = empresaNom;
		this.forpagId = forpagId;
		this.forPagDem = forPagDem;
	}
	public FacturaDto(Factura factura) {
		this.id = factura.getId();
		this.numero = factura.getNumero();
		this.dat = factura.getDat();
		this.serieId = factura.getSerieId();
		this.serieDec = factura.getSerie().getDec();
		this.clienteId = factura.getClienteId();
		this.clienteNom = factura.getCliente().getNom();
		this.ejercicioId = factura.getEjercicioId();
		this.empresaId = factura.getEmpresaId();
		this.empresaNom = factura.getEmpresa().getDec();
		this.forpagId = factura.getForpagId();
		this.forPagDem = factura.getFormaspago().getDem();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public Date getDat() {
		return dat;
	}
	public void setDat(Date dat) {
		this.dat = dat;
	}
	public String getSerieId() {
		return serieId;
	}
	public void setSerieId(String serieId) {
		this.serieId = serieId;
	}
	public String getSerieDec() {
		return serieDec;
	}
	public void setSerieDec(String serieDec) {
		this.serieDec = serieDec;
	}
	public Long getClienteId() {
		return clienteId;
	}
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}
	public String getClienteNom() {
		return clienteNom;
	}
	public void setClienteNom(String clienteNom) {
		this.clienteNom = clienteNom;
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
	public String getEmpresaNom() {
		return empresaNom;
	}
	public void setEmpresaNom(String empresaNom) {
		this.empresaNom = empresaNom;
	}
	public Long getForpagId() {
		return forpagId;
	}
	public void setForpagId(Long forpagId) {
		this.forpagId = forpagId;
	}
	public String getForPagDem() {
		return forPagDem;
	}
	public void setForPagDem(String forPagDem) {
		this.forPagDem = forPagDem;
	}

}
