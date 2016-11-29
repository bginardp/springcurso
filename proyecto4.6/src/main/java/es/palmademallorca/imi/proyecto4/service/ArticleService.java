package es.palmademallorca.imi.proyecto4.service;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.palmademallorca.imi.proyecto4.dto.ArticleDto;
import es.palmademallorca.imi.proyecto4.model.Author;
import es.palmademallorca.imi.proyecto4.model.Label;

public interface ArticleService {
	
	/**
	 * Devuelve la pagina de artículos solicitado
	 * según los filtros de búsqueda
	 * @param term	texto del usuario para filtrar
	 * 				puede ser null
	 * @param labels
	 * 				conjunto de labels para filtrar
	 * 				puede ser null
	 * @param visibles
	 * 				si es != null mostrará los artículos
	 * 				coincidentes con el argumento.
	 * @param pageRequest
	 * 				página solicitada
	 * @return
	 */
	Page<ArticleDto> getArticles(
			String term,
			Set<String> labels,
			Boolean visibles,
			Pageable pageRequest
			);
	ArticleDto getArticle(Long articleId);
	void removeArticle(Long articleId);
	void saveArticle(ArticleDto article);

	List<Label> findAllLabels();
	List<Author> findAllAuthors();
	Set<Label> getOrCreateLabels(String[] label);
}
