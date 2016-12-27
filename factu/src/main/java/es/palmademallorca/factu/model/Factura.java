package es.palmademallorca.factu.model;

import java.math.BigDecimal;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import es.palmademallorca.factu.dto.FacturaDto;

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
	private Date dat;
	@Column(name = "serie_id")
	private String serieId;
	@Column(name = "cliente_id")
	private Long clienteId;
	@Column(name = "ejercicio_id")
	private Long ejercicioId;
	@Column(name = "empresa_id")
	private Long empresaId;
	@Column(name = "forpag_id")
	private Long forpagId;
	private BigDecimal baseirpf;
	private BigDecimal baseiva1;
	private BigDecimal baseiva2;
	private BigDecimal impbru;
	private BigDecimal pordto;
	private BigDecimal impdto;
	private BigDecimal porirpf;
	private BigDecimal impirpf;
	private BigDecimal poriva1;
	private BigDecimal impiva1;
	private BigDecimal poriva2;
	private BigDecimal totfac;
	@ManyToOne
	@JoinColumn(name = "cliente_id", insertable = false, updatable = false)
	private Cliente cliente;
	@ManyToOne
	@JoinColumn(name = "empresa_id", insertable = false, updatable = false)
	private Empresa empresa;
	@ManyToOne
	@JoinColumn(name = "forpag_id", insertable = false, updatable = false)
	private Formapago formaspago;
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "empresa_id", referencedColumnName = "empresa_id", insertable = false, updatable = false),
			@JoinColumn(name = "serie_id", referencedColumnName = "id", insertable = false, updatable = false), })
	private Serie serie;
//	@OneToMany(mappedBy = "factura", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
//	private List<Facturalin> factureslins;
	// bi-directional many-to-one association to Factureslin
	
	
	public Factura() {
	}


	public Factura(FacturaDto facturaDto) {
		// TODO Auto-generated constructor stub
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


	public BigDecimal getBaseirpf() {
		return baseirpf;
	}


	public void setBaseirpf(BigDecimal baseirpf) {
		this.baseirpf = baseirpf;
	}


	public BigDecimal getBaseiva1() {
		return baseiva1;
	}


	public void setBaseiva1(BigDecimal baseiva1) {
		this.baseiva1 = baseiva1;
	}


	public BigDecimal getBaseiva2() {
		return baseiva2;
	}


	public void setBaseiva2(BigDecimal baseiva2) {
		this.baseiva2 = baseiva2;
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


	public BigDecimal getPorirpf() {
		return porirpf;
	}


	public void setPorirpf(BigDecimal porirpf) {
		this.porirpf = porirpf;
	}


	public BigDecimal getImpirpf() {
		return impirpf;
	}


	public void setImpirpf(BigDecimal impirpf) {
		this.impirpf = impirpf;
	}


	public BigDecimal getPoriva1() {
		return poriva1;
	}


	public void setPoriva1(BigDecimal poriva1) {
		this.poriva1 = poriva1;
	}


	public BigDecimal getImpiva1() {
		return impiva1;
	}


	public void setImpiva1(BigDecimal impiva1) {
		this.impiva1 = impiva1;
	}


	public BigDecimal getPoriva2() {
		return poriva2;
	}


	public void setPoriva2(BigDecimal poriva2) {
		this.poriva2 = poriva2;
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


//	public List<Facturalin> getFactureslins() {
//		return factureslins;
//	}
//
//
//	public void setFactureslins(List<Facturalin> factureslins) {
//		this.factureslins = factureslins;
//	}
	
	
/*
   
    @Transient
	public BigDecimal getImpirpf() {
		return impirpf.getValue();
	}

    public SimpleObjectProperty<BigDecimal> impirpfProperty() {
		return this.impirpf;
	}

	
	@PostLoad
	 protected void initTransientAttributes() {
		BigDecimal imp;
		if (poriva1!=null && baseiva1!=null) {
			imp=(poriva1.getValue().multiply(baseiva1.getValue())).divide(FactuApp.CIEN);
			impiva1.set(Utils.round(imp.doubleValue(),3));
		}
		else impiva1.set(new BigDecimal(FactuApp.CERO));
		if (porirpf!=null && baseirpf!=null) {
			imp=(porirpf.getValue().multiply(baseirpf.getValue())).divide(FactuApp.CIEN);
			impirpf.set(Utils.round(imp.doubleValue(),3));
		}
		else impirpf.set(new BigDecimal(FactuApp.CERO));
	}
*/
}