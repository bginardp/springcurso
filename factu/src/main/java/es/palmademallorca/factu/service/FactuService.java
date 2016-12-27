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
	public FormapagoDto getFormapago(long formapagoId);
	public ProductoDto getProducto(String productoId);
	public SerieDto getSerie(String serieId);
	public TipivaDto getTipoIva(long tipoivaId);
	ClienteDto getCliente(Long clienteId);
	FacturaDto getFactura(Long facturaId);
		
	void removeFormaPago(long formapagoId);
	void removeProducto(String productoId);
	void removeSerie(String serieId);
	void removeTipoiva(long tipoivaId);
	void removeCliente(Long clienteId);
	void removeFactura(Long facturaId);
	
	Long saveEmpresa(EmpresaDto empresaDto);
	void saveEjercicio(EjercicioDto ejercicioDto);
	Long saveFormapago(FormapagoDto formapagoDto);
	void saveProducto(ProductoDto productoDto);
	void saveSerie(SerieDto serieDto);
	Long saveTipiva(TipivaDto tipivaDto);
	void saveFactura(FacturaDto facturaDto,List<FacLinDto> detalleDto);
	Long saveCliente(ClienteDto clienteDto);	
	
		
	public Page<ClienteDto> getClientes(String term, Pageable pageRequest);
	public List<FacLinDto> getFaclinByFacturaId(Long facturaId);
	public List<FacImpuestoDto> getImpuestosFactura(Long facturaId);
	public Page<ProductoDto> getProductos(String term, Pageable pageRequest);
	public Page<FacturaDto> getFacturas(Long empresa, Long ejercicio,String term,Pageable pageRequest);
	
	public String init (long ejercicio, long empresaId);
	
	
	
}
