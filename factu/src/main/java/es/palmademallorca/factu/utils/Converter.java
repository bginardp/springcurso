package es.palmademallorca.factu.utils;

import es.palmademallorca.factu.dto.FacturaBasesDto;
import es.palmademallorca.factu.dto.TipivaDto;
import es.palmademallorca.factu.model.FacturaBases;
import es.palmademallorca.factu.model.Tipiva;

public class Converter {
	public static FacturaBases toDao(FacturaBasesDto dto) {
		FacturaBases dao = new FacturaBases(dto);
		return dao;
	}

	public static FacturaBasesDto toDdto(FacturaBases dao) {
		FacturaBasesDto dto = new FacturaBasesDto(dao);
		return dto;
	}

	public static TipivaDto toDdto(Tipiva tipiva) {
		TipivaDto dto = new TipivaDto(tipiva);
		return dto;
	}

	public static Tipiva toDao(TipivaDto tipiva) {
		Tipiva dao=new Tipiva(tipiva);
		return dao;
	}
}
