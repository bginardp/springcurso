package es.palmademallorca.factu.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import es.palmademallorca.factu.dto.common.ErrorDto;
import es.palmademallorca.factu.dto.common.ErrorsDto;
import es.palmademallorca.factu.model.Factura;
import es.palmademallorca.factu.utils.Converter;

/**
 * @author bernat
 *
 */
public class FacturaDto extends ErrorsDto{
	private Long id;
	private Long numero;
	@NotNull
//	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dat;
	private ClienteDto cliente;
	@NotNull
	private SerieDto serie;
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
	
	
	
public FacturaDto(Long id, Long numero, Date dat, SerieDto serie, ClienteDto cliente, EjercicioDto ejercicio, EmpresaDto empresa, FormapagoDto forpag, List<FacLinDto> detall,
			List<FacturaBasesDto> bases, FacLinDto linea, BigDecimal impbru, BigDecimal pordto, BigDecimal impdto,
			BigDecimal totfac) {
		
		this.id = id;
		this.numero = numero;
		this.dat = dat;
		this.serie = serie;
		this.cliente = cliente;
		this.ejercicio = ejercicio;
		this.empresa = empresa;
		this.forpag = forpag;
		this.detall = detall;
		this.bases = bases;
		this.linea = linea;
		this.impbru = impbru;
		this.pordto = pordto;
		this.impdto = impdto;
		this.totfac = totfac;
	}

	
	public FacturaDto(Factura factura) {
		this.id = factura.getId();
		this.numero = factura.getNumero();
		this.dat = factura.getDat();
		this.serie = Converter.toDto(factura.getSerie());
		this.cliente=new ClienteDto(factura.getCliente());
		this.empresa=new EmpresaDto(factura.getEmpresa());
		this.ejercicio = new EjercicioDto(factura.getEjercicio());
		this.forpag = new FormapagoDto(factura.getFormaspago());
		this.impbru=factura.getImpbru();
		this.pordto=factura.getPordto();
		this.impdto=factura.getImpdto();
		this.totfac=factura.getTotfac();
		this.detall=Converter.toDto(factura.getDetall());
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
	
	public SerieDto getSerie() {
		return serie;
	}

	public void setSerie(SerieDto serie) {
		this.serie = serie;
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
		return "FacturaDto [id=" + id + ", numero=" + numero + ", dat=" + dat + ", cliente=" + cliente + ", serie="
				+ serie + ", ejercicio=" + ejercicio + ", empresa=" + empresa + ", forpag=" + forpag + ", detall="
				+ detall + ", bases=" + bases + ", linea=" + linea + ", impbru=" + impbru + ", pordto=" + pordto
				+ ", impdto=" + impdto + ", totfac=" + totfac + "]";
	}



	public void addLinea(FacLinDto facLinDto) {
		// TODO Auto-generated method stub
		detall.add(facLinDto);
		actualitzaBases();
		
	}
	private void actualitzaBases() {
		bases.clear();
		
		for (FacLinDto lin : detall) {
		   if (lin.getTipiva() != null) {
			   if (bases.isEmpty()) {
				   bases.add(new FacturaBasesDto(lin.getTipiva(),lin.getPoriva(),lin.getRequiv(),lin.getImporte()));   
			   } else {
			   }
		   }
		}
	}
	
	public boolean hasDetall( ) {
		return detall!=null && detall.size()>0;
	}
			  


}
