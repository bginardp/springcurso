package es.palmademallorca.factu.utils;

import es.palmademallorca.factu.dto.ClienteDto;
import es.palmademallorca.factu.dto.EjercicioDto;
import es.palmademallorca.factu.dto.EmpresaDto;
import es.palmademallorca.factu.dto.FacturaBasesDto;
import es.palmademallorca.factu.dto.FormapagoDto;
import es.palmademallorca.factu.dto.SerieDto;
import es.palmademallorca.factu.dto.TipivaDto;
import es.palmademallorca.factu.model.Cliente;
import es.palmademallorca.factu.model.Ejercicio;
import es.palmademallorca.factu.model.Empresa;
import es.palmademallorca.factu.model.FacturaBases;
import es.palmademallorca.factu.model.Formapago;
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

	

	
}
