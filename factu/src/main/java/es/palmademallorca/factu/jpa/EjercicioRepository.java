package es.palmademallorca.factu.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import es.palmademallorca.factu.model.Ejercicio;


public interface EjercicioRepository extends PagingAndSortingRepository<Ejercicio, Long> {
    Ejercicio findFirstByOrderByIdDesc();


}