package es.palmademallorca.factu.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.palmademallorca.factu.dto.ClienteDto;
import es.palmademallorca.factu.dto.EjercicioDto;
import es.palmademallorca.factu.dto.EmpresaDto;
import es.palmademallorca.factu.dto.FacImpuestoDto;
import es.palmademallorca.factu.dto.FacLinDto;
import es.palmademallorca.factu.dto.FacturaDto;
import es.palmademallorca.factu.dto.FormapagoDto;
import es.palmademallorca.factu.dto.ProductoDto;
import es.palmademallorca.factu.dto.SerieDto;
import es.palmademallorca.factu.dto.TipivaDto;
import es.palmademallorca.factu.model.Ejercicio;
import es.palmademallorca.factu.model.Empresa;
import es.palmademallorca.factu.model.Formapago;
import es.palmademallorca.factu.model.Producto;
import es.palmademallorca.factu.model.Serie;
import es.palmademallorca.factu.model.Tipiva;

public interface FactuService {
	// tipologias
	public List<EmpresaDto> findAllEmpresas();
	public List<EjercicioDto> findAllEjercicios();
    public List<FormapagoDto> findAllFormaspago();
    public List<ProductoDto> findAllProductos();
    public List<SerieDto> findAllSeries();
    public List<TipivaDto> findAllTiposIva();
    
    public EmpresaDto getEmpresa(long empresaId);
	public EjercicioDto getEjercicio(long ejercicioId);
	public FormapagoDto getForpapago(long formapagoId);
	public ProductoDto getProducto(String productoId);
	public SerieDto getSerie(String serieId);
	public TipivaDto getTipoIva(long tipoivaId);
	
	void removeFormaPago(long formapagoId);
	void removeProducto(String productoId);
	void removeSerie(String serieId);
	void removeTipoiva(long tipoivaId);
	
	void saveEmpresa(EmpresaDto empresaDto);
	void saveEjercicio(EjercicioDto ejercicioDto);
	void saveFormapago(FormapagoDto formapagoDto);
	void saveProducto(ProductoDto productoDto);
	void saveSerie(SerieDto serieDto);
	void saveTipiva(TipivaDto tipivaDto);
	
		
	// clientes
	public Page<ClienteDto> getClientes(String term, Pageable pageRequest);
	ClienteDto getCliente(Long clienteId);
	void removeCliente(Long clienteId);
	void saveCliente(ClienteDto clienteDto);
	// facturas
	public Page<FacturaDto> findFacturasByTerm(Long empresa, Long ejercicio,String term,Pageable pageRequest);
	public List<FacLinDto> findFaclinByFacturaId(Long facturaId);
	public List<FacImpuestoDto> getImpuestosFactura(Long facturaId);
	FacturaDto getFactura(Long facturaId);
	void saveFactura(FacturaDto facturaDto,List<FacLinDto> detalleDto);
	void removeFactura(Long facturaId);
	// otros
	public String init (long ejercicio, long empresaId);
	
	
}
