package es.palmademallorca.factu.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import es.palmademallorca.factu.dto.common.ErrorsDto;
import es.palmademallorca.factu.model.Factura;

/**
 * @author BERNAT1
 *
 */
public class FacturaDto extends ErrorsDto{
	private Long id;
	private Long numero;
	@NotNull
//	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dat;
	private String serieId;
	private String serieDec;
	private ClienteDto cliente;
	@NotNull
	private EjercicioDto ejercicio;
	private EmpresaDto empresa;
	private FormapagoDto forpag;
	private List<FacLinDto> detall;
	private List<FacturaBasesDto> bases;
	private FacLinDto linea;
	private BigDecimal impbru;
	private BigDecimal pordto;
	private BigDecimal impdto;
	private BigDecimal totfac;
	
	
	public FacturaDto() {
	
	}
//	public FacturaDto(Long id, Long numero, Date dat, String serieId, String serieDec, Long clienteId,
//			String clienteNom, Long ejercicioId, Long empresaId, String empresaNom, Long forpagId, String forPagDem) {
//		this.id = id;
//		this.numero = numero;
//		this.dat = dat;
//		this.serieId = serieId;
//		this.serieDec = serieDec;
//		this.clienteId = clienteId;
//		this.clienteNom = clienteNom;
//		this.ejercicioId = ejercicioId;
//		this.empresaId = empresaId;
//		this.empresaNom = empresaNom;
//		this.forpagId = forpagId;
//		this.forPagDem = forPagDem;
//	}
	public FacturaDto(Factura factura) {
		this.id = factura.getId();
		this.numero = factura.getNumero();
		this.dat = factura.getDat();
		this.serieId = factura.getSerieId();
		this.serieDec = factura.getSerie().getDec();
		this.cliente=new ClienteDto(factura.getCliente());
		this.empresa=new EmpresaDto(factura.getEmpresa());
		this.ejercicio = new EjercicioDto(factura.getEjercicio());
		this.forpag = new FormapagoDto(factura.getFormaspago());
		this.impbru=factura.getImpbru();
		this.pordto=factura.getPordto();
		this.impdto=factura.getImpdto();
		this.totfac=factura.getTotfac();
		this.bases=null; //TODO 
 		
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
	public ClienteDto getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDto cliente) {
		this.cliente = cliente;
	}
	public EjercicioDto getEjercicio() {
		return ejercicio;
	}
	public void setEjercicio(EjercicioDto ejercicio) {
		this.ejercicio = ejercicio;
	}
	public EmpresaDto getEmpresa() {
		return empresa;
	}
	public void setEmpresa(EmpresaDto empresa) {
		this.empresa = empresa;
	}
	public FormapagoDto getForpag() {
		return forpag;
	}
	public void setForpag(FormapagoDto forpag) {
		this.forpag = forpag;
	}
	public List<FacLinDto> getDetall() {
		return detall;
	}
	public void setDetall(List<FacLinDto> detall) {
		this.detall = detall;
	}
	public List<FacturaBasesDto> getBases() {
		return bases;
	}
	public void setBases(List<FacturaBasesDto> bases) {
		this.bases = bases;
	}
	public FacLinDto getLinea() {
		return linea;
	}
	public void setLinea(FacLinDto linea) {
		this.linea = linea;
	}
	public BigDecimal getImpbru() {
		return impbru;
	}
	public void setImpbru(BigDecimal impbru) {
		this.impbru = impbru;
	}
	public BigDecimal getPordto() {
		return pordto;
	}
	public void setPordto(BigDecimal pordto) {
		this.pordto = pordto;
	}
	public BigDecimal getImpdto() {
		return impdto;
	}
	public void setImpdto(BigDecimal impdto) {
		this.impdto = impdto;
	}
	public BigDecimal getTotfac() {
		return totfac;
	}
	public void setTotfac(BigDecimal totfac) {
		this.totfac = totfac;
	}
	@Override
	public String toString() {
		return "FacturaDto [id=" + id + ", numero=" + numero + ", dat=" + dat + ", serieId=" + serieId + ", serieDec="
				+ serieDec + ", cliente=" + cliente + ", ejercicio=" + ejercicio + ", empresa=" + empresa + ", forpag="
				+ forpag + ", detall=" + detall + ", bases=" + bases + ", linea=" + linea + ", impbru=" + impbru
				+ ", pordto=" + pordto + ", impdto=" + impdto + ", totfac=" + totfac + "]";
	}
			  
	
	
	
	
	

}
