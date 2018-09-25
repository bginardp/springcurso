package es.palmademallorca.factu.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.palmademallorca.factu.dto.ClienteDto;
import es.palmademallorca.factu.dto.FacLinDto;
import es.palmademallorca.factu.dto.FacturaDto;
import es.palmademallorca.factu.dto.FormapagoDto;
import es.palmademallorca.factu.dto.ProductoDto;
import es.palmademallorca.factu.dto.SerieDto;
import es.palmademallorca.factu.dto.TipivaDetDto;
import es.palmademallorca.factu.dto.TipivaDto;

public interface FactuService {
	// tipologias
	
	
    public List<FormapagoDto> findAllFormaspago();
    public List<ProductoDto> findAllProductos();
    public List<SerieDto> findSeriesByEmpresaId(Long empresaId);
    public List<SerieDto> findAllSeries();
    public List<TipivaDto> findAllTiposIva();
    public List<TipivaDetDto> findAllTiposIvaDet();
    public List<ClienteDto> findAllClientes();
    public List<FacturaDto> findAllFacturas();
    
    
	
	FormapagoDto getFormapago(long formapagoId);
	ProductoDto getProducto(String productoId);
	SerieDto getSerie(String serieId);
	TipivaDto getTipIva(String id);
	TipivaDetDto getTipivaDet(Long id);
	TipivaDetDto getTipivaDetVigent(String tipivaId, Date data);
	
	
	ClienteDto getCliente(Long clienteId);
	FacturaDto getFactura(Long facturaId);
	FacturaDto getFactura(Long clienteId, Long empresaId, Long forpagId, Date dat, BigDecimal totfac);
	FacLinDto getFaclin(Long faclinId);
	
	
	void removeFormaPago(long formapagoId);
	void removeProducto(String productoId);
	void removeSerie(String serieId);
	void removeTipiva(String id);
	void removeCliente(Long clienteId);
	void removeFactura(Long facturaId);
	void removeTipivaDet(long id);
	
	
	
	Long saveFormapago(FormapagoDto formapagoDto);
	void saveProducto(ProductoDto productoDto);
	void saveSerie(SerieDto serieDto);
	void saveTipiva(TipivaDto tipivaDto);
	Long saveTipivaDet(TipivaDetDto tipivaDetDto);
	FacturaDto saveFactura(FacturaDto facturaDto);
	Long saveFaclin(FacLinDto faclinDto);
	Long saveCliente(ClienteDto clienteDto);	
	
		
	public Page<ClienteDto> getClientes(String term, Pageable pageRequest);
	public List<FacLinDto> getFaclinByFacturaId(Long facturaId);
//	public List<FacturaBasesDto> getImpuestosFactura(Long facturaId);
	public Page<ProductoDto> getProductos(String term, Pageable pageRequest);
	public Page<FacturaDto> getFacturas(Long empresa, Long ejercicio,String term,Pageable pageRequest);
	
	public String init (long ejercicio, long empresaId);
	
	
	
}
