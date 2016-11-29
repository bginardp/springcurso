package es.palmademallorca.imi.proyecto4.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import es.palmademallorca.imi.proyecto4.model.Label;

public interface LabelRepository 
	extends PagingAndSortingRepository<Label, String>{

}
