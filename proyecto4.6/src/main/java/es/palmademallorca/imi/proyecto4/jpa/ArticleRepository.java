package es.palmademallorca.imi.proyecto4.jpa;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import es.palmademallorca.imi.proyecto4.model.Article;

public interface ArticleRepository 
	extends PagingAndSortingRepository<Article, Long>{

}
