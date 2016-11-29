package es.palmademallorca.imi.proyecto4.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import es.palmademallorca.imi.proyecto4.model.Author;

public interface AuthorRepository 
	extends PagingAndSortingRepository<Author, Long>{

}
