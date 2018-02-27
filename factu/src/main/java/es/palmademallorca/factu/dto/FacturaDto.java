package es.palmademallorca.factu.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

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
public class FacturaDto extends ErrorsDto {
	private Long id;
	private Long numero;
	@NotNull
	// @DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dat;
	private ClienteDto cliente;
	private SerieDto serie;
	private EjercicioDto ejercicio;
	private EmpresaDto empresa;
	private FormapagoDto forpag;
	private List<FacLinDto> detall;
	private List<FacturaBasesDto> bases;
	private FacLinDto linea;
	private BigDecimal impbru;
	private BigDecimal pordto;
	private BigDecimal porirpf;
	private BigDecimal impirpf;
	private BigDecimal impdto;
	private BigDecimal totfac;

	public FacturaDto() {

	}

	public FacturaDto(Long id, Long numero, Date dat, SerieDto serie, ClienteDto cliente, EjercicioDto ejercicio,
			EmpresaDto empresa, FormapagoDto forpag, List<FacLinDto> detall, List<FacturaBasesDto> bases,
			FacLinDto linea, BigDecimal impbru, BigDecimal pordto, BigDecimal totfac, BigDecimal porirpf) {

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
		this.porirpf= porirpf;
		if (porirpf!=null && impbru!=null) {
			this.impirpf=porirpf.multiply(impbru).divide(new BigDecimal("100"));
			
		} else {
			this.impirpf=BigDecimal.ZERO;
		}
		this.impirpf = this.impirpf.setScale(2, BigDecimal.ROUND_HALF_UP);
		if (pordto!=null && impbru!=null) {
			this.impdto=pordto.multiply(impbru).divide(new BigDecimal("100"));
			
		} else {
			this.impdto=BigDecimal.ZERO;
		}
		this.impdto = this.impdto.setScale(2, BigDecimal.ROUND_HALF_UP);
		this.totfac = totfac;
		
	}

	public FacturaDto(Factura factura) {
		
		if (factura != null) {
			this.id = factura.getId();
			this.numero = factura.getNumero();
			this.dat = factura.getDat();
			this.serie = Converter.toDto(factura.getSerie());
			this.cliente = new ClienteDto(factura.getCliente());
			this.empresa = new EmpresaDto(factura.getEmpresa());
			this.ejercicio = new EjercicioDto(factura.getEjercicio());
			this.forpag = new FormapagoDto(factura.getFormaspago());
			this.impbru = factura.getImpbru();
			this.pordto = factura.getPordto();
			if (pordto!=null && impbru!=null) {
				this.impdto=pordto.multiply(impbru).divide(new BigDecimal("100"));
				this.impdto = this.impdto.setScale(2, BigDecimal.ROUND_HALF_UP);
			}
			this.totfac = factura.getTotfac();
			this.detall = Converter.toDto(factura.getDetall());
			this.porirpf = factura.getPorirpf();
			if (porirpf!=null && impbru!=null) {
				this.impirpf=porirpf.multiply(impbru).divide(new BigDecimal("100"));
				this.impirpf = this.impirpf.setScale(2, BigDecimal.ROUND_HALF_UP);
			}
			actualitzaTotals();
		}	
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
	
	
	public BigDecimal getPorirpf() {
		return porirpf;
	}

	public void setPorirpf(BigDecimal porirpf) {
		this.porirpf = porirpf;
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
				+ ", porirpf=" + porirpf + ", impdto=" + impdto + ", totfac=" + totfac + "]";
	}

	public void addLinea(FacLinDto linea, Integer index) {
		if (detall==null) {
			detall=new ArrayList<FacLinDto>();
		}
		if (index!=null && detall.size()>0) {
			List<FacLinDto> newDetall= new ArrayList<FacLinDto>();
			int i=0;
			for (FacLinDto facLinDto : detall) {
				if (index==i) {
					newDetall.add(linea);
				} else {newDetall.add(facLinDto);
				}
				i++;
			}
			detall=newDetall;
		} else {
			detall.add(linea);
		}
		actualitzaTotals();

	}
	
	public void removeLinea(Integer index) {
		if (index!=null &&index.intValue()>=0) {
			detall.remove(index.intValue());
			actualitzaTotals();
		}
		
	}
   public void editRow(Integer index) {
	   setLinea(getDetall().get(index.intValue()));
	}
	
	private void actualitzaTotals() {
		// 1 calculem bases
		bases=calculaBases();
		// 2 obtenim suma bases
		if (bases!=null) {
			impbru = bases
				 	.stream()
					.map(FacturaBasesDto::getBase)
					.reduce(BigDecimal::add)
					.get();
			BigDecimal sumimpostos = bases.stream().map(FacturaBasesDto::getImpiva).reduce(BigDecimal::add).get();
		// 3 sumem el irpf
			if (porirpf!=null && impbru!=null) {
				impirpf=porirpf.multiply(impbru).divide(new BigDecimal("100"));
			} else {
				impirpf=BigDecimal.ZERO;
			}
				
		// 4 sumem el total de la factura
			totfac= impbru.add(sumimpostos).add(impirpf);
		}
		
	}

	public boolean hasDetall() {
		return detall != null && detall.size() > 0;
	}
	
	public List<FacturaBasesDto> calculaBases() {
		List<FacturaBasesDto> bases = detall.stream()
				.filter(p->p.getTipiva()!=null && p.getPoriva()!=null)
			    .collect(Collectors.groupingBy(
			    	FacLinDto::getTipiva,
			        Collectors.groupingBy(
			        	FacLinDto::getPoriva,
			            Collectors.reducing(
			                BigDecimal.ZERO,
			                FacLinDto::getImporte,
			                BigDecimal::add))))
			    .entrySet()
			    .stream()
			    .flatMap(e1 -> e1.getValue()
			         .entrySet()
			         .stream()
			         .map(e2 -> new FacturaBasesDto(e1.getKey(), e2.getKey(), e2.getValue())))  //TipivaDto tipiva, BigDecimal por, BigDecimal requiv, BigDecimal base
			    .collect(Collectors.toList());
		return bases;
		
	}

	

	

}
