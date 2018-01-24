package es.palmademallorca.factu.utils;

import java.util.ArrayList;
import java.util.List;

import es.palmademallorca.factu.dto.ClienteDto;
import es.palmademallorca.factu.dto.EjercicioDto;
import es.palmademallorca.factu.dto.EmpresaDto;
import es.palmademallorca.factu.dto.FacLinDto;
import es.palmademallorca.factu.dto.FacturaDto;
import es.palmademallorca.factu.dto.FormapagoDto;
import es.palmademallorca.factu.dto.ProductoDto;
import es.palmademallorca.factu.dto.SerieDto;
import es.palmademallorca.factu.dto.TipivaDto;
import es.palmademallorca.factu.model.Cliente;
import es.palmademallorca.factu.model.Ejercicio;
import es.palmademallorca.factu.model.Empresa;
import es.palmademallorca.factu.model.Factura;
import es.palmademallorca.factu.model.Facturalin;
import es.palmademallorca.factu.model.Formapago;
import es.palmademallorca.factu.model.Producto;
import es.palmademallorca.factu.model.Serie;
import es.palmademallorca.factu.model.Tipiva;

public class Converter {
	

//	public static FacturaBasesDto toDdto(FacturaBases dao) {
//		FacturaBasesDto dto = new FacturaBasesDto(dao);
//		return dto;
//	}

	public static TipivaDto toDdto(Tipiva tipiva) {
		TipivaDto dto = new TipivaDto(tipiva);
		return dto;
	}
	
	public static SerieDto toDto(Serie dao) {
	    SerieDto dto = new SerieDto(dao);
		return dto;
	}
	
	public static EjercicioDto toDto(Ejercicio ejercicio) {
		EjercicioDto dto=new EjercicioDto(ejercicio);
		return dto;
	}
	
	public static FacturaDto toDto(Factura factura) {
		FacturaDto dto=new FacturaDto(factura);
		return dto;
	}
	
	public static List<FacLinDto> toDto(List<Facturalin> detall) {
		List<FacLinDto> dto= new ArrayList<FacLinDto>();
		if (detall!=null) {
		   detall.forEach(lin->dto.add(Converter.toDto(lin)));
		}
		return dto;
	}

	private static FacLinDto toDto(Facturalin lin) {
		FacLinDto dto = new FacLinDto(lin);
		return dto;
	}
	
	public static ProductoDto toDto(Producto dao) {
		ProductoDto dto = new ProductoDto(dao);
		return dto;
	}
	
//	public static FacturaBases toDao(FacturaBasesDto dto) {
//		FacturaBases dao = new FacturaBases(dto);
//		return dao;
//	}

	public static Tipiva toDao(TipivaDto tipiva) {
		Tipiva dao=new Tipiva(tipiva);
		return dao;
	}

	public static Serie toDao(SerieDto dto) {
		Serie dao=new Serie(dto);
		return dao;
	}

	public static Ejercicio toDao(EjercicioDto dto) {
		Ejercicio dao=new Ejercicio(dto);
		return dao;
	}

	public static Cliente toDao(ClienteDto dto) {
		Cliente dao=new Cliente(dto);
		return dao;
	}

	public static Empresa toDao(EmpresaDto dto) {
		Empresa dao=new Empresa(dto);
		return dao;
	}

	public static Formapago toDao(FormapagoDto dto) {
		Formapago dao=new Formapago(dto);
		return dao;
	}

	public static Producto toDao(ProductoDto dto) {
		Producto dao=new Producto(dto);
		return dao;
	}

	

	

	

	

	
}
