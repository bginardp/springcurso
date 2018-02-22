package es.palmademallorca.factu.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import es.palmademallorca.factu.dto.FacturaDto;
import es.palmademallorca.factu.utils.Converter;

/**
 * The persistent class for the facturas database table.
 *
 */
@Entity
@Table(name = "facturas")
public class Factura {
	@Id
	@GeneratedValue(generator = "FacturaSeq")
	@SequenceGenerator(name = "FacturaSeq", sequenceName = "factu.factura_seq", allocationSize = 1)
	private Long id;
	private Long numero;
	@NotNull
	private Date dat;
	
	@Column(name = "serie_id")
	private String serieId;
	@NotNull
	@Column(name = "cliente_id")
	private Long clienteId;
	@NotNull
	@Column(name = "ejercicio_id")
	private Long ejercicioId;
	@NotNull
	@Column(name = "empresa_id")
	private Long empresaId;
	@Column(name = "forpag_id")
	private Long forpagId;
	private BigDecimal impbru;
	private BigDecimal porirpf;
	private BigDecimal pordto;
	private BigDecimal totfac;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "ejercicio_id", insertable = false, updatable = false)
	private Ejercicio ejercicio;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable=false, insertable = false, updatable = false)
	private Cliente cliente;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "empresa_id", nullable=false, insertable = false, updatable = false)
	private Empresa empresa;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "forpag_id", insertable = false, updatable = false)
	private Formapago formaspago;
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "empresa_id", referencedColumnName = "empresa_id", insertable = false, updatable = false),
			@JoinColumn(name = "serie_id", referencedColumnName = "id", insertable = false, updatable = false), })
	private Serie serie;
	@OneToMany(mappedBy = "factura", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Facturalin> detall;
	// bi-directional many-to-one association to Factureslin
	
	
	public Factura() {
	}

	public Factura(FacturaDto facturaDto) {
		this.id=facturaDto.getId();
		this.numero=facturaDto.getNumero();
		this.dat=facturaDto.getDat();
		this.serieId=facturaDto.getSerie()!=null?facturaDto.getSerie().getId():null;
		this.serie=Converter.toDao(facturaDto.getSerie());
		this.ejercicioId=facturaDto.getEjercicio().getId();
		this.ejercicio=Converter.toDao(facturaDto.getEjercicio());
		this.clienteId=facturaDto.getCliente().getId();
		this.cliente=Converter.toDao(facturaDto.getCliente());
		this.empresaId=facturaDto.getEmpresa().getId();
		this.empresa=Converter.toDao(facturaDto.getEmpresa());
		this.forpagId=facturaDto.getForpag().getId();
		this.formaspago=Converter.toDao(facturaDto.getForpag());
		this.impbru=facturaDto.getImpbru();
		this.porirpf=facturaDto.getPorirpf();
		this.pordto=facturaDto.getPordto();
		this.totfac=facturaDto.getTotfac();
		detall=new ArrayList<Facturalin>();
		facturaDto.getDetall().forEach(item-> {
			Facturalin detail =Converter.toDao(item);
			detail.setFactura(this);
			detall.add(detail);
		});
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


	
	public Long getClienteId() {
		return clienteId;
	}


	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}


	public Date getDat() {
		return dat;
	}


	public void setDat(Date dat) {
		this.dat = dat;
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


	public Long getForpagId() {
		return forpagId;
	}


	public void setForpagId(Long forpagId) {
		this.forpagId = forpagId;
	}


	public BigDecimal getImpbru() {
		return impbru;
	}


	public void setImpbru(BigDecimal impbru) {
		this.impbru = impbru;
	}

	public BigDecimal getPorirpf() {
		return porirpf;
	}

	public void setPorirpf(BigDecimal porirpf) {
		this.porirpf = porirpf;
	}

	public BigDecimal getPordto() {
		return pordto;
	}


	public void setPordto(BigDecimal pordto) {
		this.pordto = pordto;
	}


	public String getSerieId() {
		return serieId;
	}


	public void setSerieId(String serieId) {
		this.serieId = serieId;
	}


	public BigDecimal getTotfac() {
		return totfac;
	}


	public void setTotfac(BigDecimal totfac) {
		this.totfac = totfac;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Empresa getEmpresa() {
		return empresa;
	}


	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


	public Formapago getFormaspago() {
		return formaspago;
	}


	public void setFormaspago(Formapago formaspago) {
		this.formaspago = formaspago;
	}


	public Serie getSerie() {
		return serie;
	}


	public void setSerie(Serie serie) {
		this.serie = serie;
	}


	public Ejercicio getEjercicio() {
		return ejercicio;
	}


	public void setEjercicio(Ejercicio ejercicio) {
		this.ejercicio = ejercicio;
	}

	public List<Facturalin> getDetall() {
		return detall;
	}

	public void setDetall(List<Facturalin> detall) {
		this.detall = detall;
	}
	

}