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
@NamedQueries({ @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
		@NamedQuery(name = "Factura.findByEmp", query = "SELECT f FROM Factura f WHERE f.empresaId = :empresa_id"),
		@NamedQuery(name = "Factura.findByEmpEje", query = "SELECT f FROM Factura f WHERE f.empresaId = :empresa_id AND f.ejercicioId=:ejercicio"),
		@NamedQuery(name = "Factura.findFacturasByString", query = "SELECT f FROM Factura f WHERE f.empresaId = :empresa_id AND f.ejercicioId=:ejercicio"
				+ "  AND (f.cliente.nom like :criteria)" + " ORDER BY f.numero"),
		@NamedQuery(name = "Factura.findFacturasByNumber", query = "SELECT f FROM Factura f WHERE f.empresaId = :empresa_id AND f.ejercicioId=:ejercicio"
				+ "  AND (f.numero = :numero OR f.totfac = :totfac)" + " ORDER BY f.numero"),
		@NamedQuery(name = "Factura.findFacturasByDate", query = "SELECT f FROM Factura f WHERE f.empresaId = :empresa_id AND f.ejercicioId=:ejercicio"
				+ " AND (f.dat = :criteria)" + " ORDER BY f.numero")

})
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
	@OneToMany(mappedBy = "factura", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Facturalin> factureslins;
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


	public List<Facturalin> getFactureslins() {
		return factureslins;
	}


	public void setFactureslins(List<Facturalin> factureslins) {
		this.factureslins = factureslins;
	}
	
	

/*	@Access(AccessType.PROPERTY)
	public Long getId() {
		return this.idProperty().get();
	}

	public void setId(Long id) {
		this.idProperty().set(id);
	}

	public LongProperty idProperty() {
		return this.id;
	}

	@Column(name = "cliente_id")
	public long getClienteId() {
		return this.clienteIdProperty().get();
	}

	public void setClienteId(long clienteId) {
		this.clienteIdProperty().set(clienteId);
	}

	public LongProperty clienteIdProperty() {
		return this.clienteId;
	}

	@Column(name = "serie_id")
	public java.lang.String getSerieId() {
		return this.serieIdProperty().get();
	}

	public void setSerieId(final java.lang.String serieId) {
		this.serieIdProperty().set(serieId);
	}

	public SimpleStringProperty serieIdProperty() {
		return this.serieId;

	}

	public ObjectProperty<LocalDate> datProperty() {
		return dat;
	}

	@Column(name = "DAT")
	public LocalDate getDat() {
		return datProperty().get();
	}

	public void setDat(LocalDate dat) {
		datProperty().set(dat);
	}

	@Column(name = "empresa_id")
	public Long getEmpresaId() {
		return this.empresaId.get();
	}

	public void setEmpresaId(Long empresaId) {
		this.empresaId.set(empresaId);
	}

	@Column(name = "forpag_id")
	public Long getForpagId() {
		return this.forpagId.get();
	}

	public void setForpagId(Long forpagId) {
		this.forpagId.set(forpagId);
	}

	@ManyToOne
	@JoinColumn(name = "cliente_id", insertable = false, updatable = false)
	public Cliente getCliente() {
		return this.clienteProperty().get();
	}

	public void setCliente(Cliente cliente) {
		this.clienteProperty().set(cliente);
	}

	public SimpleObjectProperty<Cliente> clienteProperty() {
		return this.cliente;
	}

	public String getNomCliente() {
		return this.getCliente().getNom();
	}

	// uni-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name = "empresa_id", insertable = false, updatable = false)
	public Empresa getEmpresa() {
		return this.empresa.get();
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa.set(empresa);
	}

	public SimpleObjectProperty<Empresa> empresaProperty() {
		return this.empresa;
	}

	// uni-directional many-to-one association to Formaspago
	@ManyToOne
	@JoinColumn(name = "forpag_id", insertable = false, updatable = false)
	public Formaspago getFormaspago() {
		return this.formaspago.get();
	}

	public void setFormaspago(Formaspago formaspago) {
		this.formaspago.set(formaspago);
	}

	public SimpleObjectProperty<Formaspago> formaspagoProperty() {
		return this.formaspago;
	}

	// uni-directional many-to-one association to Serie
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "empresa_id", referencedColumnName = "empresa_id", insertable = false, updatable = false),
			@JoinColumn(name = "serie_id", referencedColumnName = "id", insertable = false, updatable = false), })
	public Serie getSerie() {
		return this.serie.get();
	}

	public void setSerie(Serie serie) {
		this.serie.set(serie);
	}

	public SimpleObjectProperty<Serie> serieProperty() {
		return this.serie;
	}

	@OneToMany(mappedBy = "factura", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	public List<Factureslin> getFactureslins() {
		return this.factureslins;
	}

	public void setFactureslins(List<Factureslin> factureslins) {
		this.factureslins = factureslins;
	}

	public Factureslin addFactureslin(Factureslin factureslin) {
		getFactureslins().add(factureslin);
		factureslin.setFactura(this);

		return factureslin;
	}

	public Factureslin removeFactureslin(Factureslin factureslin) {
		getFactureslins().remove(factureslin);
		factureslin.setFactura(null);

		return factureslin;
	}

	public SimpleObjectProperty<BigDecimal> baseirpfProperty() {
		return this.baseirpf;
	}

	public java.math.BigDecimal getBaseirpf() {
		return this.baseirpfProperty().get();
	}

	public void setBaseirpf(final java.math.BigDecimal baseirpf) {
		this.baseirpfProperty().set(baseirpf);
	}

	public SimpleObjectProperty<BigDecimal> baseiva1Property() {
		return this.baseiva1;
	}

	public java.math.BigDecimal getBaseiva1() {
		return this.baseiva1Property().get();
	}

	public void setBaseiva1(final java.math.BigDecimal baseiva1) {
		this.baseiva1Property().set(baseiva1);
	}

	public SimpleObjectProperty<BigDecimal> baseiva2Property() {
		return this.baseiva2;
	}

	public java.math.BigDecimal getBaseiva2() {
		return this.baseiva2Property().get();
	}

	public void setBaseiva2(final java.math.BigDecimal baseiva2) {
		this.baseiva2Property().set(baseiva2);
	}

	public SimpleObjectProperty<BigDecimal> impbruProperty() {
		return this.impbru;
	}

	public java.math.BigDecimal getImpbru() {
		return this.impbruProperty().get();
	}

	public void setImpbru(final java.math.BigDecimal impbru) {
		this.impbruProperty().set(impbru);
	}

	public SimpleObjectProperty<BigDecimal> impdtoProperty() {
		return this.impdto;
	}

	public java.math.BigDecimal getImpdto() {
		return this.impdtoProperty().get();
	}

	public void setImpdto(final java.math.BigDecimal impdto) {
		this.impdtoProperty().set(impdto);
	}

	public LongProperty numeroProperty() {
		return this.numero;
	}

	public long getNumero() {
		return this.numeroProperty().get();
	}

	public void setNumero(final long numero) {
		this.numeroProperty().set(numero);
	}

	public SimpleObjectProperty<BigDecimal> porirpfProperty() {
		return this.porirpf;
	}

	public java.math.BigDecimal getPorirpf() {
		return this.porirpfProperty().get();
	}

	public void setPorirpf(final java.math.BigDecimal porirpf) {
		this.porirpfProperty().set(porirpf);
	}

	public final SimpleObjectProperty<BigDecimal> poriva1Property() {
		return this.poriva1;
	}

	public java.math.BigDecimal getPoriva1() {
		return this.poriva1Property().get();
	}

	public void setPoriva1(final java.math.BigDecimal poriva1) {
		this.poriva1Property().set(poriva1);
	}

	public SimpleObjectProperty<BigDecimal> poriva2Property() {
		return this.poriva2;
	}

	public java.math.BigDecimal getPoriva2() {
		return this.poriva2Property().get();
	}

	public void setPoriva2(final java.math.BigDecimal poriva2) {
		this.poriva2Property().set(poriva2);
	}

	public SimpleObjectProperty<BigDecimal> totfacProperty() {
		return this.totfac;
	}

	public java.math.BigDecimal getTotfac() {
		return this.totfacProperty().get();
	}

	public void setTotfac(final java.math.BigDecimal totfac) {
		this.totfacProperty().set(totfac);
	}

	public IntegerProperty ejercicioIdProperty() {
		return this.ejercicioId;
	}

	@Column(name = "ejercicio_id")
	public int getEjercicioId() {
		return this.ejercicioIdProperty().get();
	}

	public void setEjercicioId(final int ejercicioId) {
		this.ejercicioIdProperty().set(ejercicioId);
	}

	public SimpleObjectProperty<BigDecimal> pordtoProperty() {
		return this.pordto;
	}

	public java.math.BigDecimal getPordto() {
		return this.pordtoProperty().get();
	}

	public void setPordto(final java.math.BigDecimal pordto) {
		this.pordtoProperty().set(pordto);
	}
    @Transient
	public BigDecimal getImpiva1() {
		return impiva1.getValue();
	}

    public SimpleObjectProperty<BigDecimal> impiva1Property() {
		return this.impiva1;
	}
    
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