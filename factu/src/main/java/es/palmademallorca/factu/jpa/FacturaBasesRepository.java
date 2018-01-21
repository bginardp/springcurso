package es.palmademallorca.factu.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import es.palmademallorca.factu.model.FacturaBases;


public interface FacturaBasesRepository extends PagingAndSortingRepository<FacturaBases, Long> {


}